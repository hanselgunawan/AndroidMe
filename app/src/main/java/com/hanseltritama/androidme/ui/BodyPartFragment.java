package com.hanseltritama.androidme.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hanseltritama.androidme.R;
import com.hanseltritama.androidme.data.AndroidImageAssets;

import java.util.List;
import java.util.zip.Inflater;

public class BodyPartFragment extends Fragment {

    //Tag for logging
    private static final String TAG = "BodyPartFragment";

    private List<Integer> mImageIds;
    private int mListIndex;

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
        //imageView.setImageResource(AndroidImageAssets.getBodies().get(0));

        if(mImageIds != null) {

            imageView.setImageResource(mImageIds.get(mListIndex));

        } else {

            Log.v(TAG, "This fragment has a null list of image IDs");

        }

        return rootView;
    }

    public void setImageIds(List<Integer> imageIds) {

        mImageIds = imageIds;

    }

    public void setListIndex(int listindex) {

        mListIndex = listindex;

    }
}
