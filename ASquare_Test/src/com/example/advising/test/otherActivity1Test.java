package com.example.advising.test;

import com.example.advising.otherActivity1;
import com.example.advising.otherActivity2;
import com.example.asquare.R;

import android.app.Instrumentation.ActivityMonitor;
import android.content.Intent;
import android.content.IntentFilter;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;


public class  otherActivity1Test  extends	ActivityInstrumentationTestCase2<otherActivity1> {

	// 2.Change MainActivity
	private  otherActivity1 mActivity;

	// 3.Change MainActivity
	public  otherActivity1Test() {
		super( otherActivity1.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();
		button1 = (Button) mActivity.findViewById(R.id.button1);
		button2 = (Button) mActivity.findViewById(R.id.button2);

	}

	@Override
	protected void tearDown() throws Exception {
		// this method is called every time after any test execution
		// we want to clean the texts
		super.tearDown();
	}

	@MediumTest
	// MediumTest: this test doesn't interact with any file system or network.
	public void testView() { // checks if the activity is created
		assertNotNull(getActivity());
	}
/*
	@UiThreadTest
	public void testbutton1() {

    	mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button1.performClick();
			}
		});	


	}*/
	
	@MediumTest
	public void testbutton2() {
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				otherActivity2.class.getName(), null, false);

		// INTERACTIONS
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button2.performClick();
			}
		});

		// CHECK THE RESULT
		otherActivity2 nextActivity = (otherActivity2) getInstrumentation().waitForMonitor(activityMonitor);
		assertNotNull(nextActivity);
		nextActivity.finish();

	}

	
	
	Button button1;
	Button button2;


}
