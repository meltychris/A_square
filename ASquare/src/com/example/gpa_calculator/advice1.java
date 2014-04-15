package com.example.gpa_calculator;

import com.example.asquare.R;
import com.example.study_path.Advanced_Activity;
import com.example.study_path.Advanced_Activity_choose;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.app.Activity;
import android.content.Intent;


public class advice1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gpa_advice1);
		
		//edited by stsk, these "findViewByID" should be put in onCreate, not in onClick"
		//the declaration should put outside onCreate.
		
		//Next
		buttonGPAadvice1_1 = (Button)findViewById(R.id.buttonGPAadvice1_1);
		//Reset
		buttonGPAadvice1_2 = (Button)findViewById(R.id.buttonGPAadvice1_2);
		   radioButtonGPAadvice1_1 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_1);
     	    radioButtonGPAadvice1_2 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_2);
     	 radioButtonGPAadvice1_3 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_3);
     	  radioButtonGPAadvice1_4 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_4);
     	radioButtonGPAadvice1_5 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_5);
     	  radioButtonGPAadvice1_6 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_6);
     	 radioButtonGPAadvice1_7 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_7);
     	   radioButtonGPAadvice1_8 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_8);
     	  radioButtonGPAadvice1_9 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_9);
     	    //Your Target TGA
     	    editTextGPAadvice1_1 = (EditText)findViewById(R.id.editTextGPAadvice1_1);
		//ref Advanced_activity
	
	
		buttonGPAadvice1_1.setOnClickListener(new Button.OnClickListener(){ 
         @Override
         public void onClick(View v) {
             // TODO Auto-generated method stub

     		}
     });
	 
		
		buttonGPAadvice1_2.setOnClickListener(new Button.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {

	        	 
	        	 
	        	 
	        	 
	     		}
	     });
	
	}
	
	 Button buttonGPAadvice1_1; 
	 Button buttonGPAadvice1_2; 
	 RadioButton radioButtonGPAadvice1_1;
	    RadioButton radioButtonGPAadvice1_2;
	    RadioButton radioButtonGPAadvice1_3;
	    RadioButton radioButtonGPAadvice1_4;
	    RadioButton radioButtonGPAadvice1_5;
	    RadioButton radioButtonGPAadvice1_6;
	    RadioButton radioButtonGPAadvice1_7;
	    RadioButton radioButtonGPAadvice1_8;
	    RadioButton radioButtonGPAadvice1_9;
 	    EditText editTextGPAadvice1_1;



}