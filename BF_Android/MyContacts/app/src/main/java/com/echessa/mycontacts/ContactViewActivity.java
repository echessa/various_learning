package com.echessa.mycontacts;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ContactViewActivity extends ActionBarActivity {

    public static final String EXTRA = "CVA_Contact";
    private static final String TAG = "ContactViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);

        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);

        int width = point.x;
        int height = point.y;

        RelativeLayout headerSection = (RelativeLayout)findViewById(R.id.contact_view_header);
        headerSection.setLayoutParams(new RelativeLayout.LayoutParams(width, (int)(width * (9.0 / 16.0))));

        Contact contact = (Contact)getIntent().getSerializableExtra(EXTRA);
        TextView contactName = (TextView)findViewById(R.id.contact_view_name);
        contactName.setText(contact.getName());

        Toolbar toolbar = (Toolbar)findViewById(R.id.contact_view_toolbar);
        toolbar.inflateMenu(R.menu.menu_contact_view);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_view, menu);
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
