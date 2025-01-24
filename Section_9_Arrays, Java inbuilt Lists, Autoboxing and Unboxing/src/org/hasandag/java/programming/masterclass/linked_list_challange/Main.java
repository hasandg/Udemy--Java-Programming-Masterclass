package org.hasandag.java.programming.masterclass.linked_list_challange;

import java.util.*;

/**
 * Created by : hdag
 * Date: 11.09.2019
 * Time: 08:10
 */
public class Main {
    public static void main(String[] args) {

        // Create a program that implements a playlist for songs
        // Create a Song class having Title and Duration for a song.
        // The program will have an Album class containing a list of songs.
        // The albums will be stored in an ArrayList
        // Songs from different albums can be added to the playlist and will appear in the list in the order
        // they are added.
        // Once the songs have been added to the playlist, create a menu of options to:-
        // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
        // List the songs in the playlist
        // A song must exist in an album before it can be added to the playlist (so you can only play songs that
        // you own).
        // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
        // started tracking the direction we were going.
        // As an optional extra, provide an option to remove the current song from the playlist
        // (hint: listiterator.remove()


        ArrayList<Album> albums = new ArrayList<>();

        LinkedList<Song> playlist = new LinkedList<>();

        Album album1 = new Album();
        album1.getSongs().add(new Song("Lets","4:13"));
        album1.getSongs().add(new Song("olaa","3:25"));
        albums.add(album1) ;
        playlist.add(album1.getSongs().get(0));
        playlist.add(album1.getSongs().get(1));


        play(playlist);

    }

    private static void playSong(Song song) {
        System.out.println("Now playing " + song.getTitle() + " duration: " + song.getDuration());
    }

    private static void listSongs(LinkedList<Song> playlist) {

        Iterator<Song> i = playlist.iterator();
        while (i.hasNext()) {
            Song song = i.next();
            System.out.println("Song: " + song.getTitle() + " duration: " + song.getDuration());
        }
        System.out.println("=========================");
    }


    private static void play(LinkedList playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        Song currentSong;

        if (playList.isEmpty()) {
            System.out.println("No song in the playlist");
            return;
        } else {
            currentSong = listIterator.next();
            playSong(currentSong);
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Stopped");
                    quit = true;
                    break;

                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        currentSong = listIterator.next();
                        playSong(currentSong);
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        currentSong = listIterator.previous();
                        playSong(currentSong);
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    playSong(currentSong);
                    break;
                case 4:
                    listSongs(playList);
                    break;
                case 5:
                    playList.remove(currentSong);
                    printMenu();
                    break;
                case 6:
                    printMenu();
                    break;

            }

        }
    }


    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to play current song\n" +
                "4 - to print playlist\n" +
                "5 - to delete current song from playlist\n" +
                "6 - to print menu options");
    }

}
