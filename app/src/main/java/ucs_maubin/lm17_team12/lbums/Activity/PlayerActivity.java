package ucs_maubin.lm17_team12.lbums.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ohoussein.playpause.PlayPauseView;

import ucs_maubin.lm17_team12.lbums.R;


public class PlayerActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ImageView iv=(ImageView)findViewById(R.id.blurredAlbumart);
        ImageView iv2=(ImageView)findViewById(R.id.track_cover);
        TextView title =(TextView) findViewById(R.id.song_title),
                artistView = (TextView)findViewById(R.id.song_artist);

        Integer cover = 0;
        String name, artist;

        Intent i =getIntent();
        Bundle myIntentBundle =i.getExtras();

        if (myIntentBundle!=null){

            cover = myIntentBundle.getInt("Tracks_cover");
            name = myIntentBundle.getString("Tracks_name");
            artist = myIntentBundle.getString("Tracks_artist");
            if (cover!=null){

                Bitmap resultBmp = BlurBuilder.blur(PlayerActivity.this, BitmapFactory.decodeResource(getResources(),cover));
                iv.setImageBitmap(resultBmp);

                Glide.with(PlayerActivity.this).load(cover).into(iv2);
            }else {
                Glide.with(PlayerActivity.this).load(R.drawable.player_cover).into(iv);
                Glide.with(PlayerActivity.this).load(R.drawable.player_cover).into(iv2);
            }

                title.setText(name);
                artistView.setText(artist);


        } else {
            Glide.with(PlayerActivity.this).load(R.drawable.player_cover).into(iv);
            Glide.with(PlayerActivity.this).load(R.drawable.player_cover).into(iv2);
        }
/*

        Glide.with(PlayerActivity.this).load(cover).into(iv);
*/

        final PlayPauseView view = (PlayPauseView) findViewById(R.id.play_pause_view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.toggle();
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
}

