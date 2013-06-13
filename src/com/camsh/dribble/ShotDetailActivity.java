package com.camsh.dribble;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.camsh.dribble.Model.Shot;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;


public class ShotDetailActivity extends Activity {
    int shotID;
    DribbleDroid appState;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_card);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            shotID = extras.getInt("shotID");
        }
        appState = (DribbleDroid)this.getApplication();

        Shot theShot = appState.getApi().getShot(shotID, false);

        ImageView iv = (ImageView)findViewById(R.id.imageView1);

        Ion.with(iv)
                .placeholder(R.drawable.url2)
                .load(theShot.getImageUrl());


        ((TextView) findViewById(R.id.title)).setText(theShot.getTitle());
    }


}