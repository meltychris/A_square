package com.example.study_path;

import com.example.asquare.Advanced_Activity2;
import com.example.asquare.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Advanced_Activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.adv_path_main);    
	    button1 = (Button)findViewById(R.id.submit);

	 button1.setOnClickListener(new Button.OnClickListener(){ 
         @Override
         public void onClick(View v) {
             // TODO Auto-generated method stub
     	    RadioButton Major1 = (RadioButton)findViewById(R.id.radioButton1);
     	    RadioButton Major2 = (RadioButton)findViewById(R.id.radioButton2);
     	    CheckBox Pure = (CheckBox)findViewById(R.id.checkBox1);
     	    RadioButton Year1 = (RadioButton)findViewById(R.id.year1);
     	    RadioButton Year2 = (RadioButton)findViewById(R.id.year2);
     	    RadioButton Year3 = (RadioButton)findViewById(R.id.year3);
     	    RadioButton Sem1 = (RadioButton)findViewById(R.id.fall);
     	    RadioButton Sem2 = (RadioButton)findViewById(R.id.spring);
     	    EditText Credit = (EditText)findViewById(R.id.editText1);
     	    CheckBox SA = (CheckBox)findViewById(R.id.SA);
     	    CheckBox S_T = (CheckBox)findViewById(R.id.S_T);
     	    CheckBox A_H = (CheckBox)findViewById(R.id.A_H);
     	    CheckBox Free = (CheckBox)findViewById(R.id.Free);
     	    CheckBox SBM = (CheckBox)findViewById(R.id.SBM);
     	    CheckBox ENGG = (CheckBox)findViewById(R.id.ENGG);
     	    CheckBox FreeE = (CheckBox)findViewById(R.id.FreeE);
     	    RadioButton compx1 = (RadioButton)findViewById(R.id.compx1);
     	    RadioButton compx2 = (RadioButton)findViewById(R.id.compx2);
     	    RadioButton compx3 = (RadioButton)findViewById(R.id.compx3);
     	    RadioButton compx4 = (RadioButton)findViewById(R.id.compx4);
     	    RadioButton compx5 = (RadioButton)findViewById(R.id.compx5);
     	    RadioButton CEMx1 = (RadioButton)findViewById(R.id.CEMx1);
     	    RadioButton CEMx2 = (RadioButton)findViewById(R.id.CEMx2);
     	    EditText Fail = (EditText)findViewById(R.id.Fail);
     	  

     	    
     	    
     	
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
         	intent.putExtra ("Fail", Fail.getText().toString());
         	
         	
             intent.setClass(Advanced_Activity.this, Advanced_Activity2.class);

             startActivity(intent);      
     		}
     });
	}
	
	
	
	 private Button button1;



}
