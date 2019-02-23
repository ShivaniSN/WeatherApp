package apps.com.weatherapp;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface APIClient {
    String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    String API_KEY = "150caaaac296113d567c1cf4648d54b1";

    @GET("weather")
    Call<List<News>> getNews(
            @QueryMap Map<String, String> options
    );

}
