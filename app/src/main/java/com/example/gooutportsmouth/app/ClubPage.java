package com.example.gooutportsmouth.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class ClubPage extends ActionBarActivity {

    private ViewFlipper mViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide the title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        Intent intent = getIntent();
        int position = intent.getIntExtra(PortsmouthClubs.EXTRA_MESSAGE, 0);

        setContentView(adjustContentView(R.layout.club_page, position));


        mViewFlipper = (ViewFlipper) findViewById(R.id.slideshow);


        mViewFlipper.setAutoStart(true);
        mViewFlipper.setFlipInterval(3000);
        mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.abc_fade_in));
        mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.abc_fade_out));
        mViewFlipper.startFlipping();
    }


    public int adjustContentView(int templateView, int position) {
        return templateView;
    }


}
