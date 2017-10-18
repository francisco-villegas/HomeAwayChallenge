package com.example.pancho.homeawaychallengue.view.detailsview;

import com.example.pancho.homeawaychallengue.BasePresenter;
import com.example.pancho.homeawaychallengue.BaseView;
import com.example.pancho.homeawaychallengue.entitites.DaoSession;
import com.example.pancho.homeawaychallengue.entitites.Likes;

import java.util.List;

/**
 * Created by Francisco on 10/18/2017.
 */

public interface DetailsContract {

    interface View extends BaseView {

        void sendResult(List<Likes> likes);
    }

    interface Presenter extends BasePresenter<View> {

        void localquery(DaoSession daoSession, String id);

        void saveChecked(DaoSession daoSession, boolean checked, String id);
    }
}
