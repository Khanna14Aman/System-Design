package IteratorDesignPattern;

import java.util.List;

public class PlaylistIterator implements Iterator<Song>{
    private List<Song> vec;

    public PlaylistIterator(List<Song> v) {
        vec = v;
    }

    public boolean hasNext() {
        return vec.size()>1;
    }

    public Song current(){
        return vec.getFirst();
    }


    public void next() {
        vec.removeFirst();
    }
}
