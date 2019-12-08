package kz.kbtu.android;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static kz.kbtu.android.App.movieApi;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;

    @Override
    public void onViewInit() {
        movieApi.getMovieList(App.API_KEY, 20)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MovieResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieResponse movieResponse) {
                        view.setMovieList(movieResponse.getResults());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }
}
