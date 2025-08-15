package groupfortyone.group41_starmaker.Raghib;

import java.io.Serializable;
import java.util.ArrayList;

public class Song implements Serializable{
    private String songtitle;
    private String description;
    private String genre;
    private int likes;

    public static  ArrayList<Song>songs=new ArrayList<>();
    public static  ArrayList<Song> favSongs = new ArrayList<>();
    public static  int countLikes;

    public Song(String songtitle, String description, String genre, int likes) {
        this.songtitle = songtitle;
        this.description = description;
        this.genre = genre;
        this.likes=likes;
    }

    public Song() {
    }

    public String getSongtitle() {
        return songtitle;
    }

    public void setSongtitle(String songtitle) {
        this.songtitle = songtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {this.likes=likes;}


    @Override
    public String toString() {
        return "Song{" +
                "songtitle='" + songtitle + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", likes='" + likes + '\'' +
                '}';
    }
}