package com.example.pancho.homeawaychallengue.injection.details.detailspresenter;

import com.example.pancho.homeawaychallengue.view.detailsview.DetailsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DetailsPresenterModule.class} )
public interface DetailsPresenterComponent {

    void insert(DetailsPresenter detailsPresenter);
}
