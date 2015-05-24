package com.echessa.sounddroid.soundcloud;

import retrofit.RestAdapter;

/**
 * Created by echessa on 5/24/15.
 */
public class SoundCloud {

    private static final String API_URL = "https://api.soundcloud.com";

    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .build();

    private static final SoundCloudService SERVICE = REST_ADAPTER.create(SoundCloudService.class);

    public static SoundCloudService getService() {
        return SERVICE;
    }

}
