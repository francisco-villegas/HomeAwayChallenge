package com.example.pancho.homeawaychallengue;

import android.app.Application;

import com.example.pancho.homeawaychallengue.injection.app.AppModule;
import com.example.pancho.homeawaychallengue.injection.sharepreferences.DaggerSharedPreferencesComponent;
import com.example.pancho.homeawaychallengue.injection.sharepreferences.SharePreferencesModule;
import com.example.pancho.homeawaychallengue.injection.sharepreferences.SharedPreferencesComponent;

public class App extends Application {

    private SharedPreferencesComponent sharedPreferencesComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferencesComponent = DaggerSharedPreferencesComponent.builder()
                .appModule(new AppModule(this))
                .sharePreferencesModule(new SharePreferencesModule())
                .build();

    }

    public SharedPreferencesComponent getSharePreferencesComponent() {
        return sharedPreferencesComponent;
    }
}