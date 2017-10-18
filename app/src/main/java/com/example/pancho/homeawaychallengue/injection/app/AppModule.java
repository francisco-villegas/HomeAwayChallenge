package com.example.pancho.homeawaychallengue.injection.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pancho on 10/18/2017.
 */

@Module
public class AppModule {

    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Application providesApp(){
        return application;
    }
}
