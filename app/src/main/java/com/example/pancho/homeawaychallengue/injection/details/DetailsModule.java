package com.example.pancho.homeawaychallengue.injection.details;

import com.example.pancho.homeawaychallengue.view.detailsview.DetailsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Francisco on 10/18/2017.
 */

@Module
public class DetailsModule {

    @Provides
    DetailsPresenter providesDetailsPresenter(){

        return new DetailsPresenter();
    }
}
