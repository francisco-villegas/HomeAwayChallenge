package com.example.pancho.homeawaychallengue.view.detailsview;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.pancho.homeawaychallengue.App;
import com.example.pancho.homeawaychallengue.R;
import com.example.pancho.homeawaychallengue.entitites.Event;
import com.example.pancho.homeawaychallengue.injection.details.DaggerDetailsComponent;
import com.example.pancho.homeawaychallengue.injection.details.DetailsModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.pancho.homeawaychallengue.util.CONSTANTS.EVENT_DETAILS;

public class DetailsView extends AppCompatActivity implements DetailsContract.View{

    @Inject
    DetailsPresenter presenter;

//    @Inject
//    MySharedPreferences prefs;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private String query;
    private Event event;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_details);

        ButterKnife.bind(this);

        initNotificationBar();

        setupDaggerComponent();

        getDataIntent();

        setToolbarBackPressed();

        initPresenter();
    }

    /** Enable the notification bar, is not appearing in some android versions and with this we forced it **/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initNotificationBar() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.bootstrap_gray_light));
    }

    private void setupDaggerComponent() {
        DaggerDetailsComponent.builder()
                .detailsModule(new DetailsModule())
                .sharedPreferencesComponent(((App) getApplicationContext()).getSharePreferencesComponent())
                .build()
                .insert(this);
    }

    public void getDataIntent() {
        query = getIntent().getAction();
        event = getIntent().getParcelableExtra(EVENT_DETAILS);
    }

    private void setToolbarBackPressed(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle(query);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initPresenter() {
        presenter.attachView(this);
        presenter.attachRemote();
    }

    @Override
    public void showError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_details, menu);
        return true;
    }

    /**
     * options for action bar
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Toast.makeText(this, "This is not implemented is only to show the menu", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
