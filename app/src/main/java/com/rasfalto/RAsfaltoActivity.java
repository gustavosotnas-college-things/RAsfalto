package com.rasfalto;

import android.content.Intent;
import android.location.Location;
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

        Location location1 = new Location("");
        Location location2 = new Location("");
        long distancia = location1.distanceTo(location2);

        mMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                        new LatLng(-16.6033508, -49.266545),15
                ));
            nMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN); // economiza dados de celular
        // if (...Permission_GRANTED...
            // return
        // else
            mMap.setMyLocationEnabled(true); // requer permissão para obter a localização do celular

        map.addMarker(new MarkerOptions()
                .position(new LatLng(-16.6033508, -49.266545))
                .title("INF"))
                .snippet("Meu lugar preferido")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
    }

    @Override
    public void onInfoWindowClick (Marker marker) {
        Intent intent = new Intent(this, SecondActivity.class);
    }
}
