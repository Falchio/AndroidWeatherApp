package ru.skillsnet.falchio;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import ru.skillsnet.falchio.data.DataWeather;
import ru.skillsnet.falchio.main.DLiveData;
import ru.skillsnet.falchio.main.DViewModel;


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


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(liveData);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        temperatureTextView = rootView.findViewById(R.id.temperature_view_text);
        ImageView weatherIcon = rootView.findViewById(R.id.weather_icon);
        locationText = rootView.findViewById(R.id.text_view_location);
        feelsLikeText = rootView.findViewById(R.id.text_view_feels_like);
        windSpeedText = rootView.findViewById(R.id.text_view_wind_speed);
        descriptionText = rootView.findViewById(R.id.text_view_description);
        dateText = rootView.findViewById(R.id.text_view_date);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        model.getWeatherMutableLiveData().observe(this, new Observer<DataWeather>() {
            @Override
            public void onChanged(DataWeather dataWeather) {
                setWeatherText(dataWeather);
            }
        });
    }

    private void setWeatherText(DataWeather weather) {
        temperatureTextView.setText(weather.getTemperature().getTemp() + getString(R.string.celsius));
        locationText.setText(String.valueOf(weather.getDLocation().getCityName()));
        feelsLikeText.setText(String.valueOf(weather.getTemperature().getTempFeelsLike()));
        windSpeedText.setText(weather.getWind().getWindSpeed() + getString(R.string.meters_per_second));
        descriptionText.setText(weather.getWeather().getDescription());
        Date date = new java.util.Date(weather.getDTime().getDataTime()*1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4"));
        dateText.setText(sdf.format(date));

//        new DownloadImageTask(weatherIcon)
//                .execute(
//                        OW_IMAGE + weather.getWeather().getWeatherIcon() + OW_IMAGE_END);
    }

}
