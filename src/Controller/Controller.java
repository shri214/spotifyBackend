package Controller;

import Songs.Song;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Controller {

    private List<Song> playList;
    private ListIterator<Song> iterator;
    private boolean isForward;

    public Controller(LinkedList<Song> playList) {
        this.playList = playList;
        this.iterator = playList.listIterator();
        if (playList.size() > 0) {
            System.out.println("Currently playing song:");
            playCurrentSong();
            isForward = true;
        }
    }

    public boolean controlMusic(int choice) {
        switch (choice) {
            case 1 -> playNextSong();
            case 2 -> playPreviousSong();
            case 3 -> repeatCurrentSong();
            case 4 -> printMessage();
            case 5 -> deleteCurrentSong();
            case 6 -> printAlbumSong();
            case 7 -> {
                System.out.println("Exiting music system...");
                return true;
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
        return false;
    }

    private void playNextSong() {
        if (!isForward && iterator.hasNext()) {
            iterator.next();
        }
        if (iterator.hasNext()) {
            System.out.println("Playing next song:");
            System.out.println(iterator.next());
            isForward = true;
        } else {
            System.out.println("You are at the end of the playlist.");
        }
    }

    private void playPreviousSong() {
        if (isForward && iterator.hasPrevious()) {
            iterator.previous();
        }
        if (iterator.hasPrevious()) {
            System.out.println("Playing previous song:");
            System.out.println(iterator.previous());
            isForward = false;
        } else {
            System.out.println("You are at the first song.");
        }
    }

    private void repeatCurrentSong() {
        if (isForward && iterator.hasPrevious()) {
            System.out.println("Repeating current song:");
            System.out.println(iterator.previous());
            isForward = false;
        } else if (!isForward && iterator.hasNext()) {
            System.out.println("Repeating current song:");
            System.out.println(iterator.next());
            isForward = true;
        }
    }

    private void deleteCurrentSong() {
        if (isForward && iterator.hasPrevious()) {
            iterator.previous();
        } else if (!iterator.hasNext()) {
            System.out.println("No song to delete.");
            return;
        }
        System.out.println("Deleting current song:");
        iterator.remove();
        isForward = iterator.hasNext();
        if (iterator.hasNext()) {
            System.out.println("Next song is:");
            System.out.println(iterator.next());
        } else if (iterator.hasPrevious()) {
            System.out.println("Previous song is:");
            System.out.println(iterator.previous());
        }
    }

    public void printMessage() {
        System.out.println("1 - Next song");
        System.out.println("2 - Previous song");
        System.out.println("3 - Repeat current song");
        System.out.println("4 - Show control options");
        System.out.println("5 - Delete current song");
        System.out.println("6 - Show song list");
        System.out.println("7 - Exit");
    }

    public void printAlbumSong() {
        System.out.println("Song List:");
        playList.forEach(song -> System.out.println(song.getName() + " - " + song.getDuration()));
    }

    private void playCurrentSong() {
        if (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
            isForward = false;
        } else {
            System.out.println(iterator.next());
            isForward = true;
        }
    }
}
