package com.echessa.sounddroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";

    //id 0870cc86ff9e720019c3c139005598cb
    //secret 5c0ce8f7881c18a70482ba18438ffb7e
    //end user auth https://soundcloud.com/connect
    //token https://api.soundcloud.com/oauth2/token
    // https://api.soundcloud.com/tracks?client_id=YOUR_CLIENT_ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(trackJSON());
        } catch (JSONException e) {
            Log.d(TAG, "JSONException is " + e);
        }

        Track track = Track.parse(jsonObject);
    }

    private String trackJSON() {
        return "";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
