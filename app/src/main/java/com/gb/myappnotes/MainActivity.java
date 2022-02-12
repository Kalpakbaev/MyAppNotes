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
            NotesFragment notesFragment = new NotesFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.notes,notesFragment).commit();
            if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
                DescriptionsFragment descriptionsFragment = new DescriptionsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.descriptions,descriptionsFragment).commit();
            }
        }
    }
}