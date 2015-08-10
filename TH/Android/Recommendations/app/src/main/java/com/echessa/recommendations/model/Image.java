package com.echessa.recommendations.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jhuson on 1/22/15.
 */
public class Image implements Parcelable {

    public int rank;
    public int full_height;
    public int full_width;
    public String hex_code;
    public String url_75x75;
    public String url_170x135;
    public String url_570xN;
    public String url_fullxfull;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rank);
        dest.writeInt(full_height);
        dest.writeInt(full_width);
        dest.writeString(hex_code);
        dest.writeString(url_75x75);
        dest.writeString(url_170x135);
        dest.writeString(url_570xN);
        dest.writeString(url_fullxfull);
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            Image image = new Image();
            image.rank = source.readInt();
            image.full_height = source.readInt();
            image.full_width = source.readInt();
            image.hex_code = source.readString();
            image.url_75x75 = source.readString();
            image.url_170x135 = source.readString();
            image.url_570xN = source.readString();
            image.url_fullxfull = source.readString();
            return image;
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
