package kz.kbtu.android;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieItemViewHolder> {

    private ArrayList<Result> movies = new ArrayList<>();
    private OnMovieClickListener listener;

    public MovieAdapter() {

    }

    public MovieAdapter(OnMovieClickListener listener) {
        this.listener = listener;
    }

    public void setMovies(ArrayList<Result> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MovieItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieItemViewHolder movieItemViewHolder, int i) {
        movieItemViewHolder.bindView(movies.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}



class MovieItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView nameText;
    private TextView dateText;
    private TextView desc;
    private ImageView imageMovie;
    private Context context;
    private OnMovieClickListener listener;
    private Result movie;


    MovieItemViewHolder(View view) {
        super(view);
        context = view.getContext();
        imageMovie = view.findViewById(R.id.poster);
        nameText = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);
        dateText = view.findViewById(R.id.date);

    }

    void bindView(Result movie, OnMovieClickListener listener) {
        this.movie = movie;
        nameText.setText(movie.getTitle());
        this.listener = listener;
        Glide.with(context).load("https://image.tmdb.org/t/p/w200" + movie.getPoster_path()).into(imageMovie);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == itemView.getId()) {
            listener.onClick(movie);
        }
    }
}
