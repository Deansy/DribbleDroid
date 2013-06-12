package com.camsh.dribble;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.camsh.dribble.Model.Shot;
import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.loopj.android.image.SmartImageView;


public class ShotDetailActivity extends Activity {
    int shotID;
    DribbleDroid appState;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shotdetail);

        Bundle extras = getIntent().getExtras();
        if (extras !=null) {
            shotID = extras.getInt("shotID");
        }
        appState = (DribbleDroid)this.getApplication();

        Shot theShot = appState.api.getShot(shotID,true);

        // init CardView
        CardUI mCardView = (CardUI) findViewById(R.id.cardview);
        mCardView.setSwipeable(false);

        mCardView.addCard(new ImageCard(theShot.getTitle(),null));

        // draw cards
        mCardView.refresh();
    }


}