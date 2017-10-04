package com.example.bobantalevski.smellslikebakin;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelectedInterface{

    // refactored this as a field so it will always point to the fragment attached to this
    // activity, both on start of the app and on subsequent onCreate calls due to either
    // device rotation, home button presses, or anything that triggers subsequent onCreate calls
    private ListFragment savedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        savedFragment = (ListFragment) getFragmentManager().findFragmentById(R.id.placeHolder);
        if (savedFragment == null) {
            savedFragment = new ListFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeHolder, savedFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onListRecipeSelected(int index) {
        Toast.makeText(this, Recipes.names[index], Toast.LENGTH_SHORT).show();
    }
}
