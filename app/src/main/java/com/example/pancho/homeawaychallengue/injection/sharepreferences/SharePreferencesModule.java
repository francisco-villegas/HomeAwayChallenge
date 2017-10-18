package com.example.pancho.homeawaychallengue.injection.sharepreferences;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pancho on 10/18/2017.
 */

@Module
public class SharePreferencesModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
