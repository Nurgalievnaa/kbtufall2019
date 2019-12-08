package kz.kbtu.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment implements OnMovieClickListener, MainContract.View {

    private RecyclerView movieListRC;
    private MovieAdapter adapter;
    private MainContract.Presenter presenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new MainPresenter();
        presenter.attachView(this);
        movieListRC = view.findViewById(R.id.movieListView);
        initRecyclerView();
        presenter.onViewInit();
    }

    private void initRecyclerView() {
        adapter = new MovieAdapter(this);
        movieListRC.setAdapter(adapter);
        movieListRC.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,  false));

    }

    @Override
    public void onClick(Result movie) {
        Intent intent = new Intent(getContext(), MovieDetailActivity.class);
        intent.putExtra("movie", movie);
        startActivity(intent);
    }

    @Override
    public void setMovieList(List<Result> movies) {
        adapter.setMovies(new ArrayList(movies));
    }
}
