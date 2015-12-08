package com.example.guest.parsetest;

import android.app.Application;

import com.example.guest.parsetest.models.Kitten;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Guest on 12/3/15.
 */
public class KittenCreator extends Application {
    @Override public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(Kitten.class);
        Parse.initialize(this, this.getString(R.string.parse_application_id), this.getString(R.string.parse_client_key));
    }
}
