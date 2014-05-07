package com.example.advising.test;


import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;

import com.example.advising.advising_MainActivity;
import com.example.advising.otherActivity1;
import com.example.advising.ustTeamActivity;
import com.example.asquare.R;

//1.Change the things inside <XXXX>
public class MainActivityTest extends ActivityInstrumentationTestCase2<advising_MainActivity> {

	//2.Change MainActivity
	private advising_MainActivity mActivity;

	//3.Change MainActivity
	public MainActivityTest() {
		super(advising_MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  
		button1 = (Button)mActivity.findViewById(R.id.button1);
		button2 = (Button)mActivity.findViewById(R.id.button2);
	

	}
	
	@Override 
	protected void tearDown() throws Exception { 
		 //this method is called every time after any test execution 
		 // we want to clean the texts 
		 super.tearDown(); 
	} 


	@MediumTest // MediumTest: this test doesn't interact with any file system or network. 
	public void testView() { // checks if the activity is created 
		assertNotNull(getActivity()); 
	} 

	@MediumTest
	public void testButton1() { 
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ustTeamActivity.class.getName(), null, false);

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	button1.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		 ustTeamActivity nextActivity = (ustTeamActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 20000);
		 assertNotNull(nextActivity);
		 nextActivity.finish();

	}
	
	@MediumTest
	public void testButtonGPAmain2() { 
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(otherActivity1.class.getName(), null, false);

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	button2.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  otherActivity1 nextActivity = (otherActivity1) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 20000);
		 assertNotNull(nextActivity);
		 nextActivity.finish();
	}
	


	Button button1;
	Button button2;

	
}
