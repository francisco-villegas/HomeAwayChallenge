package com.example.pancho.homeawaychallengue.injection.details.detailspresenter;

import com.example.pancho.homeawaychallengue.model.Remote;
import com.example.pancho.homeawaychallengue.view.detailsview.DetailsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by FRANCISCO on 22/08/2017.
 */

@Module
public class DetailsPresenterModule {

    private DetailsPresenter detailsPresenter;

    public DetailsPresenterModule(DetailsPresenter detailsPresenter) {
        this.detailsPresenter = detailsPresenter;
    }

    @Provides
    Remote providesRemote(){

        return new Remote(detailsPresenter);
    }
}
