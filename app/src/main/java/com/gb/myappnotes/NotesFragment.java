package com.gb.myappnotes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NotesFragment extends Fragment {
    public static final String CURRENT_NOTES = "key";
    private Notes currentNotes;


    public static NotesFragment newInstance(int note) {
        NotesFragment fragment = new NotesFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CURRENT_NOTES, currentNotes);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            currentNotes = savedInstanceState.getParcelable(CURRENT_NOTES);
        } else {
            currentNotes = new Notes(0);
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            currentNotes = new Notes(0);
            showLand(currentNotes);

        }

        initView((LinearLayout) view);


    }


    private void initView(LinearLayout view) {
        String[] name = getResources().getStringArray(R.array.notes);
        for (int i = 0; i < name.length; i++) {
            TextView textViewOne = new TextView(getContext());
            textViewOne.setTextSize(30f);
            String notes_name = name[i];
            textViewOne.setText(notes_name);
            view.addView(textViewOne);
            final int finalI = i;
            textViewOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentNotes = new Notes(finalI);
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        showLand(currentNotes);
                    } else {
                        showPort();

                    }
                }


            });
        }


    }
    private void showPort() {
        NotesFragment notesFragment = NotesFragment.newInstance(R.id.note);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.note, notesFragment).addToBackStack("1").commit();
    }

    private void showLand(Notes currentNotes) {
        NotesFragment notesFragment = NotesFragment.newInstance(R.id.note);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.descriptions, notesFragment)
                .commit();
    }


}