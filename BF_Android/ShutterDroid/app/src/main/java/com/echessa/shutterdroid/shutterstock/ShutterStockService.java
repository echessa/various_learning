package com.echessa.shutterdroid.shutterstock;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by echessa on 6/23/15.
 */
interface ShutterStockService {

    @GET("/images/search")
    public void searchImages(@Query("query") String query, Callback<Response> cb);

    @GET("/images/search")
    public void getRecentImages(@Query("added_date_start") String date, Callback<Response> cb);

}
