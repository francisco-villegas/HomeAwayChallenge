package com.example.pancho.homeawaychallenge.injection.sharedpreference;

import android.content.SharedPreferences;

import com.example.pancho.homeawaychallenge.injection.app.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Francisco on 10/18/2017.
 */

@Singleton
@Component(modules = {SharedPreferencesModule.class, AppModule.class})
public interface SharedPreferencesComponent {

    SharedPreferences getSharedPreferences();
}
