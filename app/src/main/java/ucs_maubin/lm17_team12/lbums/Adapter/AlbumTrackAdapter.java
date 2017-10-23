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
import ucs_maubin.lm17_team12.lbums.Model.Tracks;
import ucs_maubin.lm17_team12.lbums.R;

/**
 * Created by hha on 10/16/17.
 */

public class AlbumTrackAdapter extends RecyclerView.Adapter<AlbumTrackAdapter.MyViewHolder> {
    private Context mContext;
    private List<Tracks> tracksList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, artist;
        public ImageView thumbnail;
        private Tracks tracks;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            artist = (TextView) view.findViewById(R.id.artist);
            thumbnail = (ImageView) view.findViewById(R.id.Trackthumbnail);

            view.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, tracks.getTrack_name() + " is selected!", Toast.LENGTH_SHORT).show();


                    Intent i = new Intent(mContext, PlayerActivity.class);
                    i.putExtra("Tracks_cover", tracks.getTrack_cover());
                    i.putExtra("Tracks_name", tracks.getTrack_name());
                    i.putExtra("Tracks_artist", tracks.getArtist_name());

//                    View sharedView = thumbnail;
//                    String transitionName ="trackCover";

//                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext, sharedView, transitionName);
                    mContext.startActivity(i);
                }
            });
        }

        public void bindView(Tracks tracks){

            this.tracks = tracks;

            title.setText(tracks.getTrack_name());
            artist.setText(tracks.getArtist_name());

            // loading album cover using Glide library
            Glide.with(mContext).load(tracks.getTrack_cover()).into(thumbnail);
            Glide.with(mContext)
                    .load(tracks.getTrack_cover())
                    .error(R.drawable.ic_search)
                    .into(thumbnail);

        }
    }

    public AlbumTrackAdapter(Context mContext, List<Tracks> tracksList) {
        this.mContext = mContext;
        this.tracksList = tracksList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track_fragment_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Tracks tracks = tracksList.get(position);
        holder.bindView(tracks);
    }

    @Override
    public int getItemCount() {
        return tracksList.size();
    }
}
