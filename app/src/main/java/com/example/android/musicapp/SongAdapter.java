package com.example.android.musicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {

    private static final String LOG_TAG = SongAdapter.class.getSimpleName();

    public SongAdapter(Activity context, List<Song> Songs) {
        super(context, 0, Songs);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        Song variable = getItem(position);

        // this one gets the song name
        TextView songName = (TextView) listItemView.findViewById(R.id.song_name_info);
        songName.setText(variable.getSongName());

        // this one gets the artist name
        TextView artistInfo = (TextView) listItemView.findViewById(R.id.artist_info);
        artistInfo.setText(variable.getArtistName());

        // this one gets the the album name
        TextView albumInfo = (TextView) listItemView.findViewById(R.id.album_info);
        albumInfo.setText(variable.getAlbumName());

        return listItemView;
    }
}
