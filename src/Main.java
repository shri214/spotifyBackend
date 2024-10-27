import Albums.Album;
import Controller.Controller;
import Songs.Song;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Hello world!");
        Album album=new Album("Arjit sing", "bollywod");
        album.addSongToAlbum("tum hi ho", " 2");
        album.addSongToAlbum("gerua", "unknown");

        album.printAlbumSong();

        Album album1 =new Album("pawan sing", "bhojpuri");
        album1.addSongToAlbum("chalkata hamro jawaniya","raja babu");
        album1.addSongToAlbum("sadiya khole k pad jayi", "new 2024");
        album1.addSongToAlbum("sanhiya lagawal bahut bat naikhe", "2005");


        album1.printAlbumSong();

        System.out.println("----------------------------------------");
        LinkedList<Song> list=new LinkedList<>();
        album.addSongToPlaylist("tum hi ho", list);
        album1.addSongToPlaylist(2, list);
        album1.addSongToPlaylist(3, list);

        for (Song s:list){
            System.out.println(s.getName()+" --"+s.getDuration());
        }

        System.out.println("----------------------------------------");

        

         Controller c=new Controller(list);
         c.printMessage();
        boolean exit=false;

        while (!exit){
            System.out.println("add your choice to control music system");
            int num=sc.nextInt();
           exit= c.controlMusic(num);
        }
    }

}