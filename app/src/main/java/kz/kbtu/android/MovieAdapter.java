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
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieItemViewHolder> {

    private ArrayList<Movie> movies = new ArrayList<>();
    private OnMovieClickListener listener;

    public MovieAdapter() {

    }

    public MovieAdapter(List<Movie> movies, OnMovieClickListener listener) {
        this.movies.addAll(movies);
        this.listener = listener;
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
    private Movie movie;


    MovieItemViewHolder(View view) {
        super(view);
        context = view.getContext();
        imageMovie = view.findViewById(R.id.poster);
        nameText = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);
        dateText = view.findViewById(R.id.date);

    }

    void bindView(Movie movie, OnMovieClickListener listener) {
        this.movie = movie;
        nameText.setText(movie.name);
        desc.setText(movie.genre);
        this.listener = listener;
        String date = movie.date.getDay() + "." + movie.date.getMonth() + "." + movie.date.getYear() +
                " " + movie.date.getHours() + ":" + movie.date.getMinutes();
        dateText.setText(date);
        Glide.with(context).load(movie.urlImage).into(imageMovie);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == itemView.getId()) {
            listener.onClick(movie);
        }
    }
}
