package org.hasandag.java.programming.masterclass.linked_list_challange;

import java.util.LinkedList;

/**
 * Created by : hdag
 * Date: 11.09.2019
 * Time: 09:11
 */
public class Album {

    private LinkedList<Song> songs = new LinkedList<>();

    public LinkedList<Song> getSongs() {
        return songs;
    }

    public void setSongs(LinkedList<Song> songs) {
        this.songs = songs;
    }
}
