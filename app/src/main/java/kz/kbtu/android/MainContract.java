package kz.kbtu.android;

import java.util.List;

public class MainContract {
    interface View {
        void setMovieList(List<Result> movies);
    }

    interface Presenter {
        void onViewInit();
        void attachView(View view);
    }
}
