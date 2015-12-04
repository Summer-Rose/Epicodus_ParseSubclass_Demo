package com.example.guest.parsetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.createKittenButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kitten meowsers = new Kitten("meowsers");
                meowsers.saveInBackground();
            }
        });

        Kitten.findAll(new FindCallback<Kitten>() {
            @Override
            public void done(List<Kitten> kittens, ParseException e) {
                TextView kittenListText = (TextView) findViewById(R.id.kittenListText);
                ArrayList<String> kittenNames = new ArrayList<String>();
                for (int i = 0; i < kittens.size(); i++) {
                    kittenNames.add(kittens.get(i).getString("name"));
                }
                kittenListText.setText(kittenNames.toString());
            }
        });

    }
}
