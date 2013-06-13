package com.camsh.dribble;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.camsh.dribble.Model.Shot;
import com.fima.cardsui.views.CardUI;

import java.util.ArrayList;

public class MainActivity extends Activity {
    //API api;
    DribbleDroid appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //api = new API();
        appState = (DribbleDroid)this.getApplication();


//        GridView gridView = (GridView) findViewById(R.id.gridview);
//        final ImageAdapter adapter = new ImageAdapter(this, appState.api.getPopularList());
//        gridView.setAdapter(adapter);
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(MainActivity.this, adapter.getShots().get(position).getTitle(), Toast.LENGTH_SHORT).show();
//                //TODO: Open new activity to show detail of shot getShots().get(position), gg
//
//                Intent tempIntent = new Intent(getBaseContext(), ShotDetailActivity.class);
//                tempIntent.putExtra("shotID", adapter.getShots().get(position).getId());
//                startActivity(tempIntent);
//            }
//        });

        CardUI cardUI = (CardUI)findViewById(R.id.cardview);
        //Log.d("Tag", "" + cardUI.mColumnNumber);
        buildTimeline();



    }

    CardUI buildTimeline() {
        ArrayList<Shot> shots = appState.api.getPopularList();
        CardUI ui = (CardUI)findViewById(R.id.cardview);

        for (final Shot i: shots) {
            ImageCard tempCard = new ImageCard(i);

            tempCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent tempIntent = new Intent(getBaseContext(), ShotDetailActivity.class);
                    Intent tempIntent = new Intent(getBaseContext(), TestActivity.class);
                    tempIntent.putExtra("shotID", i.getId());
                    startActivity(tempIntent);
                }
            });

            ui.addCard(tempCard);
        }

        ui.refresh();

        return ui;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
