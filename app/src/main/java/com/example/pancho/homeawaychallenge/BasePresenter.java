package com.example.pancho.homeawaychallenge;

/**
 * Created by Francisco on 10/18/2017.
 */

public interface BasePresenter <V extends BaseView>{

    void attachView(V view);
    void detachView();

}
