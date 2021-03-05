package com.example.android.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Song> songList = getIntent().getParcelableArrayListExtra("key_song_list");

        SongAdapter adapter = new SongAdapter(this, songList);

        ListView listView = findViewById(R.id.song_list_layout);

        listView.setAdapter(adapter);

        //Set an OnItemClickListener on the list of songs
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Song currentPlayingSong = songList.get(position);

                String songName = currentPlayingSong.getSongName();
                String artistName = currentPlayingSong.getArtistName();
                String albumName = currentPlayingSong.getAlbumName();

                //use explicit Intent to open the NowPlayingActivity and store the data of the songsArrayList to this Intent object.
                Intent openSongPlayer = new Intent(SongActivity.this, NowPlayingActivity.class);
                //put the data on the Intent as (key, value) pair
                openSongPlayer.putExtra("key_song_name", songName);
                openSongPlayer.putExtra("key_artist_name", artistName);
                openSongPlayer.putExtra("key_album_name", albumName);
                //start the Intent to open the NowPlayingActivity
                startActivity(openSongPlayer);
            }
        });

    }
}