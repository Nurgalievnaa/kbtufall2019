package kz.kbtu.android;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MovieDetailActivity extends AppCompatActivity {

    ActionBar actionBar;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView toolbarImageView;
    TextView genreText;
    TextView releaseText;
    TextView descText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        toolbar = findViewById(R.id.main_toolbar);
        genreText = findViewById(R.id.genre);
        releaseText = findViewById(R.id.dateMovie);
        descText = findViewById(R.id.overview);
        collapsingToolbarLayout = findViewById(R.id.main_collapsing_movie);
        toolbarImageView = findViewById(R.id.main_backdrop);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Result movie = (Result) getIntent().getExtras().getSerializable("movie");
        collapsingToolbarLayout.setTitle(movie.getTitle());
        descText.setText(movie.getOverview());
        collapsingToolbarLayout.setContentScrim(ContextCompat.getDrawable(this, R.drawable.bg_toolbar));
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w200" + movie.getPoster_path())
                .into(toolbarImageView);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }
}