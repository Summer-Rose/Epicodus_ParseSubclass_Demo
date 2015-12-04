package com.example.guest.parsetest;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Guest on 12/3/15.
 */
public class ParseTestApplication extends Application {
    @Override public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(Kitten.class);
        Parse.initialize(this, "NUF3Zno2ci0DasLAVHXWP4NiFU398KRxEaPavmZ2", "NbqbPVnVm30hIX6UMWF5Xml3jNe2CoDt5l4I6DlB");
    }
}
