package com.camsh.dribble;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.camsh.dribble.Model.Comment;
import com.camsh.dribble.Model.Shot;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by Cameron on 15/08/13.
 */
public class CommentAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Comment> mComments;

    public CommentAdapter(Context c, ArrayList<Comment> comments) {
        mContext = c;
        mComments = comments;
    }

    public int getCount() {
        if (mComments == null) {
            return 0;
        }
        else {
            return mComments.size();
        }
    }

    public void add(Comment comment) {
        mComments.add(comment);
    }

    public void addAll(ArrayList<Comment> list) {
        mComments.addAll(list);
    }

    public void clear() {
        mComments.clear();    }

    public ArrayList<Comment> getComments() {
        return mComments;
    }

    public Comment getItem(int position) {
        return mComments.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = convertView;

        if (view == null) {
            view = inflater.inflate(R.layout.list_comment, parent, false);
        }


        if (position % 2 == 0)
        {
            view.setBackgroundColor(Color.argb(255, 81, 82, 84));
        }
        else {
            view.setBackgroundColor(Color.argb(255, 74, 75, 77));
        }

        TextView tv = (TextView)view.findViewById(R.id.bodyText);
        tv.setText(mComments.get(position).getBody());
        tv = (TextView)view.findViewById(R.id.authorText);
        tv.setText(mComments.get(position).getAuthor().getName());

        return view;
    }

}
