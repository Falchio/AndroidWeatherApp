package ru.skillsnet.falchio.decor;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ru.skillsnet.falchio.R;

public abstract class AppStyle extends AppCompatActivity {
    protected final String SETTINGS = "Settings";
    protected final String DARK_THEME =  "switch_dark_theme";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isDarkTheme())
            setTheme(R.style.DayNightTheme);
        else
            setTheme(R.style.AppLightTheme);
    }

    // Чтение настроек
    protected boolean isDarkTheme() {
        // Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(SETTINGS, MODE_PRIVATE);
        return sharedPref.getBoolean(DARK_THEME, true);
    }

    // Сохранение настроек
    protected void setDarkTheme(boolean isDarkTheme) {
        SharedPreferences sharedPref = getSharedPreferences(SETTINGS, MODE_PRIVATE);
        // Настройки сохраняются посредством класса Editor.
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(DARK_THEME, isDarkTheme);
        editor.apply();
    }


}
