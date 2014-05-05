package com.example.gpa_calculator.test;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Context;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.asquare.R;
// com.example.gpa_calculator.GPAactivity2;
import com.example.gpa_calculator.MainActivity;
import com.example.gpa_calculator.add_course_record;
import com.example.gpa_calculator.advice1;
import com.example.gpa_calculator.printTGA;
import com.example.gpa_calculator.print_course_record;

//1.Change the things inside <XXXX>
public class printTGATest extends ActivityInstrumentationTestCase2<printTGA> {

	//2.Change MainActivity
	private printTGA mActivity;

	//3.Change MainActivity
	public printTGATest() {
		super(printTGA.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  
		listViewGPAprint1 = (ListView) mActivity.findViewById(R.id.listViewGPAprintTGA1);

	}
	
	@Override 
	protected void tearDown() throws Exception { 
		 //this method is called every time after any test execution 
		 // we want to clean the texts 
		 super.tearDown(); 
	} 


	@SmallTest // SmallTest: this test doesn't interact with any file system or network. 
	public void testView() { // checks if the activity is created 
		assertNotNull(getActivity()); 
	} 

	//empty condition to print
	@SmallTest
	public void testListViewGPAprint1() { 
		

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      
			    	//listViewGPAprint1.performItemClick(listViewGPAprint1.getAdapter().getView(0, null, null), 0, 0);
			    	
			    }
			  });	
		  
		 //CHECK THE RESULT
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(printTGA.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor,1000);
		  
	    //should be empty, give boolean true
		  
		//No need MainActivity.student1.printWarningTGA() != null, as it must not be null, as it is initialized
		//assertTrue(MainActivity.student1.printWarningTGA() == null);
	   // assertTrue(MainActivity.student1.printTGA().isEmpty());

	  

	}

	//have things to print in TGA
	@SmallTest
	public void testListViewGPAprint2() { 
			
		//add record
		MainActivity.student1.courseRecord[1][1][0][0] = "COMP1001";
		MainActivity.student1.courseRecord[1][1][0][1] = "3";
		MainActivity.student1.courseRecord[1][1][0][2] = "D";
		
		
		//INTERACTIONS 
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				      
				 //listViewGPAprint1.performItemClick(listViewGPAprint1.getAdapter().getView(0, null, null), 0, 0);
				    	
			}
		});	
			  
		//CHECK THE RESULT
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(printTGA.class.getName(), null, false);
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor,1000);
			  
		assertFalse(MainActivity.student1.printTGA().isEmpty());

		  

		}	  

	ListView listViewGPAprint1;
	
}
