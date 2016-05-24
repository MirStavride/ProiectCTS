package com.example.sandumihai.discovertheworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class googleMapsActivity extends AppCompatActivity {

    LatLng pos = new LatLng(40,-79);
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);


        try {
            if(googleMap == null){
                googleMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.id_googleMapsActivity)).getMap();
            }

            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            Marker mark = googleMap.addMarker(new MarkerOptions().position(pos).title("IP position"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void backToHomeFromGoogleMaps(View view) {
        finish();
    }
}
