package com.example.pancho.homeawaychallenge.injection.main.mainpresenter;

import com.example.pancho.homeawaychallenge.model.remote.Remote;
import com.example.pancho.homeawaychallenge.view.mainview.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Francisco on 10/18/2017.
 */

@Module
public class MainPresenterModule {

    private MainPresenter mainPresenter;

    public MainPresenterModule(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    @Provides
    Remote providesRemote(){

        return new Remote(mainPresenter);
    }
}
