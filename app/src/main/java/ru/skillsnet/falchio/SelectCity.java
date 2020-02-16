package ru.skillsnet.falchio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class SelectCity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    private final boolean DEBUG = true;

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


        if (DEBUG){
            Toast.makeText(getApplicationContext(),TAG +" onCreate", Toast.LENGTH_SHORT).show();
            Log.d(TAG, TAG +" onCreate");
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        if (DEBUG){
            Toast.makeText(getApplicationContext(),TAG +" onStart", Toast.LENGTH_SHORT).show();
            Log.d(TAG, TAG +" onStart");
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (DEBUG){
            Toast.makeText(getApplicationContext(),TAG +" onRestoreInstanceState", Toast.LENGTH_SHORT).show();
            Log.d(TAG, TAG +" onRestoreInstanceState");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        windSpeedCheck.setChecked(singleton.isShowWindSpeed());
        atmPressureCheck.setChecked(singleton.isShowAtmPressure());

        if (DEBUG){
            Toast.makeText(getApplicationContext(),TAG +" onResume", Toast.LENGTH_SHORT).show();
            Log.d(TAG, TAG +" onResume");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        singleton.setShowWindSpeed(windSpeedCheck.isChecked());
        singleton.setShowAtmPressure(atmPressureCheck.isChecked());

        if (DEBUG){
            Toast.makeText(getApplicationContext(),TAG +" onPause", Toast.LENGTH_SHORT).show();
            Log.d(TAG, TAG +" onPause");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);

        if (DEBUG){
            Toast.makeText(getApplicationContext(),TAG +" onSaveInstanceState", Toast.LENGTH_SHORT).show();
            Log.d(TAG, TAG +" onSaveInstanceState");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (DEBUG){
            Toast.makeText(getApplicationContext(),TAG +" onStop", Toast.LENGTH_SHORT).show();
            Log.d(TAG, TAG +" onStop");
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (DEBUG){
            Toast.makeText(getApplicationContext(),TAG +" onRestart", Toast.LENGTH_SHORT).show();
            Log.d(TAG, TAG +" onRestart");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (DEBUG){
            Toast.makeText(getApplicationContext(),TAG +" onStop", Toast.LENGTH_SHORT).show();
            Log.d(TAG, TAG +" onStop");
        }
    }

}
