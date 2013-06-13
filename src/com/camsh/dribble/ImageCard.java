package com.camsh.dribble;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.camsh.dribble.Model.Shot;
import com.fima.cardsui.objects.Card;

import com.squareup.picasso.Picasso;

/**
 * Created by Cameron on 19/05/13.
 */
public class ImageCard extends Card {
    String url;
    public ImageCard(Shot shot){
        super(shot.getTitle(), R.drawable.url1);

        url = shot.getImageUrl();
    }

    @Override
    public View getCardContent(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_picture, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);

        ((TextView) view.findViewById(R.id.title)).setText(title);

        Picasso.with(context).setDebugging(true);

        Picasso.with(context)
                .load(url)
                .placeholder(image)
                .into(imageView);

        return view;
    }
}
