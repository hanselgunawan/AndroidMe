package com.hanseltritama.androidme.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hanseltritama.androidme.R;
import com.hanseltritama.androidme.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        Bundle bundle = getIntent().getExtras();

        int headIndex = bundle.getInt("HEAD_INDEX");
        int bodyIndex = bundle.getInt("BODY_INDEX");
        int legIndex = bundle.getInt("LEG_INDEX");


        // only create new fragments when there is no previously saved state
        if(savedInstanceState == null) {

            HeadPartFragment headPartFragment = new HeadPartFragment();
            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            LegPartFragment legPartFragment = new LegPartFragment();

            headPartFragment.setImageIds(AndroidImageAssets.getHeads());
            headPartFragment.setListIndex(headIndex);
            bodyPartFragment.setImageIds(AndroidImageAssets.getBodies());
            bodyPartFragment.setListIndex(bodyIndex);
            legPartFragment.setImageIds(AndroidImageAssets.getLegs());
            legPartFragment.setListIndex(legIndex);

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headPartFragment)
                    .add(R.id.body_container, bodyPartFragment)
                    .add(R.id.leg_container, legPartFragment)
                    .commit();
        }

    }
}
