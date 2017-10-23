package ucs_maubin.lm17_team12.lbums.Adapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import ucs_maubin.lm17_team12.lbums.Activity.PlayerActivity;
import ucs_maubin.lm17_team12.lbums.Model.Artist;
import ucs_maubin.lm17_team12.lbums.Model.Genre;
import ucs_maubin.lm17_team12.lbums.R;

/**
 * Created by hha on 10/16/17.
 */

public class HomeArtistAdapter extends RecyclerView.Adapter<HomeArtistAdapter.MyViewHolder> {
    private Context mContext;
    private List<Artist> artistList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;
        private Artist artist;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.home_artist_thumbnail);

            view.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, artist.getName() + " is selected!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(mContext, PlayerActivity.class);
                    i.putExtra("Top10Tracks_cover", artist.getCover());
                    i.putExtra("Top10Tracks_name", artist.getName());

                    View sharedView = thumbnail;
                    String transitionName = mContext.getString(R.string.top10_coverTransition);

                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext, sharedView, transitionName);
                    mContext.startActivity(i, transitionActivityOptions.toBundle());
                }
            });
        }

        public void bindView(Artist artist){

            this.artist = artist;

            title.setText(artist.getName());

            // loading album cover using Glide library
            Glide.with(mContext).load(artist.getCover()).into(thumbnail);
            Glide.with(mContext)
                    .load(artist.getCover())
                    .error(R.drawable.ic_search)
                    .into(thumbnail);

        }
    }

    public HomeArtistAdapter(Context mContext, List<Artist> artistList) {
        this.mContext = mContext;
        this.artistList = artistList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_artist_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Artist artist = artistList.get(position);
        holder.bindView(artist);
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }
}
