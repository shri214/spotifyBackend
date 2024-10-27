package Albums;

import Songs.Song;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String artist;
    private String genre;
    List<Song> song;

    public Album(String artist, String genre) {
        this.artist = artist;
        this.genre = genre;
        this.song = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }
    private boolean findByTitle(String title) {
        for (Song s:song){
            if(s.getDuration().equals(title)) {
                return  true;
            }
        }
        return false;
    }

    private boolean findByName(String name){
        for (Song s:song){
            System.out.println(s.getName());
            if(s.getName().equals(name))
                return true;
        }
        return false;
    }

    public void addSongToAlbum(String name,String title){
        Song s=new Song(name, title);
        if(findByTitle(s.getDuration())){
            System.out.println("song is already in album");
        }else{
            song.add(s);
            System.out.println("song is added successfully  : "+s.getName());
        }
    }

    //pollymorphism

    public void addSongToPlaylist(String name, LinkedList<Song>playList){
        System.out.println(name);
        if(findByName(name)){
            for (Song s:song){
                if (s.getName().equals(name)){
                    playList.add(s);
                    break;
                }
            }
            System.out.println("song has been added in your playlist");
        }else {
            System.out.println("song not found : "+name);
        }
    }

    public void addSongToPlaylist(int trackNo, LinkedList<Song> playList){
        trackNo=trackNo-1;
        if(trackNo>=0 && trackNo<song.size()){
            playList.add(song.get(trackNo));
            System.out.println("song added successfully :)");
        }else {
            System.out.println("song number is out of bound");
        }
    }

    //managing song forward and previous


    public void printAlbumSong(){
        for (Song s:song){
            System.out.println(s.getName()+" - "+s.getDuration()+" - "+this.artist+" - "+this.genre);
        }
    }


}
