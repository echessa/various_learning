package com.echessa.instacam;

import android.os.Environment;

import java.io.File;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by echessa on 7/22/15.
 */
public class Photo implements Serializable {

    private static final File sDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

    private UUID mId;
    private String mCaption;

    Photo() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public File getFile() {
        return new File(sDirectory, mId.toString() + ".jpeg");
    }
}
