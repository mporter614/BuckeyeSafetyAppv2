package com.example.buckeyesafetyappv2;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;
import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.model.CircleOptions;


public class GPSTrackerActivity extends Activity {
	
	private GoogleMap googleMap;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpstracker);
 
        try {
            // Loading map
            initilizeMap();
            
            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().isMyLocationButtonEnabled();
            
            setMarkers();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
	
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();
            
 
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
            
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    }
    
    private void setMarkers() {
    	
    	double latitude1 = 39.999769;
    	double longitude1 = -83.001232;
    	
    	double latitude2 = 40.013181;
    	double longitude2 = -83.013248;
    	
    	int radius = 402;
    	
		SharedPreferences settings = getSharedPreferences("prefs", 0);
	       String pressed = settings.getString("pressed", "0");
	       
	       if(pressed == "0")
	       {
		       radius = 402;

	       }
	       else if(pressed == "1")
	       {
		       radius = 804;

	       }
	       else if(pressed == "2")
	       {
		       radius = 1609;

	       }
    	
    	MarkerOptions marker1 = new MarkerOptions().position(new LatLng(latitude1, longitude1)).title("Test Crime 1");
    	MarkerOptions marker2 = new MarkerOptions().position(new LatLng(latitude1-.003000, longitude1-.002000)).title("Test Crime 2");
    	MarkerOptions marker3 = new MarkerOptions().position(new LatLng(latitude2, longitude2)).title("Test Crime 3");
    	
    	marker2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
    	marker3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
    	
    	googleMap.addMarker(marker1);
    	googleMap.addMarker(marker2);
    	googleMap.addMarker(marker3);
    	
    	
    	//Set up Circles
    	CircleOptions circleOptions1 = new CircleOptions()
    		.center(new LatLng(latitude1, longitude1)).radius(radius)
    		.fillColor(0x40ff0000).strokeColor(0x90ff0000)
    		.strokeWidth(5);
    	CircleOptions circleOptions2 = new CircleOptions()
    		.center(new LatLng(latitude1-.003000, longitude1-.002000)).radius(radius)
    		.fillColor(0x40ff0000).strokeColor(0x90ff0000)
    		.strokeWidth(5);
    	CircleOptions circleOptions3 = new CircleOptions()
    		.center(new LatLng(latitude2, longitude2)).radius(radius)
    		.fillColor(0x40ff0000).strokeColor(0x90ff0000)
    		.strokeWidth(5);

    	//Add Circle to map
    	googleMap.addCircle(circleOptions1);
    	googleMap.addCircle(circleOptions2);
    	googleMap.addCircle(circleOptions3);
    	

    }
	
	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
	

}
