package com.example.guest.parsetest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.guest.parsetest.models.Kitten;
import com.example.guest.parsetest.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText kittenNameEditText = (EditText) findViewById(R.id.kittenNameEditText);
        final EditText birthdayEditText = (EditText) findViewById(R.id.birthdayEditText);
        final EditText ownerEditText = (EditText) findViewById(R.id.ownerEditText);

        findViewById(R.id.createKittenButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = kittenNameEditText.getText().toString();
                String birthday = birthdayEditText.getText().toString();
                String owner = ownerEditText.getText().toString();
                Kitten newKitten = new Kitten(name, owner, birthday);
                newKitten.saveInBackground();
                Intent intent = new Intent(MainActivity.this, KittenListActivity.class);
                startActivity(intent);
            }
        });
    }
}
