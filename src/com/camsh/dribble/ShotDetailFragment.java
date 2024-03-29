package com.camsh.dribble;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.camsh.dribble.Model.Shot;
import com.koushikdutta.ion.Ion;

/**
 * Created by Cameron on 14/06/13.
 */
public class ShotDetailFragment extends Fragment {

    DribbleDroid appState;
    Shot shot;
    int shotID;

    ShotDetailFragment(int shotID) {
        this.shotID = shotID;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        appState = (DribbleDroid)this.getActivity().getApplication();
        this.shot = appState.getApi().getShot(shotID, true, getActivity().getBaseContext());
        LinearLayout view = (LinearLayout)inflater.inflate(R.layout.fragment_card_detail, container, false);

        ImageView iv = (ImageView)view.findViewById(R.id.imageView1);

        Ion.with(iv)
                .placeholder(R.drawable.url2)
                .load(shot.getImageUrl());

        ((TextView) view.findViewById(R.id.title)).setText(shot.getTitle());



        if(shot.hasComments()) {
            FragmentManager fragmentManager = getFragmentManager();
            ShotCommentFragment fragment = new ShotCommentFragment(shotID);


            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.comment_fragment_container,fragment);
            fragmentTransaction.commit();

        }

        return view;
    }


}
