package com.example.pancho.homeawaychallengue.view.mainview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.example.pancho.homeawaychallengue.App;
import com.example.pancho.homeawaychallengue.R;
import com.example.pancho.homeawaychallengue.entitites.Event;
import com.example.pancho.homeawaychallengue.injection.main.DaggerMainComponent;
import com.example.pancho.homeawaychallengue.injection.main.MainModule;
import com.example.pancho.homeawaychallengue.view.detailsview.DetailsView;
import com.flurry.android.FlurryAgent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;

import static com.example.pancho.homeawaychallengue.util.CONSTANTS.EVENT_DETAILS;
import static com.example.pancho.homeawaychallengue.util.CONSTANTS.FLURRY_API_KEY;

public class MainView extends AppCompatActivity implements MainContract.View, FirstAdapter.EventListener {

    private static final String TAG = "MainView";

    @Inject
    MainPresenter presenter;

    @Inject
    SharedPreferences prefs;

    @BindView(R.id.ettoolbar)
    EditText ettoolbar;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    LinearLayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    FirstAdapter firstAdapter;

    String query;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Answers(), new Crashlytics());
        setContentView(R.layout.activity_main);
        setTitle("");

        ButterKnife.bind(this);

        initToolbar();

        initFlurry();

        initNotificationBar();

        setupDaggerComponent();

        initPresenter();

        initRecyclerView();


        prefs.edit().putBoolean("a",true);
        Log.d(TAG, "makeRestCall: " + prefs.getBoolean("a",false));
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
    }

    private void initFlurry() {
        new FlurryAgent.Builder()
                .withLogEnabled(false)
                .build(this, FLURRY_API_KEY);
    }

    /**
     * Enable the notification bar, is not appearing in some android versions and with this we forced it
     **/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initNotificationBar() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.bootstrap_gray_light));
    }

    private void setupDaggerComponent() {
        DaggerMainComponent.builder()
                .sharedPreferencesComponent(((App) getApplicationContext()).getSharePreferencesComponent())
                .mainModule(new MainModule())
                .build()
                .insert(this);

//        ((App) getApplicationContext()).getMainComponent().insert(this);
    }

    private void initPresenter() {
        presenter.attachView(this);
        presenter.attachRemote();
    }

    private void initRecyclerView() {
        layoutManager = new LinearLayoutManager(getApplicationContext());
        itemAnimator = new DefaultItemAnimator();
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(itemAnimator);
        recycler.setHasFixedSize(true);
        recycler.setItemViewCacheSize(20);
        recycler.setDrawingCacheEnabled(true);
        recycler.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
    }

    @Override
    public void showError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    /**
     * create action bar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * options for action bar
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                String query = ettoolbar.getText().toString();

                if (query.equals("")) {
                    Toast.makeText(this, "You have to type anything before press the search button", Toast.LENGTH_SHORT).show();
                } else {
                    this.query = query;
                    presenter.makeRestCall(query);
                }

                break;
        }
        return true;
    }

    @Override
    public void sendInfo(List<Event> events) {
        firstAdapter = new FirstAdapter(events);
        recycler.setAdapter(firstAdapter);
        firstAdapter.notifyDataSetChanged();
    }

    /**
     * Fires details view when element is pressed
     */
    @Override
    public void ItemClick(Event item) {
        Intent intent = new Intent(this, DetailsView.class);
        intent.setAction(query);
        intent.putExtra(EVENT_DETAILS,item);
        startActivity(intent);
    }
}
