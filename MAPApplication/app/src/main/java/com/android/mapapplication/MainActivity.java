package com.android.mapapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        Button buttonNormal = findViewById(R.id.buttonNormal);
        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
        Button buttonHybrid = findViewById(R.id.buttonHybrid);
        buttonHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        Button buttonSattelite = findViewById(R.id.buttonSattelite);
        buttonSattelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        Button buttonTerrain = findViewById(R.id.buttonTerrain);
        buttonTerrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });
        Button buttonNightMode = findViewById(R.id.buttonNightMode);
        buttonNightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(MainActivity.this, R.raw.night_mode_json));
            }
        });
        Button buttonNormalMode = findViewById(R.id.buttonNormalMode);
        buttonNormalMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(MainActivity.this, R.raw.normal_mode_json));
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;

        this.mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        this.mMap.getUiSettings().setRotateGesturesEnabled(true);
        this.mMap.getUiSettings().setZoomGesturesEnabled(true);
        this.mMap.setTrafficEnabled(true);

        LatLng appLatLong = new LatLng(37.335619872151064, -122.01462631529547);
        this.mMap.addMarker(new MarkerOptions()
                .position(appLatLong)
                .title("Apple Headquarter")
                .snippet("Apple California, USA"));

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(appLatLong, 10));
    }
}