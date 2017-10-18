package com.example.pancho.homeawaychallenge.view.detailsview;

import com.example.pancho.homeawaychallenge.entitites.DaoSession;
import com.example.pancho.homeawaychallenge.entitites.Likes;
import com.example.pancho.homeawaychallenge.entitites.LikesDao;

import org.greenrobot.greendao.query.DeleteQuery;

/**
 * Created by Francisco on 10/18/2017.
 */

public class DetailsPresenter implements DetailsContract.Presenter {
    DetailsContract.View view;
    private static final String TAG = "DetailsPresenter";

    @Override
    public void attachView(DetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    /**
     * Make a query to verify if the id exists
     *      If exists then it means that it has a like
     **/
    @Override
    public void localquery(DaoSession daoSession, String id) {
        view.sendResult(daoSession.queryBuilder(Likes.class)
                .where(LikesDao.Properties.Id.eq(id))
                .list());
    }

    /**
     * Verify if the element is checked or not to add/remove it from the db
     **/
    @Override
    public void saveChecked(DaoSession daoSession, boolean checked, String id) {
        if(checked)
            daoSession.insert(new Likes(null, id));
        else {
            final DeleteQuery<Likes> tableDeleteQuery = daoSession.queryBuilder(Likes.class)
                    .where(LikesDao.Properties.Id.eq(id))
                    .buildDelete();
            tableDeleteQuery.executeDeleteWithoutDetachingEntities();
            daoSession.clear();
        }
    }
}
