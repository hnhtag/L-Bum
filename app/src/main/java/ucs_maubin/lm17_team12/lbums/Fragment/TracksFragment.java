package ucs_maubin.lm17_team12.lbums.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ucs_maubin.lm17_team12.lbums.Activity.DividerItemDecoration;
import ucs_maubin.lm17_team12.lbums.Adapter.TrackAdapter;
import ucs_maubin.lm17_team12.lbums.Model.Tracks;
import ucs_maubin.lm17_team12.lbums.R;

/**
 * Created by hha on 10/16/17.
 */

public class TracksFragment extends Fragment {

    private List<Tracks> tracksList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TrackAdapter trackAdapter;

    public TracksFragment() {
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
        View view = inflater.inflate(R.layout.fragment_tracks, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.tracks_recycler_view);

        trackAdapter = new TrackAdapter(getContext(), tracksList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(trackAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        prepareMovieData();

        return view;
    }

    private void prepareMovieData() {

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


        Tracks tracks = new Tracks("Name", "Artist", covers[0]);
        tracksList.add(tracks);

        tracks = new Tracks("Name", "Artist", covers[1]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[2]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[3]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[4]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[5]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[6]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[1]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[2]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[3]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[4]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[5]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[6]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[7]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[8]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[9]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[4]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[5]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[6]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[7]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[8]);
        tracksList.add(tracks);
        tracks = new Tracks("Name", "Artist", covers[9]);
        tracksList.add(tracks);

        trackAdapter.notifyDataSetChanged();
    }
}
