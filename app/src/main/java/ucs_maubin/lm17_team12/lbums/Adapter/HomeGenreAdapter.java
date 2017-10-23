package ucs_maubin.lm17_team12.lbums.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import ucs_maubin.lm17_team12.lbums.Model.Genre;
import ucs_maubin.lm17_team12.lbums.Model.Tracks;
import ucs_maubin.lm17_team12.lbums.R;

/**
 * Created by hha on 10/16/17.
 */

public class HomeGenreAdapter extends RecyclerView.Adapter<HomeGenreAdapter.MyViewHolder> {
    private Context mContext;
    private List<Genre> genresList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;
        private Genre genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, genre.getGenre_name() + " is selected!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void bindView(Genre genre){

            this.genre = genre;

            title.setText(genre.getGenre_name());

            // loading album cover using Glide library
            Glide.with(mContext).load(genre.getCover()).into(thumbnail);
            Glide.with(mContext)
                    .load(genre.getCover())
                    .error(R.drawable.ic_search)
                    .into(thumbnail);

        }
    }

    public HomeGenreAdapter(Context mContext, List<Genre> genresList) {
        this.mContext = mContext;
        this.genresList = genresList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_genre_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Genre genre = genresList.get(position);
        holder.bindView(genre);
    }

    @Override
    public int getItemCount() {
        return genresList.size();
    }
}
