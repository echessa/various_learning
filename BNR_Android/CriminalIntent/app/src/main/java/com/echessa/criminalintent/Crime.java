package com.echessa.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Joyce Echessa on 6/25/15.
 */
public class Crime {

    public Crime() {
        // Generate unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
