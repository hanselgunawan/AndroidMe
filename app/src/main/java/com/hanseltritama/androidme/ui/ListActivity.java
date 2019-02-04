package com.hanseltritama.androidme.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hanseltritama.androidme.R;

public class ListActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    // Variables to store the values for the list index of the selected images
    private int headIndex = 0;
    private int bodyIndex = 0;
    private int legIndex = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_list);

        MasterListFragment masterListFragment = new MasterListFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.master_list_framelayout, masterListFragment)
                .commit();
    }

    public void onImageSelected(int position) {

        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();

        int bodyPartNumber = position / 12;

        switch (bodyPartNumber) {

            case 0: headIndex = position % 12; break;
            case 1: bodyIndex = position % 12; break;
            case 2: legIndex = position % 12; break;
            default: break;

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
