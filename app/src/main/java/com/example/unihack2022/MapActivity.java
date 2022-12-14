package com.example.unihack2022;

import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_HYBRID;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_NONE;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_NORMAL;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_SATELLITE;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_TERRAIN;


import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_HYBRID;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;



import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.SupportMapFragment;


public class MapActivity extends AppCompatActivity implements OnMapReadyCallback  {

    ImageView parkbutton;
    CardView cardView;

    static final LatLng center = new LatLng(45.75653614493123, 21.22866545306889);
    static final LatLng iulius = new LatLng(45.76138917716781, 21.232814374031086);
    static final LatLng shopping = new LatLng(45.72408433856767, 21.19950301151653);
    static final LatLng ceva = new LatLng(45.7617624282513, 21.215455185956298);
    static final LatLng ceva2 = new LatLng(45.76098137761704, 21.22001291040688);
    static final LatLng ceva3 = new LatLng(45.7575158646988, 21.22245313564939);
    static final LatLng ceva4 = new LatLng(45.75581415556283, 21.237361858147207);


    private GoogleMap mMap;

    int pressed = 1,pressed1 = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_map);

        parkbutton=findViewById(R.id.parkbutton);

        cardView = findViewById(R.id.cardView);






        parkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pressed1 == 1) {
                        Toast.makeText(MapActivity.this, "Parking location has been registered!", Toast.LENGTH_LONG).show();
                }
            }
        });





        // Get the SupportMapFragment and request notification when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(MAP_TYPE_HYBRID);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {


            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                if (pressed == 1) {
                    cardView.setVisibility(View.GONE);
                    pressed = 0;
                } else if (pressed == 0) {
                    cardView.setVisibility(View.VISIBLE);
                    pressed = 1;
                }
                return false;
            }
        });




        mMap.addMarker(new MarkerOptions()
                .position(ceva));
        mMap.addMarker(new MarkerOptions()
                .position(ceva2));
        mMap.addMarker(new MarkerOptions()
                .position(ceva3));
        mMap.addMarker(new MarkerOptions()
                        .position(ceva4));
        mMap.addMarker(new MarkerOptions()
                .position(shopping)
                .title("Parcare Shopping City Timisoara"));
        mMap.addMarker(new MarkerOptions()
                .position(iulius)
                .title("Parcare Iulius Town"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center,13));
    }


}


