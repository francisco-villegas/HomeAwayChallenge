package com.example.pancho.homeawaychallengue.injection.main.mainpresenter;

import com.example.pancho.homeawaychallengue.injection.remote.RemoteModule;
import com.example.pancho.homeawaychallengue.view.mainview.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Francisco on 10/18/2017.
 */

@Singleton
@Component(modules = {MainPresenterModule.class, RemoteModule.class} )
public interface MainPresenterComponent {

    void insert(MainPresenter mainPresenter);
}
