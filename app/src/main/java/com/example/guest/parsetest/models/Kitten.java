package com.example.guest.parsetest.models;

import com.parse.FindCallback;
import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by Guest on 12/3/15.
 */

@ParseClassName("Kitten")
public class Kitten extends ParseObject {

    public Kitten() { };

    public Kitten(String name, String owner, String birthday) {
        put("name", name);
        put("owner", owner);
        put("birthday", birthday);
    }

    public static void findAll(FindCallback<Kitten> callback) {
        ParseQuery<Kitten> query = ParseQuery.getQuery(Kitten.class);
        query.findInBackground(callback);
    }

    public String getName() {
        return getString("name");
    }

    public void setName(String name) {
        put("name", name);
    }

    public String getOwner() {
        return getString("owner");
    }

    public void setOwner(String owner) {
        put("owner", owner);
    }

    public String getBirthday() {
        return getString("birthday");
    }

    public void setBirthday(String birthday) {
        put("birthday", birthday);
    }
}
