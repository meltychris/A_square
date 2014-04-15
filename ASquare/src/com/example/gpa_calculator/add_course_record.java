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
		
		
		
		//ref Advanced_activity
	
	
		buttonGPAadd1.setOnClickListener(new Button.OnClickListener(){ 
         @Override
         public void onClick(View v) {
             // TODO Auto-generated method stub
     	    RadioButton radioButtonGPAadd1 = (RadioButton)findViewById(R.id.radioButtonGPAadd1);
     	    RadioButton radioButtonGPAadd2 = (RadioButton)findViewById(R.id.radioButtonGPAadd2);
     	    RadioButton radioButtonGPAadd3 = (RadioButton)findViewById(R.id.radioButtonGPAadd3);
     	    RadioButton radioButtonGPAadd4 = (RadioButton)findViewById(R.id.radioButtonGPAadd4);
     	    RadioButton radioButtonGPAadd5 = (RadioButton)findViewById(R.id.radioButtonGPAadd5);
     	    RadioButton radioButtonGPAadd6 = (RadioButton)findViewById(R.id.radioButtonGPAadd6);
     	    RadioButton radioButtonGPAadd7 = (RadioButton)findViewById(R.id.radioButtonGPAadd7);
     	    RadioButton radioButtonGPAadd8 = (RadioButton)findViewById(R.id.radioButtonGPAadd8);
     	    RadioButton radioButtonGPAadd9 = (RadioButton)findViewById(R.id.radioButtonGPAadd9);
     	 
     	    
     	    EditText editTextGPAadd1 = (EditText)findViewById(R.id.editTextGPAadd1);
     	    EditText editTextGPAadd2 = (EditText)findViewById(R.id.editTextGPAadd2);
     	    EditText editTextGPAadd3 = (EditText)findViewById(R.id.editTextGPAadd3);

     	    //NOT yet change below, ref Advanced_activity!!!!!!!!!!!!!!!!!!
     	    
     	
         	Intent intent = new Intent();
         	
         	intent.putExtra ("Major1", Major1.isChecked());
         	intent.putExtra ("Major2", Major2.isChecked());
         	intent.putExtra ("Pure", Pure.isChecked());
         	intent.putExtra ("Year1", Year1.isChecked());
         	intent.putExtra ("Year2", Year2.isChecked());
         	intent.putExtra ("Year3", Year3.isChecked());
         	intent.putExtra ("Sem1", Sem1.isChecked());
         	intent.putExtra ("Sem2", Sem2.isChecked());
         	intent.putExtra ("Credit", Credit.getText().toString());
         	intent.putExtra ("SA", SA.isChecked());
         	intent.putExtra ("S_T", S_T.isChecked());
         	intent.putExtra ("A_H", A_H.isChecked());
         	intent.putExtra ("Free", Free.isChecked());
         	intent.putExtra ("SBM", SBM.isChecked());
         	intent.putExtra ("ENGG", ENGG.isChecked());
         	intent.putExtra ("FreeE", FreeE.isChecked());
         	intent.putExtra ("compx1", compx1.isChecked());
         	intent.putExtra ("compx2", compx2.isChecked());
         	intent.putExtra ("compx3", compx3.isChecked());
         	intent.putExtra ("compx4", compx4.isChecked());
         	intent.putExtra ("compx5", compx5.isChecked());
         	intent.putExtra ("CEMx1", CEMx1.isChecked());
         	intent.putExtra ("CEMx2", CEMx2.isChecked());
         	
         	
             //intent.setClass(Advanced_Activity.this, Advanced_Activity2.class);
         	
         	//not yet modify
            intent.setClass(Advanced_Activity.this, Advanced_Activity_choose.class);

             startActivity(intent);      
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
	
	
	
	 private Button buttonGPAadd1;
	 private Button buttonGPAadd2; 
	 private Button buttonGPAadd3; 


}