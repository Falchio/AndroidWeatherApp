package ru.skillsnet.falchio;

import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;

import java.util.Objects;

import ru.skillsnet.falchio.decor.AppStyle;

public class About extends AppStyle {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (toolbar != null) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }
    }
}
