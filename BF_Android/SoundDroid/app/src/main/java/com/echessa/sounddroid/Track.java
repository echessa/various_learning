package com.echessa.sounddroid;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by echessa on 5/23/15.
 */
public class Track {

    private String mTitle;
    private String mStreamURL;
    private int mID;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getStreamURL() {
        return mStreamURL;
    }

    public void setStreamURL(String streamURL) {
        mStreamURL = streamURL;
    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public static Track parse(JSONObject jsonObject) {
        Track t = new Track();

        try {
            t.setTitle(jsonObject.getString("title"));
        } catch (JSONException e) {

        }
        return t;
    }
}
