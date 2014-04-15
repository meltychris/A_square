package com.example.gpa_calculator;

import com.example.asquare.R;
import com.example.study_path.Advanced_Activity;
import com.example.study_path.Advanced_Activity_choose;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.app.Activity;
import android.content.Intent;


public class add_course_record extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gpa_add_course_record);

		//Add next course record
		Button buttonGPAadd1  = (Button)findViewById(R.id.buttonGPAadd1);
		//Add next course record
		Button buttonGPAadd2  = (Button)findViewById(R.id.buttonGPAadd2);
		//Reset
		Button buttonGPAadd3  = (Button)findViewById(R.id.buttonGPAadd3);
		
 	    radioButtonGPAadd1 = (RadioButton)findViewById(R.id.radioButtonGPAadd1);
 	    radioButtonGPAadd2 = (RadioButton)findViewById(R.id.radioButtonGPAadd2);
 	    radioButtonGPAadd3 = (RadioButton)findViewById(R.id.radioButtonGPAadd3);
 	    radioButtonGPAadd4 = (RadioButton)findViewById(R.id.radioButtonGPAadd4);
 	    radioButtonGPAadd5 = (RadioButton)findViewById(R.id.radioButtonGPAadd5);
 	    radioButtonGPAadd6 = (RadioButton)findViewById(R.id.radioButtonGPAadd6);
 	    radioButtonGPAadd7 = (RadioButton)findViewById(R.id.radioButtonGPAadd7);
 	    radioButtonGPAadd8 = (RadioButton)findViewById(R.id.radioButtonGPAadd8);
 	    radioButtonGPAadd9 = (RadioButton)findViewById(R.id.radioButtonGPAadd9);
 	 
 	    
 	    EditText editTextGPAadd1 = (EditText)findViewById(R.id.editTextGPAadd1);
 	    EditText editTextGPAadd2 = (EditText)findViewById(R.id.editTextGPAadd2);
 	    EditText editTextGPAadd3 = (EditText)findViewById(R.id.editTextGPAadd3);

		
		
		//ref Advanced_activity
	
	
		buttonGPAadd1.setOnClickListener(new Button.OnClickListener(){ 
         @Override
         public void onClick(View v) {
             // TODO Auto-generated method stub

     		}
     });
	 
		buttonGPAadd2.setOnClickListener(new Button.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {

	        	 
	        	 
	        	 
	        	 
	     		}
	     });
		
		buttonGPAadd3.setOnClickListener(new Button.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {

	        	 
	        	 
	        	 
	        	 
	     		}
	     });
	  
	}
	
	
	
	 Button buttonGPAadd1;
	 Button buttonGPAadd2; 
	 Button buttonGPAadd3; 
	 RadioButton radioButtonGPAadd1;;
	 RadioButton radioButtonGPAadd2;
	 RadioButton radioButtonGPAadd3;
	 RadioButton radioButtonGPAadd4;
	 RadioButton radioButtonGPAadd5;
	 RadioButton radioButtonGPAadd6;
	 RadioButton radioButtonGPAadd7;
	 RadioButton radioButtonGPAadd8;
	 RadioButton radioButtonGPAadd9;
	 


}