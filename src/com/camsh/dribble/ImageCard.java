package com.camsh.dribble;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.fima.cardsui.objects.Card;
import com.loopj.android.image.SmartImageView;

/**
 * Created by Cameron on 19/05/13.
 */
public class ImageCard extends Card {
    String url;
    public ImageCard(String title, String imageURL){
        super(title, R.drawable.url1);
        url = imageURL;
    }

    @Override
    public View getCardContent(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_picture, null);

        ((TextView) view.findViewById(R.id.title)).setText(title);
        if (url != null) {
            ((SmartImageView) view.findViewById(R.id.imageView1)).setImageUrl(url);
        }
        else {
            ((SmartImageView) view.findViewById(R.id.imageView1)).setImageResource(image);
        }

        return view;
    }
}
