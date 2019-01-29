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

public class HeadPartFragment extends Fragment{

    private static final String TAG = "HeadPartFragment";
    private static final String IMAGE_LIST = "IMAGE_LIST";
    private static final String LIST_INDEX = "LIST_INDEX";

    private List<Integer> mImageIds;
    private int mListIndex;

    public HeadPartFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState != null) {

            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);

        }

        View rootView = inflater.inflate(R.layout.fragment_head_part, container, false);

        final ImageView imageView = rootView.findViewById(R.id.head_part_image_view);

        if(mImageIds != null) {

            imageView.setImageResource(mImageIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(mListIndex < mImageIds.size() - 1) mListIndex++;
                    else mListIndex = 0;

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

    public void setListIndex(int listIndex) {

        mListIndex = listIndex;

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle currentState) {

        currentState.putIntegerArrayList(IMAGE_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);

    }
}
