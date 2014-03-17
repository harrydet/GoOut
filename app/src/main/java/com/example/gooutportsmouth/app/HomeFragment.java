package com.example.gooutportsmouth.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gooutportsmouth.helper.Utils;

public class HomeFragment extends Fragment {

    private Utils utils;
    ImageView logoImage;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        logoImage = (ImageView) rootView.findViewById(R.id.logo);

        ClubPage activity = (ClubPage) getActivity();
        switch (activity.getPosition()) {
            case 0:
                logoImage.setImageResource(R.drawable.liquid_logo);
                break;
            case 1:
                logoImage.setImageResource(R.drawable.tiger_logo);
                break;
            case 2:
                logoImage.setImageResource(R.drawable.astoria_logo);
        }

        return rootView;
    }
}
