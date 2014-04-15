package com.example.gpa_calculator.test;


import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;

import com.example.asquare.R;
import com.example.gpa_calculator.GPAactivity2;
import com.example.gpa_calculator.MainActivity;
import com.example.gpa_calculator.print_course_record;


//1.Change the things inside <XXXX>
public class MainActivity_Test extends ActivityInstrumentationTestCase2<MainActivity> {

	//2.Change MainActivity
	private MainActivity mActivity;

	//3.Change MainActivity
	public MainActivity_Test() {
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  
		ButtonGPAmain1 = (Button)mActivity.findViewById(R.id.ButtonGPAmain1);

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
	 public void testButtonGPAmain1() { 
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(print_course_record.class.getName(), null, false);

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	ButtonGPAmain1.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  print_course_record nextActivity = (print_course_record) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
		  assertNotNull(nextActivity);
		  nextActivity.finish();

	 }
	Button ButtonGPAmain1;
	
}
