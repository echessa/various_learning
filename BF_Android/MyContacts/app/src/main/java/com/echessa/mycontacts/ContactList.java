package com.echessa.mycontacts;

import java.util.ArrayList;

/**
 * Created by echessa on 5/18/15.
 */
public class ContactList extends ArrayList<Contact> {
    private static ContactList sInstance = null;

    private ContactList(){}

    public static ContactList getInstance() {
        if (sInstance == null) {
            sInstance = new ContactList();
        }
        return sInstance;
    }
}
