package com.example.pancho.homeawaychallengue;

import android.app.Application;

import com.example.pancho.homeawaychallengue.entitites.DaoSession;
import com.example.pancho.homeawaychallengue.injection.app.AppModule;
import com.example.pancho.homeawaychallengue.injection.app.DaggerAppComponent;
import com.example.pancho.homeawaychallengue.injection.sharepreferences.DaggerSharedPreferencesComponent;
import com.example.pancho.homeawaychallengue.injection.sharepreferences.SharePreferencesModule;
import com.example.pancho.homeawaychallengue.injection.sharepreferences.SharedPreferencesComponent;

import javax.inject.Inject;

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

    private void setUpDaggerApp() {
        DaggerAppComponent.builder().appModule(new AppModule(this)).build().insert(this);
    }

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