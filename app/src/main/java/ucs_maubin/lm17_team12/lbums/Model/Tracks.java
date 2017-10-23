package ucs_maubin.lm17_team12.lbums.Model;

/**
 * Created by hha on 10/16/17.
 */

public class Tracks {
    private String track_name, artist_name;
    int track_cover;

    public Tracks(String track_name, String artist_name, int track_cover) {
        this.track_name = track_name;
        this.artist_name = artist_name;
        this.track_cover = track_cover;
    }

    public String getTrack_name() {
        return track_name;
    }

    public void setTrack_name(String track_name) {
        this.track_name = track_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public int getTrack_cover() {
        return track_cover;
    }

    public void setTrack_cover(int track_cover) {
        this.track_cover = track_cover;
    }
}
