package com.example.bobantalevski.smellslikebakin;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Boban Talevski on 10/3/2017.
 */

public class ListFragment extends Fragment {

    public interface OnRecipeSelectedInterface {
        public void onListRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // used for debugging activity and fragment lifecycle methods since we don't have
        // a call to super in this method
        // for debugging to work the fragment needs to extend LoggingFragment
        // and the activity needs to extend LoggingActivity
//        Log.d(LoggingFragment.TAG, "onCreateView");

        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();

        // have to add third parameter false to indicate we don't want to attach this view to
        // the ViewGroup container provided as the second parameter.
        // This is because the view will be automatically attached to the ViewGroup by the system
        // and not adding false will make it to be attached twice and throwing an IllegalStateException
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.listRecyclerView);
        ListAdapter listAdapter = new ListAdapter(listener);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
