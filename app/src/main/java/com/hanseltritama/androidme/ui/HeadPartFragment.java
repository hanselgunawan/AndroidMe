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

public class HeadPartFragment extends Fragment{

    private static final String TAG = "HeadPartFragment";

    private List<Integer> mImageIds;
    private int mListIndex;

    public HeadPartFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_head_part, container, false);

        ImageView imageView = rootView.findViewById(R.id.head_part_image_view);

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

    public void setListIndex(int listIndex) {

        mListIndex = listIndex;

    }
}
