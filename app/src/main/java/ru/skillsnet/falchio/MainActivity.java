package ru.skillsnet.falchio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ThemedSpinnerAdapter;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ru.skillsnet.MyApplication;
import ru.skillsnet.falchio.data.GlobalConstants;
import ru.skillsnet.falchio.database.OpenSimpleDataSource;
import ru.skillsnet.falchio.decor.AppStyle;
import ru.skillsnet.falchio.receiver.ConnectReceiver;


public class MainActivity extends AppStyle implements GlobalConstants {
    private static final int SETTING_CODE = 88;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

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
                startActivityForResult(settingIntent, SETTING_CODE);
                return true;
            case R.id.button_menu_select_city:
                Intent selectIntent = new Intent(MainActivity.this, SelectCity.class);
                startActivity(selectIntent);
                return true;
            case R.id.button_menu_about:
                Intent aboutIntent = new Intent(MainActivity.this, About.class);
                startActivity(aboutIntent);
                return true;
            case R.id.clear_search_history:
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OpenSimpleDataSource  opSource = new OpenSimpleDataSource(MyApplication.getInstance().getOpenWeatherDao());
                        opSource.deleteHistory();
                    }
                });
                t1.run();
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
