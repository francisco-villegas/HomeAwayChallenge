package com.example.pancho.homeawaychallenge.view.mainview;

import com.example.pancho.homeawaychallenge.BasePresenter;
import com.example.pancho.homeawaychallenge.BaseView;
import com.example.pancho.homeawaychallenge.entitites.Event;

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
