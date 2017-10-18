package com.example.pancho.homeawaychallenge.injection.main;

import com.example.pancho.homeawaychallenge.injection.CustomScope;
import com.example.pancho.homeawaychallenge.view.mainview.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Francisco on 10/18/2017.
 */

@Module
public class MainModule {

    @CustomScope
    @Provides
    MainPresenter providesMainPresenter(){

        return new MainPresenter();
    }

//    private final MainContract.View view;
//
//    public MainModule(MainContract.View view) {
//        this.view = view;
//    }
//
//    @CustomScope
//    @Provides
//    MainContract.View providesMainContractView(){
//        return view;
//    }
}
