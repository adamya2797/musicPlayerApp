package com.example.letsplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;


public class CurrentList extends AppCompatActivity {
    Toolbar myListToolbar;
    ArrayList<File> curSongs;
    ListView mListView;
    String songs[];
    ArrayAdapter<String> mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_list);
        myListToolbar = findViewById(R.id.mListToolbar);
        setSupportActionBar(myListToolbar);
        getSupportActionBar().setTitle("Now Playing");
        mListView = findViewById(R.id.currentList);

        Intent songData = getIntent();
        curSongs = (ArrayList) songData.getParcelableArrayListExtra("songsList");
        songs = new String[curSongs.size()];

        for(int j = 0; j < curSongs.size();j++){
            songs[j] = curSongs.get(j).getName().replace(".mp3","").replace(".m4a","").replace(".wav","").replace(".m4b","");
            Log.i("Song Name: ",curSongs.get(j).getName());
        }

        mArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,songs);
        mListView.setAdapter(mArrayAdapter);



    }
}
