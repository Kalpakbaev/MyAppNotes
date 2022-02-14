package com.gb.myappnotes;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DescriptionsFragment extends Fragment {

    public static final String ARG_NOTES = "notes";
    private Notes notes;

    public static DescriptionsFragment newInstance(Notes notes) {
        DescriptionsFragment fragment = new DescriptionsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTES, notes);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_descriptions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        notes = getArguments().getParcelable(ARG_NOTES);
        String[] descriptions = getResources().getStringArray(R.array.descriptions);
        for (int i = 0; i < descriptions.length; i++);
        String descriptionsName = descriptions[0];
        TextView textView = new TextView(getContext());
        textView.setTextSize(25f);
        textView.setText(descriptionsName);
        ((LinearLayout) view).addView(textView);


    }
}