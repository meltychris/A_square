package com.example.gpa_calculator;


import com.example.asquare.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personalinfo1);
		
		button1 = (Button)findViewById(R.id.button1);
		
		  button1.setOnClickListener(new View.OnClickListener() {

	            @Override
	            public void onClick(View view) {
	            	
	                //count = listView.getAdapter().getCount();
	            	Intent intent = new Intent();
	            	intent.setClass(MainActivity.this, GPAactivity2.class);
	                startActivity(intent);
	                


	            }
	        });
	}

	private Button button1;
}
