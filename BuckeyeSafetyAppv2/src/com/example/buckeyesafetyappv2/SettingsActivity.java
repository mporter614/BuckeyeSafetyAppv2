package com.example.buckeyesafetyappv2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class SettingsActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);

		SharedPreferences settings = getSharedPreferences("prefs", 0);
	       String pressed = settings.getString("pressed", "0");
	       
	       if(pressed == "0")
	       {
		       radioGroup.check(R.id.radio0);

	       }
	       else if(pressed == "1")
	       {
		       radioGroup.check(R.id.radio1);

	       }
	       else if(pressed == "2")
	       {
		       radioGroup.check(R.id.radio2);

	       }

	}
	
	public void onClick (View view) {
		  
		  if (view.getId() == R.id.radio0) 
		  {
			  SharedPreferences settings = getSharedPreferences("prefs", 0);
		      SharedPreferences.Editor editor = settings.edit();
		      editor.putString("pressed", "0");

		      editor.commit();
		  }
		  else if (view.getId() == R.id.radio1) 
		  {
			  SharedPreferences settings = getSharedPreferences("prefs", 0);
		      SharedPreferences.Editor editor = settings.edit();
		      editor.putString("pressed", "1");

		      editor.commit();

		  }
		  else if (view.getId() == R.id.radio2) 
		  {
			  SharedPreferences settings = getSharedPreferences("prefs", 0);
		      SharedPreferences.Editor editor = settings.edit();
		      editor.putString("pressed", "2");

		      editor.commit();

		  }
		  		  
		} 


}
