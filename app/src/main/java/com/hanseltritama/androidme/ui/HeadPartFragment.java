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

public class HeadPartFragment extends Fragment{

    public HeadPartFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_head_part, container, false);

        ImageView imageView = rootView.findViewById(R.id.head_part_image_view);

        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));

        return rootView;

    }
}
