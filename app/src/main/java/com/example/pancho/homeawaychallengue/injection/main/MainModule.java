package com.example.pancho.homeawaychallengue.injection.main;

import com.example.pancho.homeawaychallengue.injection.CustomScope;
import com.example.pancho.homeawaychallengue.view.mainview.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by FRANCISCO on 22/08/2017.
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
