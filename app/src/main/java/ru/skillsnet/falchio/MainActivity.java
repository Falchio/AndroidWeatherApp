package ru.skillsnet.falchio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ru.skillsnet.falchio.data.GlobalConstants;
import ru.skillsnet.falchio.main.SelectCity;
import ru.skillsnet.falchio.main.SettingsActivity;


public class MainActivity extends AppCompatActivity implements GlobalConstants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
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

    private void saveToFile(Parcelable parcel, String fileName) {
        try (FileOutputStream fileOutputStream = getApplication().openFileOutput(fileName, Context.MODE_PRIVATE);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(parcel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Parcelable readOutFile(String fileName) {
        Parcelable parcel = null;
        try (FileInputStream fis = getApplication().openFileInput(fileName);
             ObjectInputStream is = new ObjectInputStream(fis)) {
            parcel = (Parcelable) is.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return parcel;
    }
}
