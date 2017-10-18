package com.example.pancho.homeawaychallengue.view.mainview;


import android.content.SharedPreferences;

import com.example.pancho.homeawaychallengue.entitites.Event;
import com.example.pancho.homeawaychallengue.injection.main.mainpresenter.DaggerMainPresenterComponent;
import com.example.pancho.homeawaychallengue.injection.main.mainpresenter.MainPresenterModule;
import com.example.pancho.homeawaychallengue.model.IRemote;
import com.example.pancho.homeawaychallengue.model.Remote;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter, IRemote {
    private static final String TAG = "MainPresenter";

    @Inject
    public Remote remote;

    MainContract.View view;

    SharedPreferences prefs;

    @Inject
    public MainPresenter(MainContract.View view, SharedPreferences prefs) {
        this.view = view;
        this.prefs = prefs;
    }


    @Override
    public void attachRemote(){
        DaggerMainPresenterComponent
                .builder()
                .mainPresenterModule(new MainPresenterModule(this))
                .build()
                .insert(this);
    }

    @Override
    public void makeRestCall(boolean force, String query) {
        remote.getInfo(force, query);
//        prefs.edit().putBoolean("a",true);
//        Log.d(TAG, "makeRestCall: " + prefs.getBoolean("a",false));
    }

    @Override
    public void sendError(final String s) {
        ((MainView) view).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.showError(s);
            }
        });
    }

    @Override
    public void sendInfo(final List<Event> events) {
        ((MainView) view).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.sendInfo(events);
            }
        });
    }
}
