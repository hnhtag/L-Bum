package ucs_maubin.lm17_team12.lbums.Activity;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.clans.fab.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ucs_maubin.lm17_team12.lbums.Fragment.HomeFragment;
import ucs_maubin.lm17_team12.lbums.Fragment.SearchFragment;
import ucs_maubin.lm17_team12.lbums.Fragment.TracksFragment;
import ucs_maubin.lm17_team12.lbums.R;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton mFab;


    //JSON url
    String JsonURL = "https://hein-htet-aung.github.io/l-bum/JSON/music.json";
    // This string will hold the results
    String album_data, genre_data, artist_data, track_data = "";
    // Defining the Volley request queue that handles the URL request concurrently
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        mFab = (FloatingActionButton) findViewById(R.id.fab);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        mFab.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PlayerActivity.class);
                View sharedView = mFab;
                String transitionName = "PlayPause";

                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, sharedView, transitionName);
                startActivity(i, transitionActivityOptions.toBundle());
            }
        });

        mFab.hide(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mFab.show(true);/*
                mFab.setShowAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.show_from_bottom));
                mFab.setHideAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.hide_to_bottom));*/
            }
        }, 444);

        ///


        requestQueue = Volley.newRequestQueue(this);

        // Creating the JsonObjectRequest class called obreq, passing required parameters:
        //GET is used to fetch data from the server, JsonURL is the URL to be fetched from.
        JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.GET, JsonURL,
                // The third parameter Listener overrides the method onResponse() and passes
                //JSONObject as a parameter
                new Response.Listener<JSONObject>() {

                    // Takes the response from the JSON request
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            //get album data
                            JSONArray arrJSON_Album = response.getJSONArray("album");

                            for (int i=0; i< arrJSON_Album.length();i++){
                                JSONObject obj = arrJSON_Album.getJSONObject(i);

                                Integer album_id = obj.getInt("album_id");
                                String album_name = obj.getString("album_name");
                                String album_cover = obj.getString("album_cover");
                                Integer album_track = obj.getInt("album_track");

                                // Adds strings from object to the "data" string
                                album_data += "Album Id : "+album_id + "\nAlbum Name: " +album_name+"\nAlbum cover :"+album_cover+"\nTrack NO: "+album_track+"\n\n";

                                // Adds the data string to the TextView "results"
//                            results.setText(data);
//                                Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();

                            }
//                            Log.i("album ", album_data);

                            //get genre data
                            JSONArray arrJSON_Genre = response.getJSONArray("genre");

                            for (int i=0; i< arrJSON_Genre.length();i++){
                                JSONObject obj = arrJSON_Genre.getJSONObject(i);

                                Integer genre_id = obj.getInt("genre_id");
                                String genre_name = obj.getString("genre_name");
                                String genre_cover = obj.getString("genre_cover");

                                // Adds strings from object to the "data" string
                                genre_data += "Genre Id : "+genre_id + "\nGenre Name: " +genre_name+"\nGenre cover :"+genre_cover+"\n\n";

                                // Adds the data string to the TextView "results"
//                            results.setText(data);
//                                Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();

                            }
                            Log.i("Genre", genre_data);


                            //get artist data
                            JSONArray arrJSON_Artist = response.getJSONArray("artist");

                            for (int j=0; j< arrJSON_Artist.length();j++){
                                JSONObject obj = arrJSON_Artist.getJSONObject(j);

                                Integer artist_id = obj.getInt("artist_id");
                                String artist_name = obj.getString("artist_name");
                                String artist_cover = obj.getString("artist_cover");

                                // Adds strings from object to the "data" string
                                artist_data += "artist Id : "+artist_id + "\nartist Name: " +artist_name+"\nartist cover :"+artist_cover+"\n\n";

                                // Adds the data string to the TextView "results"
//                            results.setText(data);
//                                Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();

                            }
                            Log.i("artist", artist_data);

                            //get tracks data
                            JSONArray arrJSON_Track = response.getJSONArray("track");

                            for (int i=0; i< arrJSON_Track.length();i++){
                                JSONObject obj = arrJSON_Track.getJSONObject(i);

                                Integer track_id = obj.getInt("track_id");
                                String track_name = obj.getString("track_name");
                                String track_cover = obj.getString("track_cover");
                                String track_link = obj.getString("track_link");
                                String track_genre = obj.getString("track_genre");
                                String track_artist = obj.getString("track_artist");
                                String track_album = obj.getString("track_album");


                                // Adds strings from object to the "data" string
                                track_data += "track Id : "+track_id + "\ntrack Name: " +track_name+"\ntrack cover :"+track_link+"\n\n";

                                // Adds the data string to the TextView "results"
//                            results.setText(data);
//                                Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();

                            }
                            Log.i("tracks", track_data);

                        }
                        // Try and catch are included to handle any errors due to JSON
                        catch (JSONException e) {
                            // If an error occurs, this prints the error to the log
                            e.printStackTrace();
                        }
                    }
                },
                // The final parameter overrides the method onErrorResponse() and passes VolleyError
                //as a parameter
                new Response.ErrorListener() {
                    @Override
                    // Handles errors that occur due to Volley
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                        Toast.makeText(MainActivity.this, "Error Occurred while retrieving data from source...", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        // Adds the JSON object request "obreq" to the request queue
        requestQueue.add(obreq);
    }


    private void setupTabIcons() {
        int[] tabIcons = {
                R.drawable.tab_home_icon,
                R.drawable.tab_audiotrack_icon,
                R.drawable.tab_favorite_icon,
                R.drawable.tab_search_icon
        };

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), "Home");
        adapter.addFrag(new TracksFragment(), "Tracks");
        adapter.addFrag(new HomeFragment(), "Favourite");
        adapter.addFrag(new SearchFragment(), "Search");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            // return null to display only the icon
            return null;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }


}
