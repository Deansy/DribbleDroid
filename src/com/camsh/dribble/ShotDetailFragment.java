package com.camsh.dribble;

import android.app.Fragment;
import android.graphics.Color;
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
        ScrollView view = (ScrollView)inflater.inflate(R.layout.card_detail, container, false);

        LinearLayout card = (LinearLayout)view.findViewById(R.id.cardLayout);

        if (shot.getCommentCount() > 0) {

            for (int i = 0; i < shot.getComments().size(); i++) {
                View commentView = inflater.inflate(R.layout.list_comment, container, false);

                // If EVEN
                if (i % 2 == 0)
                {
                    commentView.setBackgroundColor(Color.argb(255, 81, 82, 84));
                }
                else {
                    commentView.setBackgroundColor(Color.argb(255, 74, 75, 77));
                }

                TextView tv = (TextView)commentView.findViewById(R.id.bodyText);
                tv.setText(shot.getComment(i).getBody());
                tv = (TextView)commentView.findViewById(R.id.authorText);
                tv.setText(shot.getComment(i).getAuthor().getName());

                card.addView(commentView);
            }
        }


        ImageView iv = (ImageView)view.findViewById(R.id.imageView1);

        Ion.with(iv)
                .placeholder(R.drawable.url2)
                .load(shot.getImageUrl());

        ((TextView) view.findViewById(R.id.title)).setText(shot.getTitle());


        return view;
    }


}
