package com.example.pancho.homeawaychallengue.view.detailsview;


import com.example.pancho.homeawaychallengue.BasePresenter;
import com.example.pancho.homeawaychallengue.BaseView;

public interface DetailsContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {

        void attachRemote();

    }
}
