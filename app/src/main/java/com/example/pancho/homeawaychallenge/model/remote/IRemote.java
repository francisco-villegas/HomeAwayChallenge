package com.example.pancho.homeawaychallenge.model.remote;

import com.example.pancho.homeawaychallenge.entitites.SeatGeek;

import io.reactivex.Observable;
import retrofit2.Call;

/**
 * Created by Francisco on 10/18/2017.
 */

public interface IRemote {

    void sendCall(Call<SeatGeek> call);

    void sendObservable(Observable<SeatGeek> seatGeekObservable);
}
