package com.example.pancho.homeawaychallengue.model.remote;

import com.example.pancho.homeawaychallengue.entitites.SeatGeek;

import io.reactivex.Observable;
import retrofit2.Call;

/**
 * Created by Francisco on 10/18/2017.
 */

public interface IRemote {

    void sendCall(Call<SeatGeek> call);

    void sendObservable(Observable<SeatGeek> seatGeekObservable);
}
