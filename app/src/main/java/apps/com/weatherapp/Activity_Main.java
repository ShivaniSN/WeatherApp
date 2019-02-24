package apps.com.weatherapp;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Activity_Main extends AppCompatActivity implements MainActivityPresenter.View{

    @InjectView(R.id.cl_main) ConstraintLayout constraintLayoutMain;
    @InjectView(R.id.tv_city) TextView textViewCity;
    @InjectView(R.id.tv_day) TextView textViewDay;
    @InjectView(R.id.tv_temp) TextView textViewTemperature;
    @InjectView(R.id.tv_desc) TextView textViewDescription;
    @InjectView(R.id.tv_humidity) TextView textViewHumidity;
    @InjectView(R.id.tv_wind) TextView textViewWind;
    @InjectView(R.id.iv_weather)ImageView imageViewWeather;

    AnimationDrawable animationDrawable;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        presenter = new MainActivityPresenter(this);

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        if(timeOfDay >= 21 && timeOfDay < 24){
            constraintLayoutMain.setBackground(ContextCompat.getDrawable(this, R.drawable.animationlist_night));
        }else {
            constraintLayoutMain.setBackground(ContextCompat.getDrawable(this, R.drawable.animationlist_day));
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

    @Override
    public void updateUserInfoTextView(String info) {
        textViewCity.setText(info);
        textViewDay.setText(info);
        textViewTemperature.setText(info);
        textViewDescription.setText(info);
        textViewHumidity.setText(info);
        textViewWind.setText(info);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
