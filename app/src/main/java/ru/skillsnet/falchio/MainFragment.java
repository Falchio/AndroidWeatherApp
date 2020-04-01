package ru.skillsnet.falchio;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import ru.skillsnet.falchio.main.DLiveData;
import ru.skillsnet.falchio.main.DViewModel;
import ru.skillsnet.falchio.openweathergson.OpenweatherRequest;
import ru.skillsnet.falchio.openweathergson.Weather;
import ru.skillsnet.falchio.service.WeatherService;

import static ru.skillsnet.falchio.data.GlobalConstants.OW_IMAGE;
import static ru.skillsnet.falchio.data.GlobalConstants.OW_IMAGE_END;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private TextView temperatureTextView;
    private TextView feelsLikeText;
    private TextView windSpeedText;
    private TextView locationText;
    private TextView descriptionText;
    private TextView dateText;
    private final DLiveData liveData = new DLiveData();
    private final DViewModel model = liveData.getViewModel();
    private ImageView weatherIcon;


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(liveData);

        model.getOpenWeatherMutableLiveData().observe(this, new Observer<OpenweatherRequest>() {
            @Override
            public void onChanged(OpenweatherRequest openweatherRequest) {
                Log.e("DWeather", "onChanged: changed openweatherRequest" );
                setWeatherText(openweatherRequest);
            }
        });

        Objects.requireNonNull(getActivity()).startService(new Intent(getActivity(), WeatherService.class));

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        temperatureTextView = rootView.findViewById(R.id.temperature_view_text);
        weatherIcon = rootView.findViewById(R.id.weather_icon);
        locationText = rootView.findViewById(R.id.text_view_location);
        feelsLikeText = rootView.findViewById(R.id.text_view_feels_like);
        windSpeedText = rootView.findViewById(R.id.text_view_wind_speed);
        descriptionText = rootView.findViewById(R.id.text_view_description);
        dateText = rootView.findViewById(R.id.text_view_date);
        return rootView;
    }


    private void setWeatherText(OpenweatherRequest openweatherRequest) {

        Log.e("DWeather", "setWeatherText: start request in Main Fragment");

        if (openweatherRequest==null) {
            locationText.setText(R.string.location_not_found);
            return;}

        locationText.setText(openweatherRequest.getName());

        long temp = Math.round(openweatherRequest.getMain().getTemp());
        temperatureTextView.setText(temp + getString(R.string.celsius));

        long feelsLike =Math.round(openweatherRequest.getMain().getFeels_like());
        feelsLikeText.setText( feelsLike + getString(R.string.celsius));

        long windSpeed = Math.round(openweatherRequest.getWind().getSpeed());
        windSpeedText.setText(windSpeed + getString(R.string.meters_per_second));

        Weather[] weather = openweatherRequest.getWeather();
        descriptionText.setText(weather[0].getDescription());
        Date date = new java.util.Date(openweatherRequest.getDt()*1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+3"));
        dateText.setText(sdf.format(date));

        final int i = getResources().getIdentifier("ic_"+weather[0].getIcon(), "drawable", getContext().getPackageName());
        weatherIcon.setImageResource(i);
    }

}
