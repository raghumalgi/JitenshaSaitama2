package com.crossover.assignment.jitenshasaitama.nearbyplaces;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.crossover.assignment.jitenshasaitama.R;

public class NearByPlacesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_places);

        if (null == savedInstanceState) {
            initFragment(NearByPlacesFragment.newInstance());
        }
    }

    private void initFragment(Fragment detailFragment) {
        // Add the AddNoteFragment to the layout
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.contentFrame, detailFragment);
        transaction.commit();

//        Snackbar.make(mEmailView, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE)
//                .setAction(android.R.string.ok, new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                    }
//                });
    }



}
