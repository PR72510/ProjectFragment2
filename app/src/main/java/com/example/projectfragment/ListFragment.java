package com.example.projectfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private static final String TAG = "ListFragment";
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    View view;

    public ListFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
       view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated: ");
        super.onActivityCreated(savedInstanceState);
        recyclerView = view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new PersonAdapter(this.getActivity(),ApplicationClass.people);
        recyclerView.setAdapter(myAdapter);

    }

    public void notifyDataChanged(){
        myAdapter.notifyDataSetChanged();
    }
}
