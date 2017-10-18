package com.example.pancho.homeawaychallengue.view.detailsview;

import com.example.pancho.homeawaychallengue.entitites.DaoSession;
import com.example.pancho.homeawaychallengue.entitites.Likes;
import com.example.pancho.homeawaychallengue.entitites.LikesDao;

import org.greenrobot.greendao.query.DeleteQuery;

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

    @Override
    public void localquery(DaoSession daoSession, String id) {
        view.sendResult(daoSession.queryBuilder(Likes.class)
                .where(LikesDao.Properties.Id.eq(id))
                .list());
    }

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
