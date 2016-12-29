package com.crossover.assignment.jitenshasaitama.mapstracker;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.crossover.assignment.jitenshasaitama.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class BicycleLocatorActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;
    private static final LatLng LOWER_MANHATTAN = new LatLng(40.722543,
            -73.998585);
    private static final LatLng TIMES_SQUARE = new LatLng(40.7577, -73.9857);
    private static final LatLng BROOKLYN_BRIDGE = new LatLng(40.7057, -73.9964);
    private static final LatLng WALL_STREET = new LatLng(40.7064, -74.0094);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicycle_locator);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        addMarkers(mMap);
    }



                 	private void addMarkers(GoogleMap googleMap)


                        {
                 		if (googleMap != null) {


                 			// a draggable marker with title and snippet
                 			googleMap.addMarker(new MarkerOptions().position(TIMES_SQUARE)
                 					.title("Race Start").snippet("Race Start: 9:00 AM CST")
                 					.draggable(true));

                 			// marker with custom color
                 			googleMap.addMarker(new MarkerOptions()
                 					.position(BROOKLYN_BRIDGE)
                 					.title("First Pit Stop")
                 					.icon(BitmapDescriptorFactory
                 							.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

                 			// marker with opacity
                 			googleMap.addMarker(new MarkerOptions().position(LOWER_MANHATTAN)
                 					.title("Second Pit Stop").snippet("Best Time: 6 Secs")
                 					.alpha(0.4f));

                 			// marker using custom image
//                 			googleMap.addMarker(new MarkerOptions()
//                 					.position(WALL_STREET)
//                 					.title("Wrong Turn!")
//                 					.icon(BitmapDescriptorFactory
//                 							.fromResource(R.drawable.my_flag)));

                 			googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                 					BROOKLYN_BRIDGE, 13));

                 		}
                 	}

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }








}
