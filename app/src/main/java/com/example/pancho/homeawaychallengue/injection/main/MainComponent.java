package com.example.pancho.homeawaychallengue.injection.main;

import com.example.pancho.homeawaychallengue.injection.CustomScope;
import com.example.pancho.homeawaychallengue.injection.sharedpreference.SharedPreferencesComponent;
import com.example.pancho.homeawaychallengue.view.mainview.MainView;

import dagger.Component;

/**
 * Created by Francisco on 10/18/2017.
 */

@CustomScope
@Component(dependencies = SharedPreferencesComponent.class, modules = {MainModule.class} )
public interface MainComponent {

    void insert(MainView mainView);
}
