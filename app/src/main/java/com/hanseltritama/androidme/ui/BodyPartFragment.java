package com.hanseltritama.androidme.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hanseltritama.androidme.R;
import com.hanseltritama.androidme.data.AndroidImageAssets;

import java.util.zip.Inflater;

public class BodyPartFragment extends Fragment {

     //Constructor for the fragment
    public BodyPartFragment() {

    }

    //similar to OnCreate on an Activity
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflate this fragment to the Main layout

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView imageView = rootView.findViewById(R.id.body_part_image_view);

        //set an image to the imageView
        imageView.setImageResource(AndroidImageAssets.getBodies().get(0));

        return rootView;
    }
}
