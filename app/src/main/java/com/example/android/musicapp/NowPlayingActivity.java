package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        String artistName = getIntent().getStringExtra("key_artist_name");
        String songName = getIntent().getStringExtra("key_song_name");
        String albumName = getIntent().getStringExtra("key_album_name");

        TextView songTitle = (TextView) findViewById(R.id.song_name_text_view);
        songTitle.setText(songName);

        TextView artistAlbumTitle = (TextView) findViewById(R.id.artist_and_album_text_view);
        artistAlbumTitle.setText(artistName + " - " + albumName);
    }
}