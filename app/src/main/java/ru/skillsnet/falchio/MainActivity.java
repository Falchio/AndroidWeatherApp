package ru.skillsnet.falchio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private String userLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userLocation = PreferenceManager.getDefaultSharedPreferences(this)
                .getString("location",getResources().getString(R.string.default_user_location));

        Toast.makeText(getApplicationContext(),userLocation, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        userLocation = PreferenceManager.getDefaultSharedPreferences(this)
                .getString("location",getResources().getString(R.string.default_user_location));
        Toast.makeText(getApplicationContext(),userLocation, Toast.LENGTH_SHORT).show();
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
            case R.id.button_menu_location:
                Intent selectCityIntent = new Intent(MainActivity.this, SelectCity.class);
                startActivity(selectCityIntent);
                return true;
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
