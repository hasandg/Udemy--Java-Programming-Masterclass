package org.hasandag.java.programming.masterclass.linked_list_challange;

/**
 * Created by : hdag
 * Date: 11.09.2019
 * Time: 09:08
 */
public class Song {

    private String title;
    private String duration;


    public Song(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
