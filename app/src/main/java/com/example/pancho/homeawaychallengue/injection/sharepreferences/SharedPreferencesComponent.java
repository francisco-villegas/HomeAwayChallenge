package com.example.pancho.homeawaychallengue.injection.sharepreferences;

import android.content.SharedPreferences;

import com.example.pancho.homeawaychallengue.injection.app.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Francisco on 10/18/2017.
 */

@Singleton
@Component(modules = {SharePreferencesModule.class, AppModule.class})
public interface SharedPreferencesComponent {

    SharedPreferences getSharedPreferences();
}
