package groupfortyone.group41_starmaker.Samanta;

public class SongS {
    private String songtitle;
    private String genre;


    public SongS(String songtitle, String genre) {
        this.songtitle = songtitle;
        this.genre = genre;
    }


    public String getSongtitle() {
        return songtitle;
    }

    public void setSongtitle(String songtitle) {
        this.songtitle = songtitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}