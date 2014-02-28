package com.example.gooutportsmouth.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PortsmouthClubs extends ActionBarActivity implements AdapterView.OnItemClickListener {

    ArrayList<String> clubs;
    ListView list;
    LazyAdapter adapter;
    Animation animAlpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide the title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_portsmouth_clubs);

        clubs = new ArrayList<String>();
        animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);

        clubs.add("Liquid");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");
        clubs.add("Tiger Tiger");


        list = (ListView) findViewById(R.id.list);
        adapter = new LazyAdapter(this, clubs);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        view.startAnimation(animAlpha);
    }
}
