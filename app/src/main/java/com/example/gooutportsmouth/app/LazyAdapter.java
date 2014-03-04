package com.example.gooutportsmouth.app;

/**
 * Created by Harry on 2/26/14.
 */


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LazyAdapter extends BaseAdapter {

    private Activity activity;
    private static LayoutInflater inflater = null;
    private ArrayList<String> data;
    private ArrayList<Integer> images;

    public LazyAdapter(Activity a, ArrayList<String> d, ArrayList<Integer> i) {
        activity = a;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        data = d;
        images = i;
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView name = (TextView) vi.findViewById(R.id.club_name);
        name.setText(data.get(position));

        vi.setBackground(activity.getApplicationContext().getResources().getDrawable(images.get(position * 2)));
        vi.findViewById(R.id.second_layer).setBackground(activity.getApplicationContext().getResources().getDrawable(images.get(position * 2 + 1)));

        ImageView secondLayer = (ImageView) vi.findViewById(R.id.second_layer);
        secondLayer.setAlpha(0.0f);

        int[] color = {Color.rgb(196, 26, 26), Color.rgb(115, 20, 20)};
        float[] place = {0, 1};
        Shader.TileMode tile_mode0 = Shader.TileMode.REPEAT; // or TileMode.REPEAT;
        LinearGradient lin_grad0 = new LinearGradient(0, 0, 0, 200, color, place, tile_mode0);
        Shader shader_gradient0 = lin_grad0;
        name.getPaint().setShader(shader_gradient0);

        return vi;

    }


}
