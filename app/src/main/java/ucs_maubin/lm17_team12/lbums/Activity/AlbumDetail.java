package ucs_maubin.lm17_team12.lbums.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ucs_maubin.lm17_team12.lbums.Adapter.AlbumTrackAdapter;
import ucs_maubin.lm17_team12.lbums.Adapter.TrackAdapter;
import ucs_maubin.lm17_team12.lbums.Model.Tracks;
import ucs_maubin.lm17_team12.lbums.R;

public class AlbumDetail extends AppCompatActivity {

    Integer cover = 0,songs=0;
    String name;
    FloatingActionButton fab ;


    private List<Tracks> tracksList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AlbumTrackAdapter albumTrackAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initCollapsingToolbar();

        fab= (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(AlbumDetail.this,PlayerActivity.class);
                startActivity(i);
            }
        });
        ImageView backdrop =(ImageView)findViewById(R.id.backdrop);
        TextView album_title= (TextView) findViewById(R.id.album_title);
        TextView album_songs= (TextView) findViewById(R.id.album_artist);

        Intent i =getIntent();
        Bundle myIntentBundle =i.getExtras();

        if (myIntentBundle!=null){

            cover = myIntentBundle.getInt("album_cover");
            name = myIntentBundle.getString("album_name");
            songs = myIntentBundle.getInt("album_noofsongs");
            Glide.with(AlbumDetail.this).load(cover).into(backdrop);

           /* Bitmap resultBmp = BlurBuilder.blur(AlbumDetail.this, BitmapFactory.decodeResource(getResources(),cover));
            backdrop.setImageBitmap(resultBmp);*/

            album_title.setText(name);
            album_songs.setText(String.valueOf(songs));
        } else {
            Glide.with(AlbumDetail.this).load(R.drawable.player_cover).into(backdrop);
        }


        recyclerView = (RecyclerView) findViewById(R.id.album_detail_recycler_view);
        albumTrackAdapter = new AlbumTrackAdapter(getApplicationContext(), tracksList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(albumTrackAdapter);


        prepareMovieData();
    }


    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(name);
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
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

        albumTrackAdapter.notifyDataSetChanged();
    }
}
