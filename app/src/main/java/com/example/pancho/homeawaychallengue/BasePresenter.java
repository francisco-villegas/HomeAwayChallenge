package com.example.pancho.homeawaychallengue;

/**
 * Created by Pancho on 10/17/2017.
 */

public interface BasePresenter <V extends BaseView>{

    void attachView(V view);
    void detachView();

}
