package ucs_maubin.lm17_team12.lbums.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ucs_maubin.lm17_team12.lbums.Activity.AlbumActivity;
import ucs_maubin.lm17_team12.lbums.Adapter.HomeArtistAdapter;
import ucs_maubin.lm17_team12.lbums.Adapter.HomeGenreAdapter;
import ucs_maubin.lm17_team12.lbums.Adapter.HomeTop10TrackAdapter;
import ucs_maubin.lm17_team12.lbums.Model.Artist;
import ucs_maubin.lm17_team12.lbums.Model.Genre;
import ucs_maubin.lm17_team12.lbums.Model.Tracks;
import ucs_maubin.lm17_team12.lbums.R;

/**
 * Created by hha on 10/16/17.
 */

public class HomeFragment extends Fragment {

    private List<Tracks> top10TracksList = new ArrayList<>();
    private List<Genre> genreList = new ArrayList<>();
    private List<Artist>  artistList = new ArrayList<>();
    private RecyclerView top10Tracks_recyclerView,genre_recyclerView, artist_recyclerView;
    private HomeTop10TrackAdapter top10TrackAdapter;
    private HomeGenreAdapter genreAdapter;
    private HomeArtistAdapter artistAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        TextView more_album = (TextView)view.findViewById(R.id.moreAlbum_title);
        more_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AlbumActivity.class));
            }
        });



        top10Tracks_recyclerView = (RecyclerView) view.findViewById(R.id.top10_tracks_recycler_view);
        top10TrackAdapter = new HomeTop10TrackAdapter(getContext(), top10TracksList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        top10Tracks_recyclerView.setLayoutManager(mLayoutManager);
        top10Tracks_recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
       // recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        top10Tracks_recyclerView.setItemAnimator(new DefaultItemAnimator());
        top10Tracks_recyclerView.setAdapter(top10TrackAdapter);


        genre_recyclerView = (RecyclerView) view.findViewById(R.id.genre_tracks_recycler_view);
        genreAdapter = new HomeGenreAdapter(getContext(), genreList);
       mLayoutManager = new LinearLayoutManager(getContext());
        genre_recyclerView.setLayoutManager(mLayoutManager);
        genre_recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        // recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        genre_recyclerView.setItemAnimator(new DefaultItemAnimator());
        genre_recyclerView.setAdapter(genreAdapter);


        artist_recyclerView = (RecyclerView) view.findViewById(R.id.artist_recycler_view);
        artistAdapter = new HomeArtistAdapter(getContext(), artistList);
        mLayoutManager = new LinearLayoutManager(getContext());
        artist_recyclerView.setLayoutManager(mLayoutManager);
        artist_recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        // recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        artist_recyclerView.setItemAnimator(new DefaultItemAnimator());
        artist_recyclerView.setAdapter(artistAdapter);

        prepareTop10TracksData();
        prepareGenreData();
        prepareArtistData();

        return view;
    }

    private void prepareTop10TracksData() {

        int[] covers = new int[]{
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};


        Tracks tracks = new Tracks("Name1", "Artist1", covers[0]);
        top10TracksList.add(tracks);

        tracks = new Tracks("Name2", "Artist2", covers[1]);
        top10TracksList.add(tracks);
        tracks = new Tracks("Name3", "Artist3", covers[2]);
        top10TracksList.add(tracks);
        tracks = new Tracks("Name4", "Artist4", covers[3]);
        top10TracksList.add(tracks);
        tracks = new Tracks("Name5", "Artist5", covers[4]);
        top10TracksList.add(tracks);
        tracks = new Tracks("Name6", "Artist6", covers[5]);
        top10TracksList.add(tracks);
        tracks = new Tracks("Name7", "Artist7", covers[6]);
        top10TracksList.add(tracks);
        tracks = new Tracks("Name8", "Artist8", covers[7]);
        top10TracksList.add(tracks);
        tracks = new Tracks("Name9", "Artist9", covers[8]);
        top10TracksList.add(tracks);
        tracks = new Tracks("Name10", "Artist10", covers[9]);
        top10TracksList.add(tracks);

        top10TrackAdapter.notifyDataSetChanged();
    }

    private void prepareGenreData() {

        int[] covers = new int[]{
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};


        Genre genre = new Genre(1, "dfd","ddd");
        genreList.add(genre);
/*

        genre = new Genre("Rock", covers[1]);
        genreList.add(genre);

        genre = new Genre("R&B", covers[2]);
        genreList.add(genre);

        genre = new Genre("Jazz", covers[3]);
        genreList.add(genre);

        genre = new Genre("Blue", covers[4]);
        genreList.add(genre);

        genre = new Genre("HipHop", covers[5]);
        genreList.add(genre);

        genre = new Genre("Country", covers[6]);
        genreList.add(genre);

        genre = new Genre("Punk", covers[7]);
        genreList.add(genre);

        genre = new Genre("Classic", covers[8]);
        genreList.add(genre);

        genre = new Genre("Metal", covers[9]);
        genreList.add(genre);
*/

        genreAdapter.notifyDataSetChanged();
    }


    private void prepareArtistData() {

        int[] covers = new int[]{
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};


        Artist artist = new Artist("Mg Mg", covers[0]);
        artistList.add(artist);

        artist = new Artist("Ma Ma", covers[1]);
        artistList.add(artist);

        artist = new Artist("Hla Hla", covers[2]);
        artistList.add(artist);

        artist = new Artist("Kyaw Kyaw", covers[3]);
        artistList.add(artist);

        artist = new Artist("Ko Ko", covers[4]);
        artistList.add(artist);

        artist = new Artist("Myo Myo", covers[5]);
        artistList.add(artist);

        artist = new Artist("Nyi Nyi", covers[6]);
        artistList.add(artist);

        artist = new Artist("Nyo Mya", covers[7]);
        artistList.add(artist);

        artist = new Artist("Phone Myint", covers[8]);
        artistList.add(artist);

        artist = new Artist("Ko Kaung", covers[9]);
        artistList.add(artist);

        artist = new Artist("Min Min", covers[1]);
        artistList.add(artist);

        artistAdapter.notifyDataSetChanged();
    }
}
