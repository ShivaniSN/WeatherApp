package apps.com.weatherapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {CurrentWeather.class}, version = 1)
abstract class WeatherDatabase extends RoomDatabase {
    public abstract WeatherDAO taskDao();
}
