package ru.skillsnet.falchio;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import java.util.Arrays;
import java.util.List;

public class SelectCity extends AppCompatActivity {

    private SingleObject singleton;
    private CheckBox windSpeedCheck;
    private CheckBox atmPressureCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.enterUserLocation);
        String[] locations = getResources().getStringArray(R.array.locations);
        List<String> locationsList = Arrays.asList(locations);
        ArrayAdapter<String> adapterLocations = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, locationsList);
        autoCompleteTextView.setAdapter(adapterLocations);

        Button toMainScreenButton = findViewById(R.id.toMainScreenButton);
        toMainScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleton.setShowWindSpeed(windSpeedCheck.isChecked());
                singleton.setShowAtmPressure(atmPressureCheck.isChecked());
                Intent toMainScreenIntent = new Intent(SelectCity.this, MainActivity.class);
                startActivity(toMainScreenIntent);
            }
        });

        singleton = SingleObject.getInstance();
        windSpeedCheck = findViewById(R.id.checkBoxWind);
        atmPressureCheck = findViewById(R.id.checkBoxPressure);

        windSpeedCheck.setChecked(singleton.isShowWindSpeed());
        atmPressureCheck.setChecked(singleton.isShowAtmPressure());
    }


    @Override
    protected void onResume() {
        super.onResume();
        windSpeedCheck.setChecked(singleton.isShowWindSpeed());
        atmPressureCheck.setChecked(singleton.isShowAtmPressure());
    }

    @Override
    protected void onPause() {
        super.onPause();

        singleton.setShowWindSpeed(windSpeedCheck.isChecked());
        singleton.setShowAtmPressure(atmPressureCheck.isChecked());
    }
}
