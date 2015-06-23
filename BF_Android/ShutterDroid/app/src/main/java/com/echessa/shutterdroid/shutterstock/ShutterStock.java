package com.echessa.shutterdroid.shutterstock;

import android.util.Base64;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by echessa on 6/23/15.
 */
public class ShutterStock {

    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(Config.API_URL)
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    String authInfo = Config.CLIENT_ID + ":" + Config.CLIENT_SECRET;
                    String authString = "Basic " + Base64.encodeToString(authInfo.getBytes(), Base64.NO_WRAP);
                    request.addHeader("Authorization", authString);
                }
            })
            .build();

    private static final ShutterStockService SERVICE = REST_ADAPTER.create(ShutterStockService.class);

    public static void search(String query, Callback<List<Image>> cb) {
        SERVICE.searchImages(query, new ImageCallback(cb));
    }

    public static void getRecent(Date date, Callback<List<Image>> cb) {
        SERVICE.getRecentImages(new SimpleDateFormat("yyyy-MM-dd").format(date), new ImageCallback(cb));
    }

    private static class ImageCallback implements Callback<Response> {
        Callback<List<Image>> cb;

        ImageCallback(Callback<List<Image>> cb) {
            this.cb = cb;
        }

        @Override
        public void success(Response response, retrofit.client.Response response2) {
            cb.success(response.data, response2);
        }

        @Override
        public void failure(RetrofitError error) {
            cb.failure(error);
        }
    }
}
