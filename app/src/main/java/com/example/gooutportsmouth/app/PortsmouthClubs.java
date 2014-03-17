package com.example.gooutportsmouth.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PortsmouthClubs extends ActionBarActivity implements AdapterView.OnItemClickListener {

    ArrayList<String> clubs;
    ArrayList<Integer> images;
    ListView list;
    LazyAdapter adapter;

    public final static String EXTRA_MESSAGE = "com.example.gooutportsmouth.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide the title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_portsmouth_clubs);


        clubs = new ArrayList<String>();
        images = new ArrayList<Integer>();


        clubs.add("Liquid and Envy");
        clubs.add("Tiger Tiger");
        clubs.add("Astoria");

        images.add(R.drawable.row_background_liquid);
        images.add(R.drawable.row_background_liquid_color);
        images.add(R.drawable.row_background_tiger);
        images.add(R.drawable.row_background_tiger_color);
        images.add(R.drawable.row_background_astoria);
        images.add(R.drawable.row_background_astoria_color);


        list = (ListView) findViewById(R.id.list);
        adapter = new LazyAdapter(this, clubs, images);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        view.findViewById(R.id.second_layer).setAlpha(1f);
        Intent intent = new Intent(this, ClubPage.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);
    }

}
