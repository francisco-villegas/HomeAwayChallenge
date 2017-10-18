package com.example.pancho.homeawaychallengue.view.detailsview;

import com.example.pancho.homeawaychallengue.entitites.Event;
import com.example.pancho.homeawaychallengue.injection.details.detailspresenter.DaggerDetailsPresenterComponent;
import com.example.pancho.homeawaychallengue.injection.details.detailspresenter.DetailsPresenterModule;
import com.example.pancho.homeawaychallengue.model.IRemote;
import com.example.pancho.homeawaychallengue.model.Remote;

import java.util.List;

import javax.inject.Inject;

public class DetailsPresenter implements DetailsContract.Presenter, IRemote {
    DetailsContract.View view;
    private static final String TAG = "DetailsPresenter";

    @Inject
    public Remote remote;

    @Override
    public void attachView(DetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void attachRemote(){
        DaggerDetailsPresenterComponent
                .builder()
                .detailsPresenterModule(new DetailsPresenterModule(this))
                .build()
                .insert(this);
    }

    @Override
    public void sendError(String s) {

    }

    @Override
    public void sendInfo(List<Event> events) {

    }
}
