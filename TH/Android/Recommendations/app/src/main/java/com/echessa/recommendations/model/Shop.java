package com.echessa.recommendations.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jhuson on 1/22/15.
 */
public class Shop implements Parcelable {

    public int shop_id;
    public String shop_name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(shop_id);
        dest.writeString(shop_name);
    }

    public static final Creator<Shop> CREATOR = new Creator<Shop>() {
        @Override
        public Shop createFromParcel(Parcel source) {
            Shop shop = new Shop();
            shop.shop_id = source.readInt();
            shop.shop_name = source.readString();
            return shop;
        }

        @Override
        public Shop[] newArray(int size) {
            return new Shop[size];
        }
    };
}
