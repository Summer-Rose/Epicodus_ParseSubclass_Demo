package com.example.guest.parsetest;

import com.parse.FindCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 12/3/15.
 */

@ParseClassName("Kitten")
public class Kitten extends ParseObject {
    private String mName;

    public Kitten() { };

    public Kitten(String name) {
        mName = name;
        put("name", name);
    }

    public static void findAll(FindCallback<Kitten> callback) {
        ParseQuery<Kitten> query = ParseQuery.getQuery(Kitten.class);
        query.findInBackground(callback);
    }
}
