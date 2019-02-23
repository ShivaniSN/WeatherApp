package apps.com.weatherapp;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class Activity_Main extends AppCompatActivity {

    ConstraintLayout constraintLayoutMain;
    TextView textViewCity,textViewDay,textViewTemperature,textViewDescription,textViewHumidity,textViewWind;
    ImageView imageViewWeather;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayoutMain = (ConstraintLayout)findViewById(R.id.cl_main);
        imageViewWeather = (ImageView)findViewById(R.id.iv_weather);
        textViewCity = (TextView)findViewById(R.id.tv_city);
        textViewDay = (TextView)findViewById(R.id.tv_day);
        textViewTemperature = (TextView)findViewById(R.id.tv_temp);
        textViewDescription = (TextView)findViewById(R.id.tv_desc);
        textViewHumidity = (TextView)findViewById(R.id.tv_humidity);
        textViewWind = (TextView)findViewById(R.id.tv_wind);

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        if(timeOfDay >= 21 && timeOfDay < 24){
            constraintLayoutMain.setBackground(ContextCompat.getDrawable(this, R.drawable.animationlist_night));
        }else {
            constraintLayoutMain.setBackground(ContextCompat.getDrawable(this, R.drawable.animationlist_night));
        }
        animationDrawable =(AnimationDrawable)constraintLayoutMain.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
    }
    @Override
    protected void onResume() {
        super.onResume();
        animationDrawable.start();
    }
}
