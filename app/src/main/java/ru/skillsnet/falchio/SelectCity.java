package ru.skillsnet.falchio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import ru.skillsnet.falchio.decor.AppStyle;

public class SelectCity extends AppStyle {
    private String userLocation;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
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
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLocation =  autoCompleteTextView.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("location", userLocation);
                editor.commit();

                Intent locationIntent = new Intent(SelectCity.this, MainActivity.class);
                locationIntent.putExtra("Location", userLocation);

                startActivity(locationIntent);
                finish();

            }
        });


    }
}
