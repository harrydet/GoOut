package com.example.gooutportsmouth.app;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.gooutportsmouth.helper.Utils;

public class HomeFragment extends Fragment {

    private Utils utils;
    ImageView slide1, slide2, slide3;
    ViewFlipper slideshow;
    TextView headerTitle;
    Typeface font;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        slide1 = (ImageView) rootView.findViewById(R.id.slide1);
        slide2 = (ImageView) rootView.findViewById(R.id.slide2);
        slide3 = (ImageView) rootView.findViewById(R.id.slide3);
        headerTitle = (TextView) rootView.findViewById(R.id.header_title);
        headerTitle.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Medium.ttf"));

        ClubPage activity = (ClubPage) getActivity();
        switch (activity.getPosition()) {
            case 0:
                slide1.setImageResource(R.drawable.liquid_slide1);
                slide2.setImageResource(R.drawable.liquid_slide2);
                slide3.setImageResource(R.drawable.liquid_slide3);
                headerTitle.setText("Liquid");
                break;
            case 1:
                headerTitle.setText("Tiger Tiger");
                break;
            case 2:
                headerTitle.setText("The Astoria");
                break;
            default:
                break;
        }

        slideshow = (ViewFlipper) rootView.findViewById(R.id.club_flipper);
        slideshow.setInAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.abc_fade_in));
        slideshow.setOutAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.abc_fade_out));
        slideshow.startFlipping();


        return rootView;
    }
}
