package kz.kbtu.android;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("movie/popular")
     Observable<MovieResponse> getMovieList(@Query("api_key") String apikey,
                                                  @Query("page") int page);

}
