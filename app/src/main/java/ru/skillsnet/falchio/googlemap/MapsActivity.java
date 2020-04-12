package ru.skillsnet.falchio.googlemap;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import ru.skillsnet.falchio.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker currentMarker;
    String textAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        currentMarker= mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
//                getAddress(latLng);
                addMarker(latLng);
            }
        });
    }
//
//     Получаем адрес по координатам
//    private void getAddress(final LatLng location){
//        final Geocoder geocoder = new Geocoder(this);
//        // Поскольку geocoder работает по интернету, создадим отдельный поток
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    final List<Address> addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1);
//                    textAddress.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            textAddress.setText(addresses.get(0).getAddressLine(0));
//                        }
//                    });
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }

    private void addMarker(LatLng location){
        currentMarker.remove();
        currentMarker=mMap.addMarker(new MarkerOptions().position(location).title(getString(R.string.selected_location)));
    }
}
