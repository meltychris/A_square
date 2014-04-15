package com.example.gpa_calculator;

import com.example.asquare.R;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;


public class advice2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gpa_advice2);
		
		//Exit
		buttonGPAadvice2_1 = (Button)findViewById(R.id.buttonGPAadvice2_1);
		
		//this text view will show the advised TGA
		textViewGPAadvice2_3 = (TextView)findViewById(R.id.textViewGPAadvice2_3);
		
	}


	
	
	
	
	 Button buttonGPAadvice2_1; 
	 TextView textViewGPAadvice2_3;
}