package com.example.exam_count_down;


import com.example.asquare.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Toast;


public class MyBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent aintent) {
	    Bundle params = aintent.getExtras();
		String Course = params.getString("Course"); 
		int Num = params.getInt("Num"); 
		 
		
		Toast.makeText(context, "It's time to have exam", Toast.LENGTH_SHORT).show();
		
		// Vibrate the mobile phone
		Vibrator vibrator = (Vibrator) context
				.getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(2000);
		
		
		NotificationManager noMgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

		Notification notification = new Notification.Builder(context)
			.setContentTitle("Exam Notification")
			.setContentText(Course)
			.setSmallIcon(R.drawable.ic_launcher)
			.build();
			notification.number = 1;
			
		noMgr.notify(Num , notification);



	}

}
