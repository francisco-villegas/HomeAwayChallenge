package com.example.pancho.homeawaychallenge.view.detailsview;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pancho.homeawaychallenge.App;
import com.example.pancho.homeawaychallenge.R;
import com.example.pancho.homeawaychallenge.entitites.Event;
import com.example.pancho.homeawaychallenge.entitites.Likes;
import com.example.pancho.homeawaychallenge.injection.details.DaggerDetailsComponent;
import com.example.pancho.homeawaychallenge.injection.details.DetailsModule;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.varunest.sparkbutton.SparkButton;
import com.varunest.sparkbutton.SparkEventListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.pancho.homeawaychallenge.util.CONSTANTS.EVENT_DETAILS;

/**
 * Created by Francisco on 10/18/2017.
 */

public class DetailsView extends AppCompatActivity implements DetailsContract.View, SparkEventListener {

    private static final String TAG = "DetailsView";

    @Inject
    DetailsPresenter presenter;

    @Inject
    SharedPreferences prefs;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.hearth_button)
    SparkButton hearthButton;
    @BindView(R.id.tvLocation)
    TextView tvLocation;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.image)
    CircularImageView image;
    @BindView(R.id.tvScore)
    TextView tvScore;
    private String query;
    private Event event;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        initNotificationBar();

        setupDaggerComponent();

        getDataIntent();

        printData();

        setToolbarBackPressed();

        initPresenter();

        initColor();

        hearthButton.setEventListener(this);
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
     * Dagger setup with the presenter and the sharepreferences
     **/
    private void setupDaggerComponent() {
        DaggerDetailsComponent.builder()
                .detailsModule(new DetailsModule())
                .sharedPreferencesComponent(((App) getApplicationContext()).getSharePreferencesComponent())
                .build()
                .insert(this);
    }

    /**
     * Receive the response from the previous activity
     **/
    public void getDataIntent() {
        query = getIntent().getAction();
        event = getIntent().getParcelableExtra(EVENT_DETAILS);
    }

    /**
     * Prints all the data that we received from the previous activity
     **/
    private void printData() {
        String url_img = event.getPerformers().get(0).getImage();
        if (url_img != null)
            Picasso.with(getApplicationContext()).load(url_img).into(image);
        else
            Picasso.with(getApplicationContext()).load(R.drawable.broken_image).into(image);

        if (!event.getTitle().trim().equals(""))
            tvName.setText(event.getTitle());
        else
            tvName.setVisibility(tvName.getRootView().GONE);

        if (!event.getVenue().getDisplayLocation().trim().equals(""))
            tvDate.setText(event.getVenue().getDisplayLocation());
        else
            tvDate.setVisibility(tvDate.getRootView().GONE);

        if (!event.getAnnounceDate().trim().equals(""))
            tvLocation.setText(event.getAnnounceDate());
        else
            tvLocation.setVisibility(tvLocation.getRootView().GONE);

        if (!event.getVenue().getScore().trim().equals("null"))
            tvScore.setText(String.valueOf(event.getVenue().getScore()));
        else
            tvScore.setText("0");
    }


    /**
     * Draw the backbutton at the top-left of the screen and perform the back operation
     **/
    private void setToolbarBackPressed() {
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
    }

    /**
     * Send an action to the presenter to verify if the element has a like or not
     **/
    private void initColor() {
        presenter.localquery(((App) getApplication()).getDaoSession(), event.getId());
    }

    /**
     * Fires the errors
     **/
    @Override
    public void showError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    /**
     * Inflate the menu
     **/
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

    /**
     * Sends the result after checking the color
     *      If the result is not null or is greater than 0 then check the hearth
     **/
    @Override
    public void sendResult(List<Likes> likes) {
        if (likes != null && likes.size() > 0) {
            hearthButton.setChecked(true);
        }
    }


    /**
     * Listeners replacing OnclickListener from the custom hearth
     **/
    @Override
    public void onEvent(ImageView button, boolean buttonState) {
        Log.d(TAG, "onViewClicked: " + buttonState);
        presenter.saveChecked(((App) getApplication()).getDaoSession(), buttonState, event.getId());
    }

    @Override
    public void onEventAnimationEnd(ImageView button, boolean buttonState) {

    }

    @Override
    public void onEventAnimationStart(ImageView button, boolean buttonState) {

    }
}
