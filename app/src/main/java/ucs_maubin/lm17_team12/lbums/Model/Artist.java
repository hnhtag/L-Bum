package ucs_maubin.lm17_team12.lbums.Model;

/**
 * Created by hha on 10/16/17.
 */

public class Artist {
    String name;
    int cover;

    public Artist(String name, int cover) {
        this.name = name;
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }
}
