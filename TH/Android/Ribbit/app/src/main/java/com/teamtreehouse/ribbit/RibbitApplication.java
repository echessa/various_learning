package com.teamtreehouse.ribbit;

import android.app.Application;

import com.parse.Parse;

public class RibbitApplication extends Application {
	
	@Override
	public void onCreate() { 
		super.onCreate();
	    Parse.initialize(this, 
	    	"Qjbfr6k6l8xaZpJe7ssE11nJD4wicCAtbcdv3zcC",
	    	"mPjERX4vkgTe4sLb6TsjdEKEHQGWLeGX8gwszu3E");
	}
}
