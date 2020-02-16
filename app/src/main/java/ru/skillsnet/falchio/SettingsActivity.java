package ru.skillsnet.falchio;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();
    private final boolean DEBUG = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

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

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
}