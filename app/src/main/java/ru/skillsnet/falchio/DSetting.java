package ru.skillsnet.falchio;

import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;

import java.util.Objects;

import ru.skillsnet.falchio.decor.AppStyle;

public class DSetting extends AppStyle {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_setting);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }


        SharedPreferences sharedPref = getSharedPreferences(SETTINGS, MODE_PRIVATE);

        CheckBox checkWind = findViewById(R.id.checkbox_wind_speed);
        CheckBox checkPressure = findViewById(R.id.checkbox_atm_pressure);
        Switch useDarkTheme = findViewById(R.id.switch_theme);

        String CHECK_WIND = "Check_wind";
        checkWind.setChecked(sharedPref.getBoolean(CHECK_WIND,true));
        String CHECK_PRESSURE = "Check_pressure";
        checkPressure.setChecked(sharedPref.getBoolean(CHECK_PRESSURE, true));
        useDarkTheme.setChecked(sharedPref.getBoolean(DARK_THEME,false));

        checkWind.setOnClickListener(new CheckBoxListener(CHECK_WIND));
        checkPressure.setOnClickListener(new CheckBoxListener(CHECK_PRESSURE));

        useDarkTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            setDarkTheme(isChecked);
            recreate();
        });

    }

    private class CheckBoxListener implements View.OnClickListener {
        private final String stringKey;

        public CheckBoxListener(String stringKey){
            this.stringKey=stringKey;
        }

        @Override
        public void onClick(View v) {
            CheckBox checkBox = (CheckBox) v;
            SharedPreferences sp = getSharedPreferences(SETTINGS,MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            if (!checkBox.isChecked()){
                editor.putBoolean(stringKey, false);
                editor.apply();
            } else {
                editor.putBoolean(stringKey, true);
                editor.apply();
            }
        }
    }
}
