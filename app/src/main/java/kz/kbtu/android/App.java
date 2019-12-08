package kz.kbtu.android;

import android.app.Application;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    public static MovieApi movieApi;
    public static String API_KEY = "54b16ea0e26d27a6f8f485e9b46295e4";


    @Override
    public void onCreate() {
        super.onCreate();
        movieApi = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MovieApi.class);
    }
}
