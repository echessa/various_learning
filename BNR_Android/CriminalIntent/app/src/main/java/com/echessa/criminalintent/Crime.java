package com.echessa.criminalintent;

import java.util.UUID;

/**
 * Created by Joyce Echessa on 6/25/15.
 */
public class Crime {

    public Crime() {
        // Generate unique identifier
        mId = UUID.randomUUID();
    }

    private UUID mId;
    private String mTitle;

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
