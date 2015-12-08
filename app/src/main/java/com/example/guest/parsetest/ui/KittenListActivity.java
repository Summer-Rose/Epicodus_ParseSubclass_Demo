package com.example.guest.parsetest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.example.guest.parsetest.R;
import com.example.guest.parsetest.adapters.KittenAdapter;
import com.example.guest.parsetest.models.Kitten;
import com.parse.FindCallback;
import com.parse.ParseException;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class KittenListActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private KittenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitten_list);
        ButterKnife.bind(this);

        Kitten.findAll(new FindCallback<Kitten>() {
            @Override
            public void done(List<Kitten> kittens, ParseException e) {

                adapter = new KittenAdapter(getApplicationContext(), kittens);
                mRecyclerView.setAdapter(adapter);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(KittenListActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);

                mRecyclerView.setHasFixedSize(true);
            }
        });
    }
}