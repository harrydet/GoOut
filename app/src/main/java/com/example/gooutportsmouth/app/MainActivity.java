package com.example.gooutportsmouth.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {


    //Button animation variable
    Animation animAlpha;
    TextView town1;
    TextView town2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide the title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        setupWidgets();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.town1text) {
            v.startAnimation(animAlpha);
            callPortsmouth(v);
        }

        if (v.getId() == R.id.town2text) {
            v.startAnimation(animAlpha);
        }
    }

    public void setupWidgets() {
        town1 = (TextView) findViewById(R.id.town1text);
        town1.setOnClickListener(this);

        town2 = (TextView) findViewById(R.id.town2text);
        town2.setOnClickListener(this);

        animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
    }

    public void callPortsmouth(View v) {
        Intent intent = new Intent(this, PortsmouthClubs.class);
        startActivity(intent);
    }
}
