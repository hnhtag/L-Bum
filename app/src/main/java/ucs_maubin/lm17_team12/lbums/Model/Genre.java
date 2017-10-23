package ucs_maubin.lm17_team12.lbums.Model;

/**
 * Created by hha on 10/16/17.
 */

public class Genre {
    Integer genre_id;
    String cover;
    String genre_name;

    public Genre(Integer genre_id, String cover, String genre_name) {
        this.genre_id = genre_id;
        this.cover = cover;
        this.genre_name = genre_name;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }
}
