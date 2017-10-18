package com.example.pancho.homeawaychallenge.injection.app;

import android.app.Application;

import com.example.pancho.homeawaychallenge.entitites.DaoMaster;
import com.example.pancho.homeawaychallenge.entitites.DaoSession;
import com.example.pancho.homeawaychallenge.model.local.DbOpenHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.example.pancho.homeawaychallenge.util.CONSTANTS.DB_NAME;

/**
 * Created by Francisco on 10/18/2017.
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

    @Singleton
    @Provides
    DaoSession providesDAO(){
        return new DaoMaster(new DbOpenHelper(application, DB_NAME).getWritableDb()).newSession();
    }

}
