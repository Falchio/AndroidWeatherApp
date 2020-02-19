package ru.skillsnet.falchio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SelectCity extends AppCompatActivity {
    private String userLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        userLocation = PreferenceManager.getDefaultSharedPreferences(this)
                .getString("location",getResources().getString(R.string.default_user_location));

        final AutoCompleteTextView autoCompleteTextView = findViewById(R.id.enterUserLocation);
        autoCompleteTextView.setText(userLocation);
        String[] locations = getResources().getStringArray(R.array.locations);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, locations);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(0);



        Button confirm = findViewById(R.id.confirm_location);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLocation =  autoCompleteTextView.getText().toString();

                Intent locationIntent = new Intent(SelectCity.this,MainActivity.class);
                locationIntent.putExtra("Location", userLocation);
                startActivity(locationIntent);
                finish();

            }
        });

        Button dayInHistory = findViewById(R.id.history_day);
        dayInHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Date currentTime = Calendar.getInstance().getTime();
            DateFormat monthFormat =new SimpleDateFormat("d_MMMM", Locale.getDefault());
            String monthText = monthFormat.format(currentTime);
            String url = "https://ru.wikipedia.org/wiki/" + monthText;
            Uri uri = Uri.parse(url);
            Intent browser = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(browser);
            Toast.makeText(getApplicationContext(), monthText,Toast.LENGTH_LONG).show();

           }
        });

    }
}
