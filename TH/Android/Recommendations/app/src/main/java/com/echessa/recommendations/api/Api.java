package com.echessa.recommendations.api;

import com.echessa.recommendations.model.ActiveListings;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by echessa on 7/25/15.
 */
public interface Api {

    @GET("/listings/active")
    void activeListings(@Query("includes") String includes, Callback<ActiveListings> callback);

}
