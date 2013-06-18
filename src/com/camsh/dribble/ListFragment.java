package com.camsh.dribble;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.camsh.dribble.Model.Shot;

import java.util.ArrayList;

/**
 * Created by Cameron on 14/06/13.
 */
public class ListFragment extends Fragment {

    public ListFragment() {
        currentPage = 1;
    }

    private DribbleDroid appState;
    private ListView listView;
    private ShotAdapter shotAdapter;

    private int currentPage;

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

        //TODO: Stylise
        View textView = new TextView(getActivity());
        ((TextView) textView).setText("NEXT");

        listView.addFooterView(textView);

        listView.setAdapter(shotAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Intent tempIntent = new Intent(getBaseContext(), ShotDetailActivity.class);
//                tempIntent.putExtra("shotID", shotAdapter.getShots().get(position).getId());
//                startActivity(tempIntent);
                if (v instanceof TextView) {
                    // GOTO NEXT PAGE
                    Log.d("test" ,"test");

                    currentPage++;
                    ArrayList<Shot> list;
                    if ( ((MainActivity) getActivity()).activeView.equals("Popular")){
                        list = appState.getApi().getPopularList(getActivity(), 12, currentPage);
                    }
                    else if ( ((MainActivity) getActivity()).activeView.equals("Everyone")){
                        list = appState.getApi().getEveryoneList(getActivity(), 12, currentPage);
                    }
                    else if ( ((MainActivity) getActivity()).activeView.equals("Debut")){
                        list = appState.getApi().getDebutList(getActivity(), 12, currentPage);
                    }
                    else {
                        list = appState.getApi().getPopularList(getActivity(), 12, 2);
                    }

                    Toast.makeText(getActivity(),"new page is: " + currentPage, Toast.LENGTH_SHORT).show();

                    getShotAdapter().clear();
                    getShotAdapter().addAll(list);

                    getShotAdapter().notifyDataSetChanged();

                    getListView().setSelectionAfterHeaderView();
                }
                else {
                    ((MainActivity) getActivity()).transitionToDetailFrag(position);
                }

            }
        });



        return view;
    }

}
