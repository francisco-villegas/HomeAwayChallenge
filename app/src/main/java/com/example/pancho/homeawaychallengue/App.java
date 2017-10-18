package com.example.pancho.homeawaychallengue;

import android.app.Application;

import com.example.pancho.homeawaychallengue.entitites.DaoSession;
import com.example.pancho.homeawaychallengue.injection.app.AppModule;
import com.example.pancho.homeawaychallengue.injection.app.DaggerAppComponent;
import com.example.pancho.homeawaychallengue.injection.sharepreferences.DaggerSharedPreferencesComponent;
import com.example.pancho.homeawaychallengue.injection.sharepreferences.SharePreferencesModule;
import com.example.pancho.homeawaychallengue.injection.sharepreferences.SharedPreferencesComponent;

import javax.inject.Inject;

/**
 * Created by Francisco on 10/18/2017.
 */

public class App extends Application {

    private SharedPreferencesComponent sharedPreferencesComponent;

    @Inject
    DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        setUpDaggerSharePreferences();

        setUpDaggerApp();
    }

    /**
     * Dagger App setup to use the DAOSession
     **/
    private void setUpDaggerApp() {
        DaggerAppComponent.builder().appModule(new AppModule(this)).build().insert(this);
    }

    /**
     * Dagger sharepreferences that are being shared with all the activities
     **/
    private void setUpDaggerSharePreferences() {
        sharedPreferencesComponent = DaggerSharedPreferencesComponent.builder()
                .appModule(new AppModule(this))
                .sharePreferencesModule(new SharePreferencesModule())
                .build();
    }

    public SharedPreferencesComponent getSharePreferencesComponent() {
        return sharedPreferencesComponent;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}