package com.camsh.dribble;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.camsh.dribble.Model.Shot;

import java.util.ArrayList;

/**
 * Created by Cameron on 13/06/13.
 */
public class TestActivity extends Activity {
    DribbleDroid appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        appState = (DribbleDroid)this.getApplication();

        final ListView listview = (ListView) findViewById(R.id.listview);

        ArrayList<Shot> shots = appState.api.getPopularList();

        final ImageAdapter imageAdapter = new ImageAdapter(this, shots);

        listview.setAdapter(imageAdapter);
    }
}
