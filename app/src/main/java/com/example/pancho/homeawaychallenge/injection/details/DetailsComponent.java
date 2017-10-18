package com.example.pancho.homeawaychallenge.injection.details;

import com.example.pancho.homeawaychallenge.injection.CustomScope;
import com.example.pancho.homeawaychallenge.injection.sharedpreference.SharedPreferencesComponent;
import com.example.pancho.homeawaychallenge.view.detailsview.DetailsView;

import dagger.Component;

/**
 * Created by Francisco on 10/18/2017.
 */

@CustomScope
@Component(dependencies = SharedPreferencesComponent.class, modules = {DetailsModule.class} )
public interface DetailsComponent {

    void insert(DetailsView detailsView);
}
