package com.echessa.mycontacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class ContactViewActivity extends AppCompatActivity {

    public static final String EXTRA = "CVA_Contact";
    private static final String TAG = "ContactViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);

        if (getFragmentManager().findFragmentById(R.id.view_fragment_container) == null) {
            ContactViewFragment cvf = new ContactViewFragment();
            cvf.setPosition(getIntent().getIntExtra(EXTRA, 0));
            getFragmentManager().beginTransaction().add(R.id.view_fragment_container, cvf).commit();
        }

    }


}
