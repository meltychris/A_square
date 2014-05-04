package com.example.gpa_calculator;


import com.example.asquare.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	//This is the main page in GPA function, thus define here
	static Student student1 = new Student();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gpa_main);
		
		//View My Courses
		ButtonGPAmain1 = (Button)findViewById(R.id.ButtonGPAmain1);
		//Academic Advices
		ButtonGPAmain2 = (Button)findViewById(R.id.ButtonGPAmain2);
		//Add Course Record
		ButtonGPAmain3 = (Button)findViewById(R.id.ButtonGPAmain3);
		//Delete All Course Record
		ButtonGPAmain4 = (Button)findViewById(R.id.ButtonGPAmain4);
		//My TGA
		ButtonGPAmain5 = (Button)findViewById(R.id.ButtonGPAmain5);
		//My CGA
		ButtonGPAmain6 = (Button)findViewById(R.id.ButtonGPAmain6);
		//My GGA
		ButtonGPAmain7 = (Button)findViewById(R.id.ButtonGPAmain7);
		
		//View My Courses
		ButtonGPAmain1.setOnClickListener(new View.OnClickListener() {

	            @Override
	            public void onClick(View view) {
	            	
	                //count = listView.getAdapter().getCount();
	            	Intent intent = new Intent();
	            	intent.setClass(MainActivity.this, print_course_record.class);
	                startActivity(intent);
	                


	            }
	            
	     
	            
	        });
		
		//Academic Advices
		ButtonGPAmain2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            	
                //count = listView.getAdapter().getCount();
            	Intent intent = new Intent();
            	intent.setClass(MainActivity.this, advice1.class);
                startActivity(intent);
                


            }
            
     
            
        });
		
		//Add Course Record
		ButtonGPAmain3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            	
                //count = listView.getAdapter().getCount();
            	Intent intent = new Intent();
            	intent.setClass(MainActivity.this, add_course_record.class);
                startActivity(intent);
                


            }
            
     
            
        });
		
		//ref: http://toimy.blogspot.hk/2010/08/android-alertdialog.html
		//Delete All Course Record
		ButtonGPAmain4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            	
	   			 Builder MyAlertDialog = new AlertDialog.Builder(MainActivity.this);
	   			 MyAlertDialog.setTitle("Re-confirmation");
	   			 MyAlertDialog.setMessage("Do you want delete all course records?");
	   			 
	   			 
	   			 //建立按下按鈕
	   			 DialogInterface.OnClickListener YesClick = new DialogInterface.OnClickListener()
	   			 {
	   				 public void onClick(DialogInterface dialog, int which) {
	   					 //如果不做任何事情 就會直接關閉 對話方塊
	   					 
	   					 //execute del all course record
	   					 MainActivity.student1.resetAllRecord();
	   				 }
	   			 };
	   			 
	   			 DialogInterface.OnClickListener NoClick = new DialogInterface.OnClickListener()
	   			 {
	   				 public void onClick(DialogInterface dialog, int which) {
	   					 //如果不做任何事情 就會直接關閉 對話方塊
	   					 
	   					 //Nothing to do
	   				 }
	   			 };
	   			 
	   			 MyAlertDialog.setPositiveButton("Yes",YesClick );
	   			 MyAlertDialog.setNegativeButton("No",NoClick );
	   			 MyAlertDialog.show();
                


            }
            
     
            
        });
		
		//My TGA
		ButtonGPAmain5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            	
            	
            	Intent intent = new Intent();
            	intent.setClass(MainActivity.this, printTGA.class);
                startActivity(intent);
            }
            
     
            
        });
		
		//My CGA
		ButtonGPAmain6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            	
            	
	            	 Builder MyAlertDialog = new AlertDialog.Builder(MainActivity.this);
	            	 MyAlertDialog.setTitle("Your CGA");
	            	 MyAlertDialog.setMessage(MainActivity.student1.printCGA());
	            	 DialogInterface.OnClickListener OkClick = new DialogInterface.OnClickListener()
	            	 {
	            		 public void onClick(DialogInterface dialog, int which) {
	            			//如果不做任何事情 就會直接關閉 對話方塊
	            			//Nothing to do 
	            		 }
	            	 };;
	            	 
	            	 MyAlertDialog.setNeutralButton("OK",OkClick );
	            	 MyAlertDialog.show();
                

            }
            
     
            
        });
		
		//My GGA
		ButtonGPAmain7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            	

	           	 Builder MyAlertDialog = new AlertDialog.Builder(MainActivity.this);
	           	 MyAlertDialog.setTitle("Your GGA");
	           	 MyAlertDialog.setMessage(MainActivity.student1.printGGA());
	           	 DialogInterface.OnClickListener OkClick = new DialogInterface.OnClickListener()
	           	 {
	           		 public void onClick(DialogInterface dialog, int which) {
	           			//如果不做任何事情 就會直接關閉 對話方塊
	           			//Nothing to do 
	           		 }
	           	 };;
	           	 
	           	 MyAlertDialog.setNeutralButton("OK",OkClick );
	           	 MyAlertDialog.show();
                


            }
            
     
            
        });
		

		
	}
	
	

	Button ButtonGPAmain1;
	Button ButtonGPAmain2;
	Button ButtonGPAmain3;
	Button ButtonGPAmain4;
	Button ButtonGPAmain5;
	Button ButtonGPAmain6;
	Button ButtonGPAmain7;
}
