package com.example.pancho.homeawaychallenge.injection.main;

import com.example.pancho.homeawaychallenge.injection.CustomScope;
import com.example.pancho.homeawaychallenge.injection.sharedpreference.SharedPreferencesComponent;
import com.example.pancho.homeawaychallenge.view.mainview.MainView;

import dagger.Component;

/**
 * Created by Francisco on 10/18/2017.
 */

@CustomScope
@Component(dependencies = SharedPreferencesComponent.class, modules = {MainModule.class} )
public interface MainComponent {

    void insert(MainView mainView);
}
