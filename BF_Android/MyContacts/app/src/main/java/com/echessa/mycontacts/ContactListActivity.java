package com.echessa.mycontacts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class ContactListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        if (getFragmentManager().findFragmentById(R.id.list_fragment_container) == null) {
            getFragmentManager().beginTransaction().add(R.id.list_fragment_container, new ContactListFragment()).commit();
        }

    }
}
