package com.example.basic;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private RecyclerView recycle;
    private RecyclerView.Adapter adapter;

    List<ListView> listViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recycle = findViewById(R.id.recyler);
        recycle.setHasFixedSize(true);
        recycle.setLayoutManager(new LinearLayoutManager(this));

        listViews = new ArrayList<>();
        for(int i =1;i<10;i++){
            ListView li = new ListView("heading "+(i+1),"Lipsum temp text for description");
            listViews.add(li);
        }



        adapter = new MyAdapter(listViews,this);
        recycle.setAdapter(adapter);
    }
}
