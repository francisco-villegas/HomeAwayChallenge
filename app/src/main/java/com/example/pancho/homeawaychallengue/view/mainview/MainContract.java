package com.example.pancho.homeawaychallengue.view.mainview;

import com.example.pancho.homeawaychallengue.BasePresenter;
import com.example.pancho.homeawaychallengue.BaseView;
import com.example.pancho.homeawaychallengue.entitites.Event;

import java.util.List;

/**
 * Created by Francisco on 10/18/2017.
 */

public interface MainContract {

    interface View extends BaseView {
        void sendInfo(List<Event> events);
    }

    interface Presenter extends BasePresenter<View> {

        void attachRemote();

        void makeRestCall(String query);
    }
}
