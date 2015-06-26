package com.echessa.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Joyce Echessa on 6/26/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
