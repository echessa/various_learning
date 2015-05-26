package com.echessa.sounddroid.soundcloud;

import com.google.gson.annotations.SerializedName;

/**
 * Created by echessa on 5/23/15.
 */
public class Track {

    @SerializedName("title")
    private String mTitle;

    @SerializedName("stream_url")
    private String mStreamURL;

    @SerializedName("id")
    private int mID;

    @SerializedName("artwork_url")
    private String mArtworkURL;

    public String getTitle() {
        return mTitle;
    }

    public String getStreamURL() {
        return mStreamURL;
    }

    public int getID() {
        return mID;
    }

    public String getArtworkURL() {
        return mArtworkURL;
    }

    public String getAvatarURL() {
        String avatarURL = mArtworkURL;
        if (avatarURL != null) {
            avatarURL.replace("large", "tiny");
        }
        return avatarURL;
    }
}
