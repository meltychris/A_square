package com.example.gpa_calculator.test;


import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;

import com.example.asquare.R;
import com.example.gpa_calculator.GPAactivity2;
import com.example.gpa_calculator.GPAactivity3;


//1.Change the things inside <XXXX>
public class GPAactivity3_Test extends ActivityInstrumentationTestCase2<GPAactivity3> {

	//2.Change MainActivity
	private GPAactivity3 mActivity;

	//3.Change MainActivity
	public GPAactivity3_Test() {
		super(GPAactivity3.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  
		
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
	

}
