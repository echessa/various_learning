package com.echessa.recommendations.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jhuson on 1/22/15.
 */
public class ActiveListings implements Parcelable {

    public int count;
    public Listing[] results;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
        dest.writeParcelableArray(results, 0);
    }

    public static final Creator<ActiveListings> CREATOR = new Creator<ActiveListings>() {
        @Override
        public ActiveListings createFromParcel(Parcel source) {
            ActiveListings activeListings = new ActiveListings();
            activeListings.count = source.readInt();
            activeListings.results = (Listing[]) source.readParcelableArray(Listing.class.getClassLoader());
            return activeListings;
        }

        @Override
        public ActiveListings[] newArray(int size) {
            return new ActiveListings[size];
        }
    };
}
