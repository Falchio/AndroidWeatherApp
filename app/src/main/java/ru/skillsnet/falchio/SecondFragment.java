package ru.skillsnet.falchio;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Objects;

import ru.skillsnet.MyApplication;
import ru.skillsnet.falchio.database.OpenSimpleDataSource;
import ru.skillsnet.falchio.database.SimpleWeatherData;
import ru.skillsnet.falchio.decor.OtherCityAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private RecyclerView otherCityRecView;
    private OpenSimpleDataSource opSource;
    String[] otherCity;


    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        opSource = new OpenSimpleDataSource(MyApplication.getInstance().getOpenWeatherDao());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecyclerView();
    }

    private void initRecyclerView() {


//            String[] otherCity = getResources().getStringArray(R.array.other_city);
        int size = (int) opSource.getCountSimpleWeatherData();

        List<SimpleWeatherData> simpleList = opSource.getAllSimpleWeatherData();
        otherCity = new String[size];

        int i = 0;
        for (SimpleWeatherData s : simpleList) {
            otherCity[i] = s.getSimpleDataString();
            Log.e("TAG", "run: " + s.getSimpleDataString());
            i++;
        }


        RecyclerView otherCityRecView = Objects.requireNonNull(getView()).findViewById(R.id.other_city_recycler);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getContext()), LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.separator));
        otherCityRecView.addItemDecoration(itemDecoration);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        otherCityRecView.setLayoutManager(layoutManager);

        OtherCityAdapter adapter = new OtherCityAdapter(otherCity);
        otherCityRecView.setAdapter(adapter);

    }

}
