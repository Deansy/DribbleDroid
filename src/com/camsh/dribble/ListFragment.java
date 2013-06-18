package com.camsh.dribble;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Cameron on 14/06/13.
 */
public class ListFragment extends Fragment {

    public ListFragment() {

    }

    private DribbleDroid appState;
    private ListView listView;
    private ShotAdapter shotAdapter;

    public void setShotAdapter(ShotAdapter shotAdapter) {
        this.shotAdapter = shotAdapter;
    }

    public ShotAdapter getShotAdapter() {
        return shotAdapter;
    }

    public ListView getListView() {
        return listView;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        appState = (DribbleDroid)getActivity().getApplication();

        if (shotAdapter == null) {
            shotAdapter = ((MainActivity)getActivity()).shotAdapter;
        }
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(shotAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Intent tempIntent = new Intent(getBaseContext(), ShotDetailActivity.class);
//                tempIntent.putExtra("shotID", shotAdapter.getShots().get(position).getId());
//                startActivity(tempIntent);
                ((MainActivity) getActivity()).transitionToDetailFrag(position);

            }
        });


        return view;
    }

}
