/*
package com.example.gpa_calculator.test;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Context;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.asquare.R;
// com.example.gpa_calculator.GPAactivity2;
import com.example.gpa_calculator.MainActivity;
import com.example.gpa_calculator.add_course_record;
import com.example.gpa_calculator.advice1;
import com.example.gpa_calculator.printTGA;
import com.example.gpa_calculator.print_course_record;
import com.example.gpa_calculator.advice2;

//1.Change the things inside <XXXX>
public class advice2Test extends ActivityInstrumentationTestCase2<advice2> {

	//2.Change MainActivity
	private advice2 mActivity;

	//3.Change MainActivity
	public advice2Test() {
		super(advice2.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  
		//Exit
		buttonGPAadvice2_1 = (Button)mActivity.findViewById(R.id.buttonGPAadvice2_1);
		
		//this text view will show the advised TGA
		textViewGPAadvice2_3 = (TextView)mActivity.findViewById(R.id.textViewGPAadvice2_3);

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

	@SmallTest
	public void testButtonGPAadvice2_1() { 
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(print_course_record.class.getName(), null, false);

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	buttonGPAadvice2_1.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		 print_course_record nextActivity = (print_course_record) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 20000);
		 assertNotNull(nextActivity);
		 nextActivity.finish();

	}
	

	 Button buttonGPAadvice2_1; 
	 TextView textViewGPAadvice2_3;
	
}
*/