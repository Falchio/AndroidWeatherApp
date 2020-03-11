package ru.skillsnet.falchio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ru.skillsnet.falchio.data.GlobalConstants;
import ru.skillsnet.falchio.decor.AppStyle;




public class MainActivity extends AppStyle implements GlobalConstants, NavigationView.OnNavigationItemSelectedListener {
    private static final int SETTING_CODE = 88;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDrawer();
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
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

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

    private void initDrawer(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.button_menu_settings:
                closeDrawer();
                Intent settingIntent = new Intent(MainActivity.this, DSetting.class);
                startActivityForResult(settingIntent, SETTING_CODE);
                closeDrawer();
                return true;
            case R.id.button_menu_select_city:
                closeDrawer();
                Intent selectIntent = new Intent(MainActivity.this, SelectCity.class);
                startActivity(selectIntent);
            case R.id.button_menu_about:
                closeDrawer();
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
                closeDrawer();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void closeDrawer(){
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
