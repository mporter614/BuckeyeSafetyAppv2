package com.example.buckeyesafetyappv2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.widget.Toast;
import android.app.NotificationManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.os.Vibrator;
import android.media.AudioManager;


public class ProximityReceiver extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		
		String k = LocationManager.KEY_PROXIMITY_ENTERING;
		
		boolean state = arg1.getBooleanExtra(k, false);
		
		Vibrator vib = (Vibrator) arg0.getSystemService(Context.VIBRATOR_SERVICE);
		AudioManager am = (AudioManager) arg0.getSystemService(Context.AUDIO_SERVICE);
		
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
			
			n.flags = Notification.FLAG_NO_CLEAR;
			notificationManager.notify(0, n);
			
			vib.vibrate(1600);
			
			am.setStreamVolume(AudioManager.STREAM_MUSIC, 2, AudioManager.FLAG_SHOW_UI);
			
		}
		else {
			Toast.makeText(arg0, "Leaving crime area", Toast.LENGTH_SHORT).show();
			
			notificationManager.cancelAll();
			
			vib.vibrate(300);
	}
}
}