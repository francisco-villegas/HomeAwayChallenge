package com.example.pancho.homeawaychallengue.injection.app;

import android.app.Application;

import com.example.pancho.homeawaychallengue.entitites.DaoMaster;
import com.example.pancho.homeawaychallengue.entitites.DaoSession;
import com.example.pancho.homeawaychallengue.model.local.DbOpenHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.example.pancho.homeawaychallengue.util.CONSTANTS.DB_NAME;

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
