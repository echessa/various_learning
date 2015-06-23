package com.echessa.mycontacts;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactViewFragment extends Fragment {

    private int mColor;
    private Contact mContact;
    private int mPosition;
    private TextView mContactName;
    private FieldsAdapter mAdapter;


    public ContactViewFragment() {
        // Required empty public constructor
    }

    public void setPosition(int position) {
        mPosition = position;
        if (mAdapter != null) {
            mContact = ContactList.getInstance().get(mPosition);
            mAdapter.setContact(mContact);
            updateUI();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contact_view, container, false);

        mContact = ContactList.getInstance().get(mPosition);
        mContactName = (TextView)v.findViewById(R.id.contact_view_name);

        Toolbar toolbar = (Toolbar)v.findViewById(R.id.contact_view_toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.contact_view_edit) {
                    Intent i = new Intent(getActivity(), ContactEditActivity.class);
                    i.putExtra(ContactEditActivity.EXTRA, mPosition);
                    startActivity(i);
                    return true;
                }
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu_contact_view);

        ListView listView = (ListView)v.findViewById(R.id.contact_view_fields);
        mAdapter = new FieldsAdapter(mContact);
        listView.setAdapter(mAdapter);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        Palette palette = Palette.generate(bitmap);
        mColor = palette.getDarkVibrantSwatch().getRgb();

        updateUI();

        return v;
    }

    private void updateUI() {
        mContactName.setText(mContact.getName());
        mAdapter.notifyDataSetChanged();
    }

    private class FieldsAdapter extends BaseAdapter {

        ArrayList<String> phoneNumbers;
        ArrayList<String> emails;

        FieldsAdapter(Contact contact) {
            this.setContact(contact);
        }

        public void setContact(Contact contact) {
            this.phoneNumbers = contact.phoneNumbers;
            this.emails = contact.emails;
        }

        @Override
        public int getCount() {
            return phoneNumbers.size() + emails.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.contact_view_field_row, parent, false);
            }

            String value = (String)getItem(position);

            TextView contactValue = (TextView)convertView.findViewById(R.id.contact_view_row_value);
            contactValue.setText(value);

            ImageView iv = (ImageView) convertView.findViewById(R.id.field_icon);

            if (isFirst(position)) {
                if (isEmail(position)) {
                    iv.setImageResource(R.drawable.ic_email);
                } else {
                    iv.setImageResource(R.drawable.ic_call);
                }
            }

            iv.setColorFilter(mColor);

            return convertView;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (isEmail(position)) {
                return emails.get(position - phoneNumbers.size());
            } else {
                return phoneNumbers.get(position);
            }
        }

        private boolean isEmail(int position) {
            if (position > phoneNumbers.size() - 1) {
                return true;
            } else {
                return false;
            }
        }

        private boolean isFirst(int position) {
            if (position == 0 || position == phoneNumbers.size()) {
                return true;
            }
            return false;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_contact_view, menu);
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
