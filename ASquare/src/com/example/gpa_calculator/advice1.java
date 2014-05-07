package com.example.gpa_calculator;

import com.example.asquare.R;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;


public class advice1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gpa_advice1);
		
		//Calculate
		Button buttonGPAadvice1_1 = (Button)findViewById(R.id.buttonGPAadvice1_1);
		//Reset
		Button buttonGPAadvice1_2 = (Button)findViewById(R.id.buttonGPAadvice1_2);
		//year1-5
		final RadioGroup RadioGroupadvice1=(RadioGroup)findViewById(R.id.RadioGroupGPAadvice1);
		final RadioButton radioButtonGPAadvice1_1 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_1);
		final RadioButton radioButtonGPAadvice1_2 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_2);
		final RadioButton radioButtonGPAadvice1_3 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_3);
		final RadioButton radioButtonGPAadvice1_4 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_4);
		final RadioButton radioButtonGPAadvice1_5 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_5);
     	//Fall - Summer
     	final RadioGroup RadioGroupadvice2=(RadioGroup)findViewById(R.id.RadioGroupGPAadvice2);
     	final RadioButton radioButtonGPAadvice1_6 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_6);
     	final RadioButton radioButtonGPAadvice1_7 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_7);
     	final RadioButton radioButtonGPAadvice1_8 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_8);
     	final RadioButton radioButtonGPAadvice1_9 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_9);
     	//Your Target TGA
     	final EditText editTextGPAadvice1_1 = (EditText)findViewById(R.id.editTextGPAadvice1_1);
     	final EditText editTextGPAadvice1_2 = (EditText)findViewById(R.id.editTextGPAadvice1_2);
		//ref Advanced_activity
	
     	radioButtonGPAadvice1_1.setChecked(true);
     	radioButtonGPAadvice1_6.setChecked(true);
	
     	//Calculate
		buttonGPAadvice1_1.setOnClickListener(new Button.OnClickListener(){ 
			@Override
			public void onClick(View v) {
            
				int year = -1;//dummy
				int sem = -1;//dummy
				
				if (radioButtonGPAadvice1_1.isChecked() == true)
				{
					year = 1;
				}
				else if (radioButtonGPAadvice1_2.isChecked() == true)
				{
					year = 2;
				}
				else if (radioButtonGPAadvice1_3.isChecked() == true)
				{
					year = 3;
				}
				else if (radioButtonGPAadvice1_4.isChecked() == true)
				{
					year = 4;
				}
				else if (radioButtonGPAadvice1_5.isChecked() == true)
				{
					year = 5;
				}
				else
				{
					DisplayToast("There is a bug");
				}
				
				
				if (radioButtonGPAadvice1_6.isChecked() == true)
				{
					sem = 1;
				}
				else if (radioButtonGPAadvice1_7.isChecked() == true)
				{
					sem = 2;
				}
				else if (radioButtonGPAadvice1_8.isChecked() == true)
				{
					sem = 3;
				}
				else if (radioButtonGPAadvice1_9.isChecked() == true)
				{
					sem = 4;
				}
				else
				{
					DisplayToast("There is a bug");
				}
				
				Intent intent = new Intent();
				
				
				String str_no_of_credit_taken_current_sem = editTextGPAadvice1_2.getText().toString();
				double no_of_credit_taken_current_sem = Double.parseDouble(str_no_of_credit_taken_current_sem);
				String str_targetCGA = editTextGPAadvice1_1.getText().toString();
				double targetCGA = Double.parseDouble(str_targetCGA);
				
				//transfer info to advice2.java
	         	//The minus 1 operation did in advice2 when calling function to calculate
				intent.putExtra ("year", year);
	         	intent.putExtra ("sem", sem);
	         	intent.putExtra ("no_of_credit_taken_current_sem", no_of_credit_taken_current_sem);
	         	intent.putExtra ("targetCGA", targetCGA);
	         	
						
				
				//DisplayToast("year = " + year);
				//DisplayToast("sem = " + sem);
				//DisplayToast("courseCode = " + courseCode);
				//DisplayToast("credit = " + credit);
				//DisplayToast("grade = " + grade);
				//DisplayToast("courseCode = " + MainActivity.student1.courseRecord[0][0][0][0]);
				//DisplayToast("credit = " + MainActivity.student1.courseRecord[0][0][0][1]);
				//DisplayToast("grade = " + MainActivity.student1.courseRecord[0][0][0][2]);
				
				//DisplayToast("This course record is added!");
				
				
				intent.setClass(advice1.this, advice2.class);
	            startActivity(intent);  
				
     		}
		});
	 
		
		//Clear selected item on that page
		buttonGPAadvice1_2.setOnClickListener(new Button.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {

	        	 
		        //Clear selected item on that page	        	
	        	 	RadioGroupadvice1.clearCheck();
	        	 	RadioGroupadvice2.clearCheck();
	             	radioButtonGPAadvice1_1.setChecked(true);
	             	radioButtonGPAadvice1_6.setChecked(true);
	        	 	editTextGPAadvice1_1.setText("");
	        	 	editTextGPAadvice1_2.setText("");
		        	DisplayToast("Cleared");
	        	 
	     	}
	     });
	
	}
	
	public void DisplayToast(String str)  
	{  
	   Toast toast=Toast.makeText(this, str, Toast.LENGTH_LONG);  
	   //toast.setGravity(Gravity.TOP,0,220);  
	   toast.show();  
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
 	EditText editTextGPAadvice1_2;



}