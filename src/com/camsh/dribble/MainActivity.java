package com.camsh.dribble;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {
    DribbleDroid appState;

    private String[] mPlanetTitles;
    private ListView mDrawerList;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {

            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {

            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        appState = (DribbleDroid)this.getApplication();

        String[] temp = {"Popular List", "...", "Settings"};
        mPlanetTitles = temp;

        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mPlanetTitles));


        ListView listview = (ListView) findViewById(R.id.listview);
        final ShotAdapter shotAdapter = new ShotAdapter(this, appState.getApi().getPopularList(getBaseContext()));
        listview.setAdapter(shotAdapter);



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent tempIntent = new Intent(getBaseContext(), ShotDetailActivity.class);
                tempIntent.putExtra("shotID", shotAdapter.getShots().get(position).getId());
                startActivity(tempIntent);
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

}
