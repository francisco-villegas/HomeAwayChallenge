package com.example.pancho.homeawaychallengue.view.mainview;

import com.example.pancho.homeawaychallengue.entitites.SeatGeek;
import com.example.pancho.homeawaychallengue.injection.main.mainpresenter.DaggerMainPresenterComponent;
import com.example.pancho.homeawaychallengue.injection.main.mainpresenter.MainPresenterModule;
import com.example.pancho.homeawaychallengue.injection.remote.RemoteModule;
import com.example.pancho.homeawaychallengue.model.remote.IRemote;
import com.example.pancho.homeawaychallengue.model.remote.Remote;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by Francisco on 10/18/2017.
 */

public class MainPresenter implements MainContract.Presenter, IRemote {

    MainContract.View view;
    private static final String TAG = "MainPresenter";

    @Inject
    public Remote remote;

    @Inject
    public Retrofit retrofit;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    /**
     * Setup dagger to obtain the remote connection
     **/
    @Override
    public void attachRemote(){
        DaggerMainPresenterComponent
                .builder()
                .mainPresenterModule(new MainPresenterModule(this))
                .remoteModule(new RemoteModule())
                .build()
                .insert(this);
    }

    /**
     * Make a restcall and obtain, expecting to receive an observable
     **/
    @Override
    public void makeRestCall(String query) {
        remote.getSeatGeekObs(retrofit, query);
    }

    /**
     * Method to receive a call with retrofit not used
     **/
    @Deprecated
    @Override
    public void sendCall(Call<SeatGeek> call) {
        call.enqueue(new retrofit2.Callback<SeatGeek>() {
            @Override
            public void onResponse(retrofit2.Call<SeatGeek> call, final retrofit2.Response<SeatGeek> response) {
                ((MainView) view).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        view.sendInfo(response.body().getEvents());
                    }
                });
            }

            @Override
            public void onFailure(Call<SeatGeek> call, Throwable t) {
                view.showError("Fail");
            }
        });
    }

    /**
     * Method expected to be received after the restcall
     * It sends the result to the view
     **/
    @Override
    public void sendObservable(Observable<SeatGeek> seatGeekObservable) {
        seatGeekObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<SeatGeek>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SeatGeek value) {
                        view.sendInfo(value.getEvents());
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
