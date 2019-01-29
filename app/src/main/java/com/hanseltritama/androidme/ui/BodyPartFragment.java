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

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class BodyPartFragment extends Fragment {

    //Tag for logging
    private static final String TAG = "BodyPartFragment";

    //Image List and Index Keys
    private static final String IMAGE_LIST = "IMAGE_LIST";
    private static final String LIST_INDEX = "LIST_INDEX";

    private List<Integer> mImageIds;
    private int mListIndex;

     //Constructor for the fragment
    public BodyPartFragment() {

    }

    //similar to OnCreate on an Activity
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState != null) {

            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);

        }

        //Inflate this fragment to the Main layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = rootView.findViewById(R.id.body_part_image_view);

        //set an image to the imageView
        //imageView.setImageResource(AndroidImageAssets.getBodies().get(0));

        if(mImageIds != null) {

            imageView.setImageResource(mImageIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListIndex < mImageIds.size() - 1) {

                        mListIndex++;

                    } else {

                        mListIndex = 0;

                    }

                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });

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

    @Override
    public void onSaveInstanceState(@NonNull Bundle currentState) {

        currentState.putIntegerArrayList(IMAGE_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);

    }
}
