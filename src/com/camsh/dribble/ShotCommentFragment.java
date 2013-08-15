package com.camsh.dribble;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.camsh.dribble.Model.Shot;

/**
 * Created by Cameron on 15/08/13.
 */
public class ShotCommentFragment extends ListFragment {

    private DribbleDroid appState;

    private Shot shot;
    private int shotID;
    private CommentAdapter adapter;


    ShotCommentFragment(Shot shot) {
        this.shot = shot;
    }

    ShotCommentFragment(int shotID) {
        this.shotID = shotID;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        appState = (DribbleDroid)this.getActivity().getApplication();


        if (shot == null) {
            this.shot = appState.getApi().getShot(shotID, true, getActivity().getBaseContext());
        }

        LinearLayout view = (LinearLayout)inflater.inflate(R.layout.fragment_comment_list, container, false);


        adapter = new CommentAdapter(this.getActivity(), shot.getComments());
        setListAdapter(adapter);


        //return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}
