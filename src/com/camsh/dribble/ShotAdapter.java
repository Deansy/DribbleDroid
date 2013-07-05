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
import java.util.ArrayList;

public class ShotAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Shot> mShots;

    public ShotAdapter(Context c, ArrayList<Shot> shots) {
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

    public void add(Shot shot) {
        mShots.add(shot);
    }

    public void addAll(ArrayList<Shot> list) {
        mShots.addAll(list);
    }

    public void clear() {
        mShots.clear();    }

    public ArrayList<Shot> getShots() {
        return mShots;
    }

    public Shot getItem(int position) {
        return mShots.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

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

        Ion.with(imageView)
                .placeholder(R.drawable.url2)
                .load(mShots.get(position).getImageUrl());

//TODO: Move to the settings
//        if (mShots.get(position).getImageTeaserUrl() != null) {
//            Ion.with(imageView)
//                    .placeholder(R.drawable.url2)
//                    .load(mShots.get(position).getImageTeaserUrl());
//
//        }
//        else {
//            Ion.with(imageView)
//                    .placeholder(R.drawable.url2)
//                    .load(mShots.get(position).getImageUrl());
//        }

        ((TextView) view.findViewById(R.id.title)).setText(mShots.get(position).getTitle());

        return view;
    }
}