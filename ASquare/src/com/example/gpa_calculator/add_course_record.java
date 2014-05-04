package com.example.gpa_calculator;

import com.example.asquare.R;
import com.example.gpa_calculator.Student;
import com.example.gpa_calculator.MainActivity;







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
		
		
		//Year1-5
		final RadioGroup RadioGroupGPAadd1=(RadioGroup)findViewById(R.id.RadioGroupGPAadd1); 
		final RadioButton radioButtonGPAadd1 = (RadioButton)findViewById(R.id.radioButtonGPAadd1);
		final RadioButton radioButtonGPAadd2 = (RadioButton)findViewById(R.id.radioButtonGPAadd2);
		final RadioButton radioButtonGPAadd3 = (RadioButton)findViewById(R.id.radioButtonGPAadd3);
		final RadioButton radioButtonGPAadd4 = (RadioButton)findViewById(R.id.radioButtonGPAadd4);
		final RadioButton radioButtonGPAadd5 = (RadioButton)findViewById(R.id.radioButtonGPAadd5);
		
		//Fall Winter Spring Summer
		final RadioGroup RadioGroupGPAadd2=(RadioGroup)findViewById(R.id.RadioGroupGPAadd2);
		final RadioButton radioButtonGPAadd6 = (RadioButton)findViewById(R.id.radioButtonGPAadd6);
		final RadioButton radioButtonGPAadd7 = (RadioButton)findViewById(R.id.radioButtonGPAadd7);
		final RadioButton radioButtonGPAadd8 = (RadioButton)findViewById(R.id.radioButtonGPAadd8);
		final RadioButton radioButtonGPAadd9 = (RadioButton)findViewById(R.id.radioButtonGPAadd9);
 	 
 	    //Course Code, no. of credit, grade
 	    final EditText editTextGPAadd1 = (EditText)findViewById(R.id.editTextGPAadd1);
 	    final EditText editTextGPAadd2 = (EditText)findViewById(R.id.editTextGPAadd2);
 	    final EditText editTextGPAadd3 = (EditText)findViewById(R.id.editTextGPAadd3);

 	    //radioButtonGPAadd1.setChecked(true);
 	    //radioButtonGPAadd6.setChecked(true);
		
 	    RadioGroupGPAadd1.check(R.id.radioButtonGPAadd1);
		RadioGroupGPAadd2.check(R.id.radioButtonGPAadd6);
 	    
		//editTextGPAadd1.setText("COMP1001");
		//editTextGPAadd2.setText("3");
		//editTextGPAadd3.setText("A+");
 	    
		//ref Advanced_activity
 	    

	
	
 	    //add next course record
		buttonGPAadd1.setOnClickListener(new Button.OnClickListener(){ 
			@Override
        	public void onClick(View v) {
				
				//get all input and pass to insertCourseRecord in student.java
			
				int year = -1;//dummy
				int sem = -1;//dummy
				
				if (radioButtonGPAadd1.isChecked() == true)
				{
					year = 1;
				}
				else if (radioButtonGPAadd2.isChecked() == true)
				{
					year = 2;
				}
				else if (radioButtonGPAadd3.isChecked() == true)
				{
					year = 3;
				}
				else if (radioButtonGPAadd4.isChecked() == true)
				{
					year = 4;
				}
				else if (radioButtonGPAadd5.isChecked() == true)
				{
					year = 5;
				}
				else
				{
					DisplayToast("There is a bug");
				}
				
				
				if (radioButtonGPAadd6.isChecked() == true)
				{
					sem = 1;
				}
				else if (radioButtonGPAadd7.isChecked() == true)
				{
					sem = 2;
				}
				else if (radioButtonGPAadd8.isChecked() == true)
				{
					sem = 3;
				}
				else if (radioButtonGPAadd9.isChecked() == true)
				{
					sem = 4;
				}
				else
				{
					DisplayToast("There is a bug");
				}

				String courseCode = editTextGPAadd1.getText().toString();
				String credit = editTextGPAadd2.getText().toString();
				String grade = editTextGPAadd3.getText().toString();
				
				//public static Student_android student1;
				
				MainActivity.student1.insertCourseRecord(year-1, sem-1, courseCode, credit, grade);
        	
				//DisplayToast("year = " + year);
				//DisplayToast("sem = " + sem);
				//DisplayToast("courseCode = " + courseCode);
				//DisplayToast("credit = " + credit);
				//DisplayToast("grade = " + grade);
				//DisplayToast("courseCode = " + MainActivity.student1.courseRecord[1][1][0][0]);
				//DisplayToast("credit = " + MainActivity.student1.courseRecord[1][1][0][1]);
				//DisplayToast("grade = " + MainActivity.student1.courseRecord[1][1][0][2]);
				//DisplayToast("courseCode = " + MainActivity.student1.courseRecord[year-1][sem-1][0][0]);
				//DisplayToast("credit = " + MainActivity.student1.courseRecord[year-1][sem-1][0][1]);
				//DisplayToast("grade = " + MainActivity.student1.courseRecord[year-1][sem-1][0][2]);
				
				
				DisplayToast("This course record is added!"); 
        	
	        	//Clear selected item on that page	        	
	        	RadioGroupGPAadd1.clearCheck();
	        	RadioGroupGPAadd2.clearCheck();
	     	    radioButtonGPAadd1.setChecked(true);
	     	    radioButtonGPAadd6.setChecked(true);
	        	editTextGPAadd1.setText("");
	        	editTextGPAadd2.setText("");
	        	editTextGPAadd3.setText("");
     		}
		});
	 
		//Finish adding new record
		buttonGPAadd2.setOnClickListener(new Button.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	        	 
	        	 //go back previous page
	        	 
		         DisplayToast("Back to Function Page");
	        	 finish();
	         }
	     
		});
		
		//Clear selected item on that page
		buttonGPAadd3.setOnClickListener(new Button.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {
	        	 
	        	//Clear selected item on that page	        	
	        	RadioGroupGPAadd1.clearCheck();
	        	RadioGroupGPAadd2.clearCheck();
	        	//radioButtonGPAadd1.setChecked(true);
	    		//radioButtonGPAadd6.setChecked(true);
	     	    RadioGroupGPAadd1.check(R.id.radioButtonGPAadd1);
	    		RadioGroupGPAadd2.check(R.id.radioButtonGPAadd6);
	        	editTextGPAadd1.setText("");
	        	editTextGPAadd2.setText("");
	        	editTextGPAadd3.setText("");
	        	DisplayToast("Cleared");
	        		        	
	         }
	     });
	  
	}
	
	public void DisplayToast(String str)  
	{  
	   Toast toast=Toast.makeText(this, str, Toast.LENGTH_LONG);  
	   toast.setGravity(Gravity.TOP,0,220);  
	   toast.show();  
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