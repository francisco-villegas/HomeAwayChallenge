package com.example.pancho.homeawaychallengue.model.remote;

import com.example.pancho.homeawaychallengue.entitites.SeatGeek;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.pancho.homeawaychallengue.util.CONSTANTS.CLIENT_ID;
import static com.example.pancho.homeawaychallengue.util.CONSTANTS.CLIENT_ID_WORD;
import static com.example.pancho.homeawaychallengue.util.CONSTANTS.CLIENT_SECRET;
import static com.example.pancho.homeawaychallengue.util.CONSTANTS.CLIENT_SECRET_WORD;
import static com.example.pancho.homeawaychallengue.util.CONSTANTS.PATH_SEATGEEK;
import static com.example.pancho.homeawaychallengue.util.CONSTANTS.Q_WORD;

public class Remote {

    private static final String TAG = "Remote";
    private IRemote iremote;

    public Remote(IRemote iremote){
        this.iremote = iremote;
    }

    public void getInfo(boolean force, String query) {
//        OkHttpClient client = new OkHttpClient();
//        HttpUrl url = new HttpUrl.Builder()
//                .scheme(BASE_SCHEMA_SEATGEEK)
//                .host(BASE_URL_SEATGEEK)
//                .addPathSegments(PATH_SEATGEEK)
//                .addQueryParameter(CLIENT_ID_WORD,CLIENT_ID)
//                .addQueryParameter(CLIENT_SECRET_WORD,CLIENT_SECRET)
//                .addQueryParameter(Q_WORD, query)
//                .build();
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        Log.i(TAG, "URL: " + url.toString());
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.d(TAG, "onFailure: " + e.toString());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Gson gson = new Gson();
//                String r = response.body().string();
//                try {
//                    final SeatGeek seatGeek = gson.fromJson(r, SeatGeek.class);
//
//                    //UpdateUI
//                    iremote.sendInfo(seatGeek.getSeatGeeks());
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                    Log.d(TAG, "onResponse: " + r);
//                    iremote.sendError("Failed");
//                }
//            }
//        });
    }

    //Receive user if we want to search a user here
    public void getSeatGeekCall(Retrofit retrofit, String query){
        IResponse iResponse = retrofit.create(IResponse.class);
        iremote.sendCall(iResponse.getSeatGeekdata(CLIENT_ID, CLIENT_SECRET, query));
    }

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
