package com.gb.myappnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState==null){
            NotesFragment notesFragment = NotesFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.notes,notesFragment).commit();
            if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
                Notes defaultNotes = new Notes(R.id.descriptions);
                DescriptionsFragment descriptionsFragment = DescriptionsFragment.newInstance(defaultNotes);
                getSupportFragmentManager().beginTransaction().replace(R.id.descriptions,descriptionsFragment).commit();
            }
        }
    }
}