package apps.com.weatherapp.presenter;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

import apps.com.weatherapp.network.APIInterface;
import apps.com.weatherapp.List_Weather;
import apps.com.weatherapp.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityPresenter {

    private List_Weather weather;
    private View view;

    String stringAPIKey = "150caaaac296113d567c1cf4648d54b1";
    String stringParam = "Pune";

    public MainActivityPresenter(View view) {
       // this.weather = new List_Weather();
        this.view = view;
    }

    public void updateCity(String city){
        //weather.setStringCity(city);
        view.updateCityTextView(city);

    }

    public void updateDay(String day){
       // weather.setStringDay(day);
        view.updateDayTextView(day);

    }

    public void updateTemperature(String temp){
        //weather.setStringTemp(temp);
        view.updateTemperatureTextView(temp);

    }

    public void updateDescription(String desc){
       // weather.setStringDescription(desc);
        view.updateDescriptionTextView(desc);

    }

    public void updateHumidity(String humidity){
        //weather.setStringHumidity(humidity);
        view.updateHumidityTextView(humidity);

    }

    public void updateWind(String wind){
        //weather.setStringWind(wind);
        view.updateWindTextView(wind);

    }

    public interface View{

        void updateCityTextView(String info);
        void updateDayTextView(String info);
        void updateTemperatureTextView(String info);
        void updateDescriptionTextView(String info);
        void updateHumidityTextView(String info);
        void updateWindTextView(String info);

        void showProgressBar();
        void hideProgressBar();

    }

    public void postWeatherUpdates(){

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMMM dd, yyyy");
        Date d = new Date();
        final String dayOfTheWeek = sdf.format(d);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface service = retrofit.create(APIInterface.class);
        Call<Result> call=   service.postWeatherNews(stringParam,stringAPIKey);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                response.body();

                String stringDescription = response.body().getWeather().get(0).getMain().toString();
                //System.out.println(response.body().getWeather().get(0).getMain().toString());

                Double temp = 0.0,tempMax = 0.0,tempMin = 0.0,windSpeed = 0.0;

                temp = response.body().getMain().getTemp() - 273.15;
                tempMax = response.body().getMain().getTempMax() - 273.15 ;
                tempMin = response.body().getMain().getTempMin() - 273.15 ;
                windSpeed = response.body().getWind().getSpeed() * 3.6;

//                List<List_Weather> listWeather = new ArrayList<List_Weather>();
//                List_Weather weatherList = null;
//                for (int i =0 ;i<1;i++){
//                    weatherList = new List_Weather();
//                    weatherList.setStringDescription(stringDescription + "  " +
//                    tempMin + " \\u00b0 /" + tempMax + " \\u00b0 ");
//                    weatherList.setStringTemp(temp.toString() + " \\u00b0 ");
//                    weatherList.setStringHumidity(response.body().getMain().toString() + "%");
//                    weatherList.setStringWind(windSpeed.toString() + " km/hr");
//                    weatherList.setStringCity(response.body().getName());
//                    weatherList.setStringDay(dayOfTheWeek);
//                    listWeather.add(weatherList);
//                }

                updateCity(response.body().getName());
                updateHumidity("Humidity : " + response.body().getMain().getHumidity().toString() + " %");
                updateWind("Wind Speed : " + windSpeed.intValue() + " km/hr");
                updateTemperature(temp.intValue() + "\u00b0C");
                updateDescription(stringDescription + "  " + tempMin.intValue() + "\u00b0 C / " + tempMax.intValue() + "\u00b0 C");
                updateDay(dayOfTheWeek);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                    updateWind("Could not load the json values");
            }
        });
    }
}
