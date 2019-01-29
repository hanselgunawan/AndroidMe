package com.hanseltritama.androidme.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hanseltritama.androidme.R;
import com.hanseltritama.androidme.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        HeadPartFragment headPartFragment = new HeadPartFragment();
        BodyPartFragment bodyPartFragment = new BodyPartFragment();
        LegPartFragment legPartFragment = new LegPartFragment();

        headPartFragment.setImageIds(AndroidImageAssets.getHeads());
        headPartFragment.setListIndex(2);
        bodyPartFragment.setImageIds(AndroidImageAssets.getBodies());
        bodyPartFragment.setListIndex(2);
        legPartFragment.setImageIds(AndroidImageAssets.getLegs());
        legPartFragment.setListIndex(2);

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.head_container, headPartFragment)
                .add(R.id.body_container, bodyPartFragment)
                .add(R.id.leg_container, legPartFragment)
                .commit();

    }
}
