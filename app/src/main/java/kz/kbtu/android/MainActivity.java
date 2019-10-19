package kz.kbtu.android;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements OnMovieClickListener {

    RecyclerView movieListRC;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieListRC = findViewById(R.id.movieListView);
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie(
                "Avengers",
                "https://upload.wikimedia.org/wikipedia/en/0/0d/Avengers_Endgame_poster.jpg",
                new Date(),
                "Action, Fantastic, American story",
                "Avengers: Endgame is a 2019 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to 2012's The Avengers, 2015's Avengers: Age of Ultron, and 2018's Avengers: Infinity War, and the twenty-second film in the Marvel Cinematic Universe (MCU)."
                );
        Movie movie2 = new Movie(
                "Wonder woman",
                "https://upload.wikimedia.org/wikipedia/en/e/ed/Wonder_Woman_%282017_film%29.jpg",
                new Date(),
                "Action, Fantastic, DC world",
                "Avengers: Endgame is a 2019 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to 2012's The Avengers, 2015's Avengers: Age of Ultron, and 2018's Avengers: Infinity War, and the twenty-second film in the Marvel Cinematic Universe (MCU)."
        );
        for (int i = 0; i<100; i++) {
            if (i % 2 == 0) {
                movies.add(movie1);
            }
            else {
                movies.add(movie2);
            }
        }
        adapter = new MovieAdapter(movies, this);
        movieListRC.setAdapter(adapter);
        movieListRC.setLayoutManager(new GridLayoutManager(this,2,RecyclerView.VERTICAL,  false));

    }

    @Override
    public void onClick(Movie movie) {
        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("movie", movie);
        startActivity(intent);
    }
}

interface OnMovieClickListener {
    void onClick(Movie movie);
}
