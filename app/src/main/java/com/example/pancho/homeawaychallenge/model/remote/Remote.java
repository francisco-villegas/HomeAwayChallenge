package com.example.pancho.homeawaychallenge.model.remote;

import com.example.pancho.homeawaychallenge.entitites.SeatGeek;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.pancho.homeawaychallenge.util.CONSTANTS.CLIENT_ID;
import static com.example.pancho.homeawaychallenge.util.CONSTANTS.CLIENT_ID_WORD;
import static com.example.pancho.homeawaychallenge.util.CONSTANTS.CLIENT_SECRET;
import static com.example.pancho.homeawaychallenge.util.CONSTANTS.CLIENT_SECRET_WORD;
import static com.example.pancho.homeawaychallenge.util.CONSTANTS.PATH_SEATGEEK;
import static com.example.pancho.homeawaychallenge.util.CONSTANTS.Q_WORD;

/**
 * Created by Francisco on 10/18/2017.
 */

public class Remote {

    private static final String TAG = "Remote";
    private IRemote iremote;

    public Remote(IRemote iremote){
        this.iremote = iremote;
    }


    /** Get remote data using retrofit call */
    //Receive user if we want to search a user here
    public void getSeatGeekCall(Retrofit retrofit, String query){
        IResponse iResponse = retrofit.create(IResponse.class);
        iremote.sendCall(iResponse.getSeatGeekdata(CLIENT_ID, CLIENT_SECRET, query));
    }

    /** Get remote data using rxjava observable */
    public void getSeatGeekObs(Retrofit retrofit, String query){
        IResponse iResponse = retrofit.create(IResponse.class);
        iremote.sendObservable(iResponse.getSeatGeekObservable(CLIENT_ID, CLIENT_SECRET, query));
    }

    public interface IResponse{

        @GET(PATH_SEATGEEK)
        Call<SeatGeek> getSeatGeekdata(@Query(CLIENT_ID_WORD) String CLIENT_ID, @Query(CLIENT_SECRET_WORD) String CLIENT_SECRET, @Query(Q_WORD) String query);

        @GET(PATH_SEATGEEK)
        Observable<SeatGeek> getSeatGeekObservable(@Query(CLIENT_ID_WORD) String CLIENT_ID, @Query(CLIENT_SECRET_WORD) String CLIENT_SECRET, @Query(Q_WORD) String query);

    }
}
