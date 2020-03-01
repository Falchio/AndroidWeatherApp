package ru.skillsnet.falchio;

import androidx.appcompat.app.ActionBar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;

import ru.skillsnet.falchio.decor.AppStyle;

public class DSetting extends AppStyle {
    private final String CHECK_WIND = "Check_wind";
    private final String CHECK_PRESSURE = "Check_pressure";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_setting);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        SharedPreferences sharedPref = getSharedPreferences(SETTINGS, MODE_PRIVATE);

        CheckBox checkWind = findViewById(R.id.checkbox_wind_speed);
        CheckBox checkPressure = findViewById(R.id.checkbox_atm_pressure);
        Switch useDarkTheme = findViewById(R.id.switch_theme);

        checkWind.setChecked(sharedPref.getBoolean(CHECK_WIND,true));
        checkPressure.setChecked(sharedPref.getBoolean(CHECK_PRESSURE, true));
        useDarkTheme.setChecked(sharedPref.getBoolean(DARK_THEME,false));

        checkWind.setOnClickListener(new CheckBoxListener(CHECK_WIND));
        checkPressure.setOnClickListener(new CheckBoxListener(CHECK_PRESSURE));

        useDarkTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setDarkTheme(isChecked);
                recreate();
            }
        });

    }

    private class CheckBoxListener implements View.OnClickListener {
        private String stringKey;

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
