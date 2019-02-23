package apps.com.weatherapp;

public class List_Weather {

    String stringCity,stringTemp,stringDescription,stringHumidity,stringWind,stringTempMax,stringTempMin,stringDay;

    public List_Weather(){

    }

    public List_Weather(String stringCity,String stringTemp,String stringDescription,String stringHumidity,String stringWind,
                        String stringTempMax,String stringTempMin,String stringDay){
        this.stringCity = stringCity;
        this.stringTemp = stringTemp;
        this.stringDescription = stringDescription;
        this.stringHumidity = stringHumidity;
        this.stringWind = stringWind;
        this.stringTempMax = stringTempMax;
        this.stringTempMin = stringTempMin;
        this.stringDay = stringDay;
    }

    public void setStringCity(String stringCity) {
        this.stringCity = stringCity;
    }

    public String getStringCity() {
        return stringCity;
    }

    public void setStringDay(String stringDay) {
        this.stringDay = stringDay;
    }

    public String getStringDay() {
        return stringDay;
    }

    public void setStringDescription(String stringDescription) {
        this.stringDescription = stringDescription;
    }

    public String getStringDescription() {
        return stringDescription;
    }

    public void setStringHumidity(String stringHumidity) {
        this.stringHumidity = stringHumidity;
    }

    public String getStringHumidity() {
        return stringHumidity;
    }

    public void setStringTemp(String stringTemp) {
        this.stringTemp = stringTemp;
    }

    public String getStringTemp() {
        return stringTemp;
    }

    public void setStringTempMax(String stringTempMax) {
        this.stringTempMax = stringTempMax;
    }

    public String getStringTempMax() {
        return stringTempMax;
    }

    public void setStringTempMin(String stringTempMin) {
        this.stringTempMin = stringTempMin;
    }

    public String getStringTempMin() {
        return stringTempMin;
    }

    public void setStringWind(String stringWind) {
        this.stringWind = stringWind;
    }

    public String getStringWind() {
        return stringWind;
    }
}
