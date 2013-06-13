package com.camsh.dribble;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.camsh.dribble.Model.Shot;
import com.koushikdutta.ion.Ion;

/**
 * Created by Cameron on 14/06/13.
 */
public class ShotDetailFragment extends Fragment {

    DribbleDroid appState;
    Shot shot;

    ShotDetailFragment(Shot shot) {
        this.shot = shot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        appState = (DribbleDroid)this.getActivity().getApplication();
        View view = inflater.inflate(R.layout.image_card, container, false);


        ImageView iv = (ImageView)view.findViewById(R.id.imageView1);

        Ion.with(iv)
                .placeholder(R.drawable.url2)
                .load(shot.getImageUrl());

        ((TextView) view.findViewById(R.id.title)).setText(shot.getTitle());


        return view;
    }

}
