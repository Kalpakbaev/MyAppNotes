package com.gb.myappnotes;

import android.os.Bundle;
import android.view.LayoutInflater;;
import android.view.View;
import android.view.ViewGroup;

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
        String [] name = getResources().getStringArray(R.array.notes);
        String[] text = getResources().getStringArray(R.array.descriptions);
        String[] data = getResources().getStringArray(R.array.NoteDate);
        TextView noteName = new TextView(getContext());
        TextView noteDescription = new TextView(getContext());
        TextView date = new TextView(getContext());
        noteName.setTextSize(35f);
        noteDescription.setTextSize(25);
        date.setTextSize(15f);
        noteName.setText(name[notes.getNumber()]);
        noteDescription.setText(text[notes.getNumber()]);
        date.setText(String.format("Дата создания:%s", data[notes.getNumber()]));
        ((LinearLayout) view).addView(noteName);
        ((LinearLayout) view).addView(noteDescription);
        ((LinearLayout) view).addView(date);
    }
}