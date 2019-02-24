package apps.com.weatherapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "CurrentWeather")
public class CurrentWeather {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "city")
    private String stringCity;

    @ColumnInfo(name = "day")
    private int stringDay;

    @ColumnInfo(name = "temperature")
    private int stringTemp;

    @ColumnInfo(name = "description")
    private String stringDescription;

    @ColumnInfo(name = "tempmax")
    private int stringTempMax;

    @ColumnInfo(name = "tempmin")
    private int stringTempMin;

    @ColumnInfo(name = "humidity")
    private String stringHumidity;

    @ColumnInfo(name = "wind")
    private String stringWind;

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public void setStringWind(String stringWind) {
        this.stringWind = stringWind;
    }

    public String getStringWind() {
        return stringWind;
    }

    public void setStringTempMin(int stringTempMin) {
        this.stringTempMin = stringTempMin;
    }

    public int getStringTempMin() {
        return stringTempMin;
    }

    public void setStringTempMax(int stringTempMax) {
        this.stringTempMax = stringTempMax;
    }

    public int getStringTempMax() {
        return stringTempMax;
    }

    public void setStringTemp(int stringTemp) {
        this.stringTemp = stringTemp;
    }

    public int getStringTemp() {
        return stringTemp;
    }

    public void setStringHumidity(String stringHumidity) {
        this.stringHumidity = stringHumidity;
    }

    public String getStringHumidity() {
        return stringHumidity;
    }

    public void setStringDescription(String stringDescription) {
        this.stringDescription = stringDescription;
    }

    public String getStringDescription() {
        return stringDescription;
    }

    public void setStringDay(int stringDay) {
        this.stringDay = stringDay;
    }

    public int getStringDay() {
        return stringDay;
    }

    public void setStringCity(String stringCity) {
        this.stringCity = stringCity;
    }

    public String getStringCity() {
        return stringCity;
    }
}
