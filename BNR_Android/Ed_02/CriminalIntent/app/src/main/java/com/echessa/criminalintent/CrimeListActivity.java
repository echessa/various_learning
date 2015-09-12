package com.echessa.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by echessa on 9/11/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}
