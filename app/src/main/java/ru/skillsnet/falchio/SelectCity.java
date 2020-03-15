package ru.skillsnet.falchio;


import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;


import java.util.Objects;

import ru.skillsnet.falchio.decor.AppStyle;

public class SelectCity extends AppStyle {
    private String userLocation;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }

        userLocation = PreferenceManager.getDefaultSharedPreferences(this)
                .getString("location",getResources().getString(R.string.default_user_location));

        final AutoCompleteTextView autoCompleteTextView = findViewById(R.id.enterUserLocation);
        autoCompleteTextView.setText(userLocation);
        String[] locations = getResources().getStringArray(R.array.locations);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, locations);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(0);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Button confirm = findViewById(R.id.confirm_location);
        confirm.setOnClickListener(v -> {
            userLocation =  autoCompleteTextView.getText().toString();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("location", userLocation);
            editor.commit();

            Intent locationIntent = new Intent(SelectCity.this, MainActivity.class);
            locationIntent.putExtra("DLocation", userLocation);

            startActivity(locationIntent);
            finish();

        });


    }
}
