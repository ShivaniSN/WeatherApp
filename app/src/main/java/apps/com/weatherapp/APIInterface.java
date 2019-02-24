package apps.com.weatherapp;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface APIInterface {
    String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    String API_KEY = "150caaaac296113d567c1cf4648d54b1";
    String NAME = "q";

    @GET("weather")
    Call<Result> postWeatherNews(
            @Query(NAME) String query,
            @Query(API_KEY) String publicKey
    );

}
