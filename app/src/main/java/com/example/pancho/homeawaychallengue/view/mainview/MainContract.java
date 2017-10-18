package com.example.pancho.homeawaychallengue.view.mainview;


import com.example.pancho.homeawaychallengue.BasePresenter;
import com.example.pancho.homeawaychallengue.BaseView;
import com.example.pancho.homeawaychallengue.entitites.Event;

import java.util.List;

public interface MainContract {

    interface View extends BaseView {
        void sendInfo(List<Event> events);
    }

    interface Presenter extends BasePresenter<View> {

        void attachRemote();

        void makeRestCall(String query);
    }
}
