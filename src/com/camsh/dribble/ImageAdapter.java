package com.camsh.dribble;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.camsh.dribble.Model.Shot;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Cameron on 13/06/13.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Shot> mShots;

    public ImageAdapter(Context c, ArrayList<Shot> shots) {
        mContext = c;
        mShots = shots;
    }

    public int getCount() {
        if (mShots == null) {
            return 0;
        }
        else {
            return mShots.size();
        }
    }

    public ArrayList<Shot> getShots() {
        return mShots;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = convertView;

        if (view == null) {
            view = inflater.inflate(R.layout.image_card, parent, false);
        }

        if (position == 0) {
            int topPadding = 12;
            int sidePadding = 15;
            float density = mContext.getResources().getDisplayMetrics().density;
            int sidePaddingInPixels = (int)(sidePadding * density);
            int topPaddingInPixels = (int)(topPadding * density);

            view.setPadding(sidePaddingInPixels,topPaddingInPixels,sidePaddingInPixels,0);

        }

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView1);
        Picasso.with(mContext).setDebugging(true);

//        Picasso.with(mContext)
//                .load(mShots.get(position).getImageUrl())
//                .placeholder(R.drawable.url1)
//                .into(imageView);

        Ion.with(imageView)
                .placeholder(R.drawable.url2)
                .load(mShots.get(position).getImageUrl());




        ((TextView) view.findViewById(R.id.title)).setText(mShots.get(position).getTitle());

        return view;
    }
}