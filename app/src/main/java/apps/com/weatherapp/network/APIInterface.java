package apps.com.weatherapp.network;

import apps.com.weatherapp.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    String API_KEY = "APPID";
    String NAME = "q";

    @GET("weather")
    Call<Result> postWeatherNews(
            @Query(NAME) String query,
            @Query(API_KEY) String publicKey
    );

}
