package IteratorDesignPattern;

public class Song {
    private final String title;
    private final String artist;

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Song(String t, String a) {
        title = t;
        artist = a;
    }
}
