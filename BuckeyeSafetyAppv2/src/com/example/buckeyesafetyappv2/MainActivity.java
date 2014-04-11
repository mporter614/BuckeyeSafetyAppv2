package com.example.buckeyesafetyappv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
	}
	
	public void onClick (View view) {
		  
		  if (view.getId() == R.id.gpstrackerbutton) 
		  {
			  Intent myIntent = new Intent(view.getContext(), GPSTrackerActivity.class);
			  startActivityForResult(myIntent, 0);
		  }
		  else if (view.getId() == R.id.helpbutton) 
		  {
			  Intent myIntent = new Intent(view.getContext(), HelpActivity.class);
			  startActivityForResult(myIntent, 0);
		  }
		  else if (view.getId() == R.id.settingsbutton) 
		  {
			  Intent myIntent = new Intent(view.getContext(), SettingsActivity.class);
			  startActivityForResult(myIntent, 0);		  
		  }
		  		  
		} 

}
