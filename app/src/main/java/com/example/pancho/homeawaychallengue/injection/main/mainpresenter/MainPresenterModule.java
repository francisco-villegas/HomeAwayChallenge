package com.example.pancho.homeawaychallengue.injection.main.mainpresenter;

import com.example.pancho.homeawaychallengue.model.Remote;
import com.example.pancho.homeawaychallengue.view.mainview.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by FRANCISCO on 22/08/2017.
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
