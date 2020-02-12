package ru.skillsnet.falchio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toSelectLocationButton = findViewById(R.id.selectLocationButton);
        toSelectLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectCityIntent = new Intent(MainActivity.this, SelectCity.class);
                startActivity(selectCityIntent);
            }
        });
    }
}
