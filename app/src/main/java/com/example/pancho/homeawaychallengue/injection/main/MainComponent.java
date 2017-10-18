package com.example.pancho.homeawaychallengue.injection.main;

import com.example.pancho.homeawaychallengue.injection.CustomScope;
import com.example.pancho.homeawaychallengue.injection.sharepreferences.SharedPreferencesComponent;
import com.example.pancho.homeawaychallengue.view.mainview.MainView;

import dagger.Component;

@CustomScope
@Component(dependencies = SharedPreferencesComponent.class, modules = {MainModule.class} )
public interface MainComponent {

    void insert(MainView mainView);
}
