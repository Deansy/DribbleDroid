package com.camsh.dribble;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Cameron on 14/06/13.
 */
public class ListFragment extends Fragment {

    private ShotAdapter mShotAdapter;

    ListFragment(ShotAdapter adapter) {
        mShotAdapter = adapter;
    }

    private DribbleDroid appState;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        appState = (DribbleDroid)getActivity().getApplication();

        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(mShotAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Intent tempIntent = new Intent(getBaseContext(), ShotDetailActivity.class);
//                tempIntent.putExtra("shotID", shotAdapter.getShots().get(position).getId());
//                startActivity(tempIntent);
                ((MainActivity)getActivity()).transitionToDetailFrag(position);

            }
        });


        return view;
    }

}
