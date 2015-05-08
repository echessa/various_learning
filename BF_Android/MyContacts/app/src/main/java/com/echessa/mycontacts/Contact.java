package com.echessa.mycontacts;

import java.io.Serializable;

/**
 * Created by Joyce Echessa on 5/7/15.
 */
public class Contact implements Serializable {

    private String mName;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
