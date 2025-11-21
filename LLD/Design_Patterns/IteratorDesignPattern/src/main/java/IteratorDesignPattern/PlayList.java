package IteratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class PlayList implements Iterable<Song>{

    private final List<Song> songs = new ArrayList<>();

    public void addSong(Song s) {
        songs.add(s);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public Iterator<Song> getIterator() {
        return new PlaylistIterator(songs);
    }
}
