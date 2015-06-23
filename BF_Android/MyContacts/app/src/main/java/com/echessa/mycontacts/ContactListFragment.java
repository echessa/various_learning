package com.echessa.mycontacts;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactListFragment extends Fragment {

    private ContactList mContacts;
    private ContactAdapter mAdapter;
    private Contract mContract;


    public ContactListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_contact_list, container, false);

        mContacts = ContactList.getInstance();

        Contact contact1 = new Contact();
        contact1.setName("Joyce Echessa");
        contact1.emails = new ArrayList<String>();
        contact1.emails.add("joyce@echessa.com");
        contact1.emails.add("echessa@joyce.com");
        contact1.phoneNumbers = new ArrayList<String>();
        contact1.phoneNumbers.add("123456789");
        contact1.phoneNumbers.add("987654321");
        mContacts.add(contact1);

        Contact contact2 = new Contact();
        contact2.setName("Jane Doe");
        contact2.emails = new ArrayList<String>();
        contact2.emails.add("jane@doe.com");
        contact2.emails.add("doe@jane.com");
        contact2.phoneNumbers = new ArrayList<String>();
        contact2.phoneNumbers.add("123456789");
        contact2.phoneNumbers.add("987654321");
        mContacts.add(contact2);

        Contact contact3 = new Contact();
        contact3.setName("John Doe");
        contact3.emails = new ArrayList<String>();
        contact3.emails.add("john@doe.com");
        contact3.emails.add("doe@john.com");
        contact3.phoneNumbers = new ArrayList<String>();
        contact3.phoneNumbers.add("123456789");
        contact3.phoneNumbers.add("987654321");
        mContacts.add(contact3);

        ListView listView = (ListView)v.findViewById(R.id.contact_list_view);
        mAdapter = new ContactAdapter(mContacts);
        listView.setAdapter(mAdapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            int previousFirstItem = 0;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                ActionBar ab = ((AppCompatActivity)getActivity()).getSupportActionBar();
                if (firstVisibleItem > previousFirstItem) {
                    ab.hide();
                } else if (firstVisibleItem < previousFirstItem) {
                    ab.show();
                }

                previousFirstItem = firstVisibleItem;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mContract != null) {
                    mContract.selectedPosition(position);
                }
            }
        });

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mContract = (Contract)getActivity();
        } catch (ClassCastException e) {
            throw new IllegalStateException("Activity does not implement contract");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContract = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_contact_list, menu);
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

    private class ContactAdapter extends ArrayAdapter<Contact> {
        ContactAdapter(ArrayList<Contact> contacts) {
            super(getActivity(), R.layout.contact_list_row, R.id.contact_row_name, contacts);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = super.getView(position, convertView, parent);

            Contact contact = getItem(position);

            TextView nameTextView = (TextView)convertView.findViewById(R.id.contact_row_name);
            nameTextView.setText(contact.getName());
            return convertView;
        }
    }

    public interface Contract {
        public void selectedPosition(int position);
    }

}
