package com.example.gpa_calculator.test;


import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;

import com.example.asquare.R;
import com.example.gpa_calculator.GPAactivity2;
import com.example.gpa_calculator.GPAactivity3;


//1.Change the things inside <XXXX>
public class GPAactivity2_Test extends ActivityInstrumentationTestCase2<GPAactivity2> {

	//2.Change MainActivity
	private GPAactivity2 mActivity;

	//3.Change MainActivity
	public GPAactivity2_Test() {
		super(GPAactivity2.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  
		button1 = (Button)mActivity.findViewById(R.id.button1);
		
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
	 public void testbutton1() { 
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(GPAactivity3.class.getName(), null, false);

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      button1.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  GPAactivity3 nextActivity = (GPAactivity3) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
		  assertNotNull(nextActivity);
		  nextActivity.finish();

	 }
	Button button1;

}
