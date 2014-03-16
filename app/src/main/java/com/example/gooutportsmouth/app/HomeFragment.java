package com.example.gooutportsmouth.app;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gooutportsmouth.helper.ImageLoader;
import com.example.gooutportsmouth.helper.TouchImageView;
import com.example.gooutportsmouth.helper.Utils;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private Utils utils;
    private TouchImageView touchImageView;
    private ArrayList<String> linkz;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        int loader = R.drawable.loader;
        linkz = new ArrayList<String>();

        utils = new Utils(getActivity().getApplicationContext());
        touchImageView = (TouchImageView) rootView.findViewById(R.id.image2);

        ImageView image = (ImageView) rootView.findViewById(R.id.image);

        linkz = utils.grabLiquidImages("http://www.tick.it/media/Galleries/37970/");

        Log.e("Link for IMAGE", linkz.get(0));

        ImageLoader imgLoader = new ImageLoader(getActivity().getApplicationContext());

        imgLoader.DisplayImage("http://www.tigertiger.co.uk/media/49853/Image3.jpg", loader, image);
        imgLoader.DisplayImage("http://www.tick.it/media/Galleries/37970/1944645_main.jpg", loader, touchImageView);

        return rootView;
    }
}
