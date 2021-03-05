package com.example.android.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Song> songsArrayList = new ArrayList<Song>();

    private void addSongs() {
        songsArrayList.add(new Song("Chucky vs. The Giant Tortoise", "Dance Gavin Dance", "Mothership"));
        songsArrayList.add(new Song("Young Robot", "Dance Gavin Dance", "Mothership"));
        songsArrayList.add(new Song("Frozen One", "Dance Gavin Dance", "Mothership"));
        songsArrayList.add(new Song("Flossie Dickey Bounce", "Dance Gavin Dance", "Mothership"));
        songsArrayList.add(new Song("Deception", "Dance Gavin Dance", "Mothership"));
        songsArrayList.add(new Song("Inspire the Liars", "Dance Gavin Dance", "Mothership"));
        songsArrayList.add(new Song("Philosopher King", "Dance Gavin Dance", "Mothership"));
        songsArrayList.add(new Song("Here Comes the Winner", "Dance Gavin Dance", "Mothership"));
        songsArrayList.add(new Song("Exposed", "Dance Gavin Dance", "Mothership"));
        songsArrayList.add(new Song("Betrayed by the Game", "Dance Gavin Dance", "Mothership"));
        songsArrayList.add(new Song("Petting Zoo Justice", "Dance Gavin Dance", "Mothership"));
        songsArrayList.add(new Song("Chocolate Jackalope", "Dance Gavin Dance", "Mothership"));
        songsArrayList.add(new Song("Man of the Year", "Dance Gavin Dance", "Mothership"));
        songsArrayList.add(new Song("Jesus H. Macy", "Dance Gavin Dance", "Acceptance Speech 2.0"));
        songsArrayList.add(new Song("The Robot with Human Hair, Pt. 4", "Dance Gavin Dance", "Acceptance Speech 2.0"));
        songsArrayList.add(new Song("Acceptance Speech", "Dance Gavin Dance", "Acceptance Speech 2.0"));
        songsArrayList.add(new Song("Carve", "Dance Gavin Dance", "Acceptance Speech 2.0"));
        songsArrayList.add(new Song("Doom & Gloom", "Dance Gavin Dance", "Acceptance Speech 2.0"));
        songsArrayList.add(new Song("Strawberry Swisher, Pt. 3", "Dance Gavin Dance", "Acceptance Speech 2.0"));
        songsArrayList.add(new Song("Honey Revenge", "Dance Gavin Dance", "Acceptance Speech 2.0"));
        songsArrayList.add(new Song("Demo Team", "Dance Gavin Dance", "Acceptance Speech 2.0"));
        songsArrayList.add(new Song("Death of the Robot with Human Hair", "Dance Gavin Dance", "Acceptance Speech 2.0"));
        songsArrayList.add(new Song("The Jiggler", "Dance Gavin Dance", "Acceptance Speech 2.0"));
        songsArrayList.add(new Song("Turn Off the Lights - I'm Watching Back to the Future, Pt. 2", "Dance Gavin Dance", "Acceptance Speech 2.0"));
        songsArrayList.add(new Song("We Own The Night", "Dance Gavin Dance", "Instant Gratification"));
        songsArrayList.add(new Song("Stroke God, Millionaire", "Dance Gavin Dance", "Instant Gratification"));
        songsArrayList.add(new Song("Something New", "Dance Gavin Dance", "Instant Gratification"));
        songsArrayList.add(new Song("On The Run", "Dance Gavin Dance", "Instant Gratification"));
        songsArrayList.add(new Song("Shark Dad", "Dance Gavin Dance", "Instant Gratification"));
        songsArrayList.add(new Song("Awkward", "Dance Gavin Dance", "Instant Gratification"));
        songsArrayList.add(new Song("The Cuddler", "Dance Gavin Dance", "Instant Gratification"));
        songsArrayList.add(new Song("Legend", "Dance Gavin Dance", "Instant Gratification"));
        songsArrayList.add(new Song("Eagle vs. Crows", "Dance Gavin Dance", "Instant Gratification"));
        songsArrayList.add(new Song("Death of a Strawberry", "Dance Gavin Dance", "Instant Gratification"));
        songsArrayList.add(new Song("Variation", "Dance Gavin Dance", "Instant Gratification"));
        songsArrayList.add(new Song("Lost", "Dance Gavin Dance", "Instant Gratification"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSongs();

        ArraySet<String> albums = new ArraySet<String>();
        for (Song song : songsArrayList) {
            albums.add(song.getAlbumName());
        }

        List<String> albumList = new ArrayList<>();
        albumList.addAll(albums);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.artist_song_list, albumList);
        ListView listView = (ListView) findViewById(R.id.song_list_layout);
        listView.setAdapter(adapter);

        //Set an OnItemClickListener on the list of albums
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<Song> artistAlbums = new ArrayList<Song>();
                String artistName = albumList.get(position);
                for (Song song : songsArrayList) {
                    if (song.getAlbumName().equals(artistName)) {
                        artistAlbums.add(song);
                    }
                }

                //use explicit Intent to open the SongActivity and store the data of the songsArrayList to this Intent object.
                Intent openSongActivity = new Intent(MainActivity.this, SongActivity.class);
                //put the data on the Intent as (key, value) pair
                openSongActivity.putExtra("key_song_list", artistAlbums);
                //start the Intent to open the SongActivity activity
                startActivity(openSongActivity);
            }
        });
    }
}