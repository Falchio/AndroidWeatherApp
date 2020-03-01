package ru.skillsnet.falchio;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.preference.PreferenceFragmentCompat;

import ru.skillsnet.falchio.R;
import ru.skillsnet.falchio.decor.AppStyle;

public class SettingsActivity extends AppStyle {

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

    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
//            SwitchPreference useDarkTheme = findPreference("switch_dark_theme");
//            useDarkTheme.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//                @Override
//                public boolean onPreferenceChange(Preference preference, Object newValue) {
//                    return false;
//                }
//            });
        }
    }

//    public static class AppPrefChangeListener implements Preference.OnPreferenceChangeListener{
//        final String DARK_THEME =  "switch_dark_theme";
//
//
//        @Override
//        public boolean onPreferenceChange(Preference preference, Object newValue) {
//            boolean isDarkTheme = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext())
//                    .getBoolean(DARK_THEME, false);
//
//            if (isDarkTheme){
//               MyApplication.getContext().setTheme(R.style.DayNightTheme);
////                Toast.makeText(MyApplication.getContext(),"+++", Toast.LENGTH_SHORT).show();
//            }
//
//
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.settings, new SettingsFragment())
//                    .commit();
//
//            return false;
//        }
//    }
}