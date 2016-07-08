package com.rasfalto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class RAsfaltoActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        initMap();
    }

    private void initMap() {
        //MapFragment ...
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                        new LatLng(-16.6033508, -49.266545),15
                ));
            nMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN); // economiza dados de celular
        // if (...Permission_GRANTED...
            // return
        // else
            mMap.setMyLocationEnabled(true); // requer permissão para obter a localização do celular

    }
}
