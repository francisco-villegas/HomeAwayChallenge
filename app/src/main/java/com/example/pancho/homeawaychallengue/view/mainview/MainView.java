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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;
import icepick.State;
import io.fabric.sdk.android.Fabric;

import static com.example.pancho.homeawaychallengue.util.CONSTANTS.EVENT_DETAILS;
import static com.example.pancho.homeawaychallengue.util.CONSTANTS.FLURRY_API_KEY;

/**
 * Created by Francisco on 10/18/2017.
 */

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

    @State
    ArrayList<Event> events;

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

        events = new ArrayList<>();

        Icepick.restoreInstanceState(this, savedInstanceState);

        initRecyclerView();

        EditTextEvent();

        EditTextEnter();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
    }

    /**
     * Enable flurry to track the user information
     **/
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


    /**
     * Setup dagger with the sharepreferences as a dependency
     **/
    private void setupDaggerComponent() {
        DaggerMainComponent.builder()
                .sharedPreferencesComponent(((App) getApplicationContext()).getSharePreferencesComponent())
                .mainModule(new MainModule())
                .build()
                .insert(this);
    }

    private void initPresenter() {
        presenter.attachView(this);
        presenter.attachRemote();
    }


    /**
     * Initiate recyclerview
     **/
    private void initRecyclerView() {
        layoutManager = new LinearLayoutManager(getApplicationContext());
        itemAnimator = new DefaultItemAnimator();
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(itemAnimator);
        recycler.setHasFixedSize(true);
        recycler.setItemViewCacheSize(20);
        recycler.setDrawingCacheEnabled(true);
        recycler.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        firstAdapter = new FirstAdapter(events);
        recycler.setAdapter(firstAdapter);
        firstAdapter.notifyDataSetChanged();
    }

    /**
     * TextWatcher to detect when a key is pressed
     **/
    private void EditTextEvent() {
        ettoolbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                presenter.makeRestCall(s.toString().trim());
            }
        });
    }

    /**
     * EditText event to detect enter key and fires the search
     **/
    private void EditTextEnter() {
        ettoolbar.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                //If the keyevent is a key-down event on the "enter" button
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    presenter.makeRestCall(ettoolbar.getText().toString().trim());
                    return true;
                }
                return false;
            }
        });
    }

    /**
     * Fire errrors
     **/
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
                    presenter.makeRestCall(query.trim());
                }

                break;
        }
        return true;
    }

    /**
     * Receive the backend response from the presenter and populate the recyclerview
     **/
    @Override
    public void sendInfo(List<Event> events) {
        firstAdapter = new FirstAdapter(events);
        recycler.setAdapter(firstAdapter);
        firstAdapter.notifyDataSetChanged();

        this.events = new ArrayList<Event>(events);
    }

    /**
     * Fires details view when element is pressed
     */
    @Override
    public void ItemClick(Event item) {
        Intent intent = new Intent(this, DetailsView.class);
        intent.setAction(query);
        intent.putExtra(EVENT_DETAILS, item);
        startActivity(intent);
    }

    /**
     * Save the instance of the recyclerview using Icepick
     **/
    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

}
