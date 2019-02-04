package com.hanseltritama.androidme.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.hanseltritama.androidme.R;
import com.hanseltritama.androidme.data.AndroidImageAssets;

public class ListActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    // Variables to store the values for the list index of the selected images
    private int headIndex = 0;
    private int bodyIndex = 0;
    private int legIndex = 0;

    private boolean mTwoPane;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_list);

        // Determine between single OR two-pane
        if(findViewById(R.id.android_me_linear_layout) != null) {

            mTwoPane = true;

            // Hide the Next button on Tablet view
            Button next_button = findViewById(R.id.next_button);
            next_button.setVisibility(View.GONE);

            // Set list into 2 columns
            GridView gridView = findViewById(R.id.body_grid_view);
            gridView.setNumColumns(2);

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

        } else {

            mTwoPane = false;

        }

        MasterListFragment masterListFragment = new MasterListFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.master_list_framelayout, masterListFragment)
                .commit();
    }

    public void onImageSelected(int position) {

        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();

        int bodyPartNumber = position / 12;

        // Handle one OR two-pane device
        if(mTwoPane) {

            BodyPartFragment newBodyPartFragment = new BodyPartFragment();

            switch (bodyPartNumber) {

                case 0:
                    newBodyPartFragment.setImageIds(AndroidImageAssets.getHeads());
                    newBodyPartFragment.setListIndex(position % 12);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, newBodyPartFragment)
                            .commit();
                    break;
                case 1:
                    newBodyPartFragment.setImageIds(AndroidImageAssets.getHeads());
                    newBodyPartFragment.setListIndex(position % 12);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, newBodyPartFragment)
                            .commit();
                    break;
                case 2:
                    newBodyPartFragment.setImageIds(AndroidImageAssets.getHeads());
                    newBodyPartFragment.setListIndex(position % 12);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.leg_container, newBodyPartFragment)
                            .commit();
                    break;
                default: break;

            }

        } else {

            switch (bodyPartNumber) {

                case 0: headIndex = position % 12; break;
                case 1: bodyIndex = position % 12; break;
                case 2: legIndex = position % 12; break;
                default: break;

            }

        }

        // Bundle is a set of key-value pairs
        Bundle bundle = new Bundle();
        bundle.putInt("HEAD_INDEX", headIndex);
        bundle.putInt("BODY_INDEX", bodyIndex);
        bundle.putInt("LEG_INDEX", legIndex);

        final Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);

        Button next_button = findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);

            }
        });

    }

}
