package com.echessa.recommendations.google;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by echessa on 7/25/15.
 */
public class GoogleServicesHelper implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    public interface GoogleServicesListener {
        public void onConnected();
        public void onDisconnected();
    }

    private static final int REQUEST_CODE_RESOLUTION = -100;
    private static final int REQUEST_CODE_AVAILABILITY = -101;

    private GoogleServicesListener mListener;
    private Activity mActivity;
    private GoogleApiClient mApiClient;

    public GoogleServicesHelper(Activity activity, GoogleServicesListener listener) {
        mActivity = activity;
        mListener = listener;
        mApiClient = new GoogleApiClient.Builder(activity)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
    }

    public void connect() {
        mApiClient.connect();
    }

    public void disconnect() {
        mApiClient.disconnect();
    }

    private boolean isGooglePlayServiceAvailable() {
        int availablity = GooglePlayServicesUtil.isGooglePlayServicesAvailable(mActivity);
        switch (availablity) {
            case ConnectionResult.SUCCESS:
                return true;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
            case ConnectionResult.SERVICE_DISABLED:
            case ConnectionResult.SERVICE_INVALID:
                GooglePlayServicesUtil.getErrorDialog(availablity, mActivity, REQUEST_CODE_AVAILABILITY).show();
                return false;
            default:
                return false;
        }
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

}
