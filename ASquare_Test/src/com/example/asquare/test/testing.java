package com.example.asquare.test;

import com.example.asquare.MainActivity;
import com.example.asquare.R;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.ImageButton;

public class testing extends ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mActivity;
	ImageButton button1;
	ImageButton button2;
	ImageButton button3;
	ImageButton button4;
	ImageButton button5;
	ImageButton button6;
	
	@SuppressWarnings("deprecation")
	public testing() {
	super("com.example.asquare",MainActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	
		mActivity = (MainActivity) getActivity();  
		
		button1 = (ImageButton)mActivity.findViewById(R.id.imageButton1);;
		button2 = (ImageButton)mActivity.findViewById(R.id.imageButton2);;
		button3 = (ImageButton)mActivity.findViewById(R.id.imageButton3);;
		button4 = (ImageButton)mActivity.findViewById(R.id.imageButton4);;
		button5 = (ImageButton)mActivity.findViewById(R.id.imageButton5);;
		button6 = (ImageButton)mActivity.findViewById(R.id.imageButton6);;
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
	 public void button1_Test() { 
		// register next activity that need to be monitored.
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(com.example.gpa_calculator.MainActivity.class.getName(), null, false);

		
		 /* INTERACTIONS */ 
		 TouchUtils.tapView(this, button1); 	// tap the EditText textKilos 
		 
		 /*CHECK THE RESULT*/ 
		 com.example.gpa_calculator.MainActivity nextActivity = (com.example.gpa_calculator.MainActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
		  // next activity is opened and captured.
		  assertNotNull(nextActivity);
		  nextActivity .finish();
	 }
}
