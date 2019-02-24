package apps.com.weatherapp;

import android.arch.persistence.room.Insert;

public interface WeatherDAO {
    @Insert
    void insertAll(CurrentWeather  weather);
}
