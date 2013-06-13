package com.camsh.dribble;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.camsh.dribble.Model.Shot;

import java.util.ArrayList;

public class MainActivity extends Activity {
    DribbleDroid appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appState = (DribbleDroid)this.getApplication();


        ArrayList<Shot> shots = appState.api.getPopularList();

        ListView listview = (ListView) findViewById(R.id.listview);
        final ImageAdapter imageAdapter = new ImageAdapter(this, shots);
        listview.setAdapter(imageAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent tempIntent = new Intent(getBaseContext(), ShotDetailActivity.class);
                tempIntent.putExtra("shotID", imageAdapter.getShots().get(position).getId());
                startActivity(tempIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
