package com.example.android.musicapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {

    /**
     * Song name
     */
    private String mSongName;

    /**
     * Artist name
     */
    private String mArtistName;

    /**
     * Album name
     */
    private String mAlbumName;

    public Song(String songName, String artistName, String albumName) {
        mSongName = songName;
        mArtistName = artistName;
        mAlbumName = albumName;
    }

    /**
     * Get the song name
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the artist name
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the album name
     */
    public String getAlbumName() {
        return mAlbumName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mSongName);
        dest.writeString(this.mArtistName);
        dest.writeString(this.mAlbumName);
    }

    public void readFromParcel(Parcel source) {
        this.mSongName = source.readString();
        this.mArtistName = source.readString();
        this.mAlbumName = source.readString();
    }

    protected Song(Parcel in) {
        this.mSongName = in.readString();
        this.mArtistName = in.readString();
        this.mAlbumName = in.readString();
    }

    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel source) {
            return new Song(source);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}