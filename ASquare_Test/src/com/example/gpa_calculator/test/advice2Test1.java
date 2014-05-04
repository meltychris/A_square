/*
package com.example.gpa_calculator.test;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
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
public class advice2Test1 extends ActivityInstrumentationTestCase2<advice2> {

	//2.Change MainActivity
	private advice2 mActivity;

	//3.Change MainActivity
	public advice2Test1() {
		super(advice2.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	mActivity = getActivity();  
		//Exit
		//buttonGPAadvice2_1 = (Button)mActivity.findViewById(R.id.buttonGPAadvice2_1);
		
		//this text view will show the advised TGA
		textViewGPAadvice2_3 = (TextView)mActivity.findViewById(R.id.textViewGPAadvice2_3);
		
		
		MainActivity.student1.insertCourseRecord(2-1,2-1,"COMP1001", "3", "D");
		
		Intent intent = new Intent();

    	intent.putExtra ("year", 2);
     	intent.putExtra ("sem", 2);
    	intent.putExtra ("targetTGA", 4);

  	setActivityIntent(intent);
//		mActivity = getActivity(); 
		
//		Intent intent = new Intent(getInstrumentation().getTargetContext(), advice2.class);
//		intent.putExtra ("year", 2);
//	    intent.putExtra ("sem", 2);
//	    intent.putExtra ("targetTGA", 4);
//		setActivityIntent(intent);
//		mActivity = getActivity();
		//assertNotNull(mActivity);
		  // do some assert

	}
	
	@Override 
	protected void tearDown() throws Exception { 
		 //this method is called every time after any test execution 
		 // we want to clean the texts 
		 super.tearDown(); 
	} 


	@SmallTest // SmallTest: this test doesn't interact with any file system or network. 
	public void testView() { // checks if the activity is created 
		
		//ref: Advanced)Activity_choose_Test.java
		
		//simulate year2, sem2 have a record
//		MainActivity.student1.insertCourseRecord(2-1,2-1,"COMP1001", "3", "D");
		
//		Intent intent = new Intent();

//     	intent.putExtra ("year", 2);
//    	intent.putExtra ("sem", 2);
//     	intent.putExtra ("targetTGA", 4);

//		setActivityIntent(intent) ;
//		mActivity = getActivity();  
        //listView = (ListView) mActivity.findViewById(R.id.my_list);
        //btn = (Button) mActivity.findViewById(R.id.submit);
		
		
		
		
		assertNotNull(getActivity()); 
	} 

	//testButtonGPAadvice2_1() is done in advice2Test2!
//	@SmallTest
//	public void testButtonGPAadvice2_1() {
//
//	}
	
	
	@SmallTest
	public void testTextViewGPAadvice2_3() {

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity


   	
			    	//buttonGPAadvice1_2.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
	
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(advice2.class.getName(), null, false);
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor,5000);
		 
		 
		// not null not empty
		//ref: http://stackoverflow.com/questions/8976134/android-how-to-check-if-textview-is-null-or-nut
		assertTrue(!(textViewGPAadvice2_3 != null || !textViewGPAadvice2_3.getText().equals("")));

	}

	 //Button buttonGPAadvice2_1; 
	 TextView textViewGPAadvice2_3;
	
}
*/