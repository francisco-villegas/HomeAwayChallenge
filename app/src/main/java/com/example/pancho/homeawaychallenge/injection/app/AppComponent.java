package com.example.pancho.homeawaychallenge.injection.app;

import com.example.pancho.homeawaychallenge.App;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Francisco on 10/18/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void insert (App app);
}
