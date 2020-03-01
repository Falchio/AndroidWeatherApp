package ru.skillsnet.falchio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ru.skillsnet.falchio.data.GlobalConstants;
import ru.skillsnet.falchio.decor.AppStyle;


public class MainActivity extends AppStyle implements GlobalConstants {
    private static final int SETTING_CODE = 88;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==SETTING_CODE) recreate();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.button_menu_settings:
                Intent settingIntent = new Intent(MainActivity.this, DSetting.class);
                startActivityForResult(settingIntent, SETTING_CODE);;
                return true;
            case R.id.button_menu_select_city:
                Intent selectIntent = new Intent(MainActivity.this, SelectCity.class);
                startActivity(selectIntent);
            case R.id.button_menu_about:
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.fragment_main),"Перейти к инфо о программе?", Snackbar.LENGTH_LONG);
                mySnackbar.setAction("Перейти", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent selectIntent = new Intent(MainActivity.this, About.class);
                        startActivity(selectIntent);
                    }
                });
                mySnackbar.show();
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
