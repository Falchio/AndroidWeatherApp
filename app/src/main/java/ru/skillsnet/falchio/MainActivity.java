package ru.skillsnet.falchio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private String userLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        userLocation = PreferenceManager.getDefaultSharedPreferences(this)
//                .getString("location",getResources().getString(R.string.default_user_location));
        //        Toast.makeText(getApplicationContext(),userLocation, Toast.LENGTH_SHORT).show();


        String message = getIntent().getStringExtra("Location");
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();

        Button dayInHistory = findViewById(R.id.history_day);
        dayInHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date currentTime = Calendar.getInstance().getTime();
                DateFormat monthFormat =new SimpleDateFormat("d_MMMM", Locale.getDefault());
                String monthText = monthFormat.format(currentTime);
                String localeLanguage = getResources().getConfiguration().locale.getLanguage();
                String url;
                if (localeLanguage.equals("en")){
                    url = "https://en.wikipedia.org/wiki/" + monthText;
                }else{
                    url = "https://ru.wikipedia.org/wiki/" + monthText;
                }

                Uri uri = Uri.parse(url);
                Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browser);
                Toast.makeText(getApplicationContext(), monthText,Toast.LENGTH_LONG).show();

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        userLocation = PreferenceManager.getDefaultSharedPreferences(this)
                .getString("location",getResources().getString(R.string.default_user_location));
        //        Toast.makeText(getApplicationContext(),userLocation, Toast.LENGTH_SHORT).show();

        String message = getIntent().getStringExtra("Location");
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.button_menu_settings:
                Intent settingIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingIntent);
                return true;
            case R.id.button_menu_select_city:
                Intent selectIntent = new Intent(MainActivity.this, SelectCity.class);
                startActivity(selectIntent);
            case R.id.button_menu_about:
                return true;
            case R.id.button_menu_quit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
