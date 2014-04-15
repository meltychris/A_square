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
		
		//Next
		buttonGPAadvice1_1 = (Button)findViewById(R.id.buttonGPAadvice1_1);
		//Reset
		buttonGPAadvice1_2 = (Button)findViewById(R.id.buttonGPAadvice1_2);
		
		//ref Advanced_activity
	
	
		buttonGPAadvice1_1.setOnClickListener(new Button.OnClickListener(){ 
         @Override
         public void onClick(View v) {
             // TODO Auto-generated method stub
     	    RadioButton radioButtonGPAadvice1_1 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_1);
     	    RadioButton radioButtonGPAadvice1_2 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_2);
     	    RadioButton radioButtonGPAadvice1_3 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_3);
     	    RadioButton radioButtonGPAadvice1_4 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_4);
     	    RadioButton radioButtonGPAadvice1_5 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_5);
     	    RadioButton radioButtonGPAadvice1_6 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_6);
     	    RadioButton radioButtonGPAadvice1_7 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_7);
     	    RadioButton radioButtonGPAadvice1_8 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_8);
     	    RadioButton radioButtonGPAadvice1_9 = (RadioButton)findViewById(R.id.radioButtonGPAadvice1_9);
     	    
     	    //Your Target TGA
     	    EditText editTextGPAadvice1_1 = (EditText)findViewById(R.id.editTextGPAadvice1_1);
     	  

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
	 
		
		buttonGPAadvice1_2.setOnClickListener(new Button.OnClickListener(){ 
	         @Override
	         public void onClick(View v) {

	        	 
	        	 
	        	 
	        	 
	     		}
	     });
	
	}
	
	 private Button buttonGPAadvice1_1; 
	 private Button buttonGPAadvice1_2; 
	 


}