package com.example.bobantalevski.smellslikebakin;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements ListFragment.OnRecipeSelectedInterface, GridFragment.OnRecipeSelectedInterface{

    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";

    // refactored this as a field so it will always point to the fragment attached to this
    // activity, both on start of the app and on subsequent onCreate calls due to either
    // device rotation, home button presses, or anything that triggers subsequent onCreate calls
    private ListFragment savedListFragment;
    private GridFragment savedGridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);
        if (!isTablet) {

            // using findFragmentByTag prevents an exception if at the spot used by findFragmentById
            // which is R.id.placeholder we have a ViewPagerFragment instead, i.e. if we rotate
            // the device after tapping to see a certain recipe
            // previously used line
            // savedListFragment = (ListFragment) getFragmentManager().findFragmentById(R.id.placeHolder);
            savedListFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if (savedListFragment == null) {
                savedListFragment = new ListFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder, savedListFragment, LIST_FRAGMENT);
                fragmentTransaction.commit();
            }
        } else {
            savedGridFragment = (GridFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if (savedGridFragment == null) {
                savedGridFragment = new GridFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeHolder, savedGridFragment, LIST_FRAGMENT);
                fragmentTransaction.commit();
            }
        }
    }

    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onGridRecipeSelected(int index) {
        DualPaneFragment fragment = new DualPaneFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
