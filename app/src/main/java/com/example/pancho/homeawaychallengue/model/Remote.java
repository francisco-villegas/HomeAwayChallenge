package com.example.pancho.homeawaychallengue.model;

import android.util.Log;

import com.example.pancho.homeawaychallengue.entitites.SeatGeek;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.pancho.homeawaychallengue.util.CONSTANTS.*;

public class Remote {

    private static final String TAG = "Remote";
    private IRemote iremote;

    public Remote(){}

    public Remote(IRemote iremote){
        this.iremote = iremote;
    }

    public void getInfo(boolean force, String query) {
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme(BASE_SCHEMA_SEATGEEK)
                .host(BASE_URL_SEATGEEK)
                .addPathSegments(PATH_SEATGEEK)
                .addQueryParameter(CLIENT_ID_WORD,CLIENT_ID)
                .addQueryParameter(CLIENT_SECRET_WORD,CLIENT_SECRET)
                .addQueryParameter(Q_WORD, query)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Log.i(TAG, "URL: " + url.toString());
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: " + e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String r = response.body().string();
                try {
                    final SeatGeek seatGeek = gson.fromJson(r, SeatGeek.class);

                    //UpdateUI
                    iremote.sendInfo(seatGeek.getEvents());

                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.d(TAG, "onResponse: " + r);
                    iremote.sendError("Failed");
                }
            }
        });
    }

//    public Weather WeatherFromCache(MySharedPreferences prefs) {
//        Gson gson = new Gson();
//        String json = prefs.getString(CONSTANTS.MY_PREFS_JSON, null);
//        Type type = new TypeToken<Weather>() {
//        }.getType();
//        Weather weather = gson.fromJson(json, type);
//
//        return weather;
//    }
}
