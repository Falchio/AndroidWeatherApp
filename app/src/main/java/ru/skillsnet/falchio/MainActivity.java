package ru.skillsnet.falchio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    private final boolean DEBUG = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (DEBUG){
            Toast.makeText(getApplicationContext(),TAG +"  onCreate", Toast.LENGTH_SHORT).show();
            Log.d(TAG, TAG +"  onCreate");
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

        if (DEBUG){
            Toast.makeText(getApplicationContext(),TAG +" onResume", Toast.LENGTH_SHORT).show();
            Log.d(TAG, TAG +" onResume");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

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
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
