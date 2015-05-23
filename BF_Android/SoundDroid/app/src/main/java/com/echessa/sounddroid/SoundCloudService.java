package com.echessa.sounddroid;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by echessa on 5/24/15.
 */
public interface SoundCloudService {

    static final String CLIENT_ID = "";

    @GET("/tracks?client_id=" + CLIENT_ID)
    public List<Track> searchSongs(@Query("q") String query);
}
