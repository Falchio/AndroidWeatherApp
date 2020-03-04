package ru.skillsnet.falchio;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;


import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ru.skillsnet.falchio.data.DataWeather;
import ru.skillsnet.falchio.main.WeatherFactory;
import ru.skillsnet.falchio.parsers.DownloadImageTask;
import static ru.skillsnet.falchio.data.GlobalConstants.OPEN_WEATHER;
import static ru.skillsnet.falchio.data.GlobalConstants.OW_IMAGE;
import static ru.skillsnet.falchio.data.GlobalConstants.OW_IMAGE_END;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private DataWeather weather;
    private String userLocation;
    private TextView temperatureTextView;
    private ImageView weatherIcon;


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        userLocation = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getString("location", getResources().getString(R.string.default_user_location));
        Toast.makeText(getContext(), userLocation, Toast.LENGTH_LONG).show();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        temperatureTextView = rootView.findViewById(R.id.temperature_view_text);
        weatherIcon = rootView.findViewById(R.id.weather_icon);

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                weather = new WeatherFactory(
                        getContext(),
                        OPEN_WEATHER,
                        userLocation
                ).getDataWeather();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        setWeatherText();
                    }
                });
            }
        }).start();
//        setWeatherText(); //Устанавливаем значение температурного табло

        return rootView;
    }

    private void setWeatherText() {

        StringBuilder forecastMessage = new StringBuilder();
        forecastMessage.append(
                getString(R.string.temperature) + weather.getTemperature().getTemp() +
                        "\n" + getString(R.string.temp_min) + weather.getTemperature().getTempMin() +
                        "\n" + getString(R.string.max_temp) + weather.getTemperature().getTempMax() +
                        "\n" + getString(R.string.feels_like) + weather.getTemperature().getTempFeelsLike() +
                        "\n" + getString(R.string.pressure) + weather.getClouds().getAtmPressure() +
                        "\n" + weather.getWeather().getDescription() +
                        "\n" + getString(R.string.speed_weather) + weather.getWind().getWindSpeed() +
                        "\n" + getString(R.string.wind_direction) + weather.getWind().getWindDirection() +
                        "\n" + getString(R.string.visibility) + weather.getClouds().getVisibility());
        temperatureTextView.setText(forecastMessage);

        new DownloadImageTask(weatherIcon)
                .execute(
                        OW_IMAGE + weather.getWeather().getWeatherIcon() + OW_IMAGE_END);
    }

}
