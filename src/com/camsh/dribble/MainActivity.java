package com.camsh.dribble;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.*;
import android.widget.*;

import com.camsh.dribble.Model.Shot;

import java.util.ArrayList;

public class MainActivity extends Activity {
    DribbleDroid appState;

    private String[] mPlanetTitles;
    private ListView mDrawerList;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    ShotAdapter shotAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appState = (DribbleDroid)this.getApplication();
        shotAdapter = new ShotAdapter(this, appState.getApi().getPopularList(this, 30));

        FragmentManager fragmentManager = getFragmentManager();
        ListFragment fragment = new ListFragment();
        fragment.setShotAdapter(shotAdapter);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,fragment);
        fragmentTransaction.commit();


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


        String[] temp = {"Popular List", "...", "Settings"};
        mPlanetTitles = temp;

        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mPlanetTitles));

        // Set the first item checked.
        mDrawerList.setItemChecked(0, true);


        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment newFrag = null;
                switch (i) {
                    case 0:
                        newFrag = new ListFragment();
                        ((ListFragment)newFrag).setShotAdapter(shotAdapter);
                        break;
                    case 1:
                        break;
                }
                if (newFrag != null) {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, newFrag)
                            .commit();

                }

                mDrawerList.clearChoices();


                mDrawerLayout.closeDrawers();
            }
        });
    }

    public void transitionToDetailFrag(int position) {
        Fragment newFragment = new ShotDetailFragment(shotAdapter.getItem(position));
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        transaction.commit();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        //TODO: Replace refresh with icon
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        if (item.getTitle().equals("Refresh")) {
            ListFragment frag = (ListFragment)getFragmentManager().findFragmentById(R.id.fragment_container);

            ArrayList<Shot> list = appState.getApi().getPopularList(this, 30);
            frag.getShotAdapter().clear();
            frag.getShotAdapter().addAll(list);

            frag.getShotAdapter().notifyDataSetChanged();
        }

        return super.onOptionsItemSelected(item);
    }

}
