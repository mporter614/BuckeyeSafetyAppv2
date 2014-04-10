package com.example.buckeyesafetyappv2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.app.Notification;
import android.app.TaskStackBuilder;
import android.app.PendingIntent;
import android.os.Vibrator;



public class ProximityReceiver extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		
		String k = LocationManager.KEY_PROXIMITY_ENTERING;
		
		boolean state = arg1.getBooleanExtra(k, false);
		
		Vibrator vib = (Vibrator) arg0.getSystemService(Context.VIBRATOR_SERVICE);
		
		Intent intent = new Intent(arg0, GPSTrackerActivity.class);
		PendingIntent pIntent = PendingIntent.getActivity(arg0, 0, intent, 0);

		Notification n  = new Notification.Builder(arg0)
        .setSmallIcon(R.drawable.ic_launcher)
        .setContentTitle("WARNING")
        .setContentText("Crime reported nearby")
        .addAction(R.drawable.ic_launcher, "Open Map", pIntent).build();
	    
		  
		NotificationManager notificationManager = 
		  (NotificationManager) arg0.getSystemService(Context.NOTIFICATION_SERVICE);

		
		if (state) {
			Log.d(getClass().getSimpleName(), "entering");
			

			n.flags = Notification.FLAG_NO_CLEAR;
			
			notificationManager.notify(0, n);
			
			vib.vibrate(1600);
			
		}
		else {
			Toast.makeText(arg0, "Leaving crime area", Toast.LENGTH_LONG).show();
			
			notificationManager.cancel(0);
			
			vib.vibrate(300);
		
	}
}
}