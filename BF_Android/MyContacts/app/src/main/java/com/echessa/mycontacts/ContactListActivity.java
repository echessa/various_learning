package com.echessa.mycontacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;


public class ContactListActivity extends AppCompatActivity implements ContactListFragment.Contract {

    private ContactListFragment mContactListFragment;
    private ContactViewFragment mContactViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        mContactListFragment = (ContactListFragment)getFragmentManager().findFragmentById(R.id.list_fragment_container);

        if (mContactListFragment == null) {
            mContactListFragment = new ContactListFragment();
            getFragmentManager().beginTransaction().add(R.id.list_fragment_container, mContactListFragment).commit();
        }

        mContactViewFragment = (ContactViewFragment)getFragmentManager().findFragmentById(R.id.view_fragment_container);

        if (mContactViewFragment == null && findViewById(R.id.view_fragment_container) != null) {
            mContactViewFragment = new ContactViewFragment();
            mContactViewFragment.setPosition(0);
            getFragmentManager().beginTransaction().add(R.id.view_fragment_container, mContactViewFragment).commit();
        }
    }

    @Override
    public void selectedPosition(int position) {
        if (mContactViewFragment == null) {
            Intent i = new Intent(this, ContactViewActivity.class);
            i.putExtra(ContactViewActivity.EXTRA, position);
            startActivity(i);
        } else {
            mContactViewFragment.setPosition(position);
        }
    }
}
