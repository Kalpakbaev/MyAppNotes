package com.gb.myappnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState==null){
            NotesFragment notesFragment = NotesFragment.newInstance(R.id.note);
            getSupportFragmentManager().beginTransaction().replace(R.id.note,notesFragment).commit();

        }
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            Notes defaultNotes = new Notes(0);
            DescriptionsFragment descriptionsFragment = DescriptionsFragment.newInstance(defaultNotes);
            getSupportFragmentManager().beginTransaction().replace(R.id.descriptions,descriptionsFragment).commit();
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        Fragment backStackFragment = (Fragment) getSupportFragmentManager()
                .findFragmentById(R.id.note);
        if (backStackFragment != null && backStackFragment instanceof NotesFragment) {
            onBackPressed();
        }
    }
}