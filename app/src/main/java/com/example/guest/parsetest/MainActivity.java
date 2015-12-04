package com.example.guest.parsetest;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.parse.FindCallback;
import com.parse.ParseException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText kittenNameEditText = (EditText) findViewById(R.id.kittenNameEditText);

        findViewById(R.id.createKittenButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = kittenNameEditText.getText().toString();
                Kitten newKitten = new Kitten(name);
                newKitten.saveInBackground();
                adapter.add(name);
                kittenNameEditText.setText("");
            }
        });

        Kitten.findAll(new FindCallback<Kitten>() {
            @Override
            public void done(List<Kitten> kittens, ParseException e) {
                ArrayList<String> kittenNames = new ArrayList<String>();
                for (int i = 0; i < kittens.size(); i++) {
                    kittenNames.add(kittens.get(i).getString("name"));
                }
                adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, kittenNames);
                setListAdapter(adapter);
            }
        });

    }
}
