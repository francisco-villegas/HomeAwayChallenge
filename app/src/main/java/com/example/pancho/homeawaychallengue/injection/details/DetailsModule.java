package com.example.pancho.homeawaychallengue.injection.details;

import com.example.pancho.homeawaychallengue.view.detailsview.DetailsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by FRANCISCO on 22/08/2017.
 */

@Module
public class DetailsModule {

    @Provides
    DetailsPresenter providesDetailsPresenter(){

        return new DetailsPresenter();
    }
}
