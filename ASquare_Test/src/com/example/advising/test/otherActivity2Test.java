package com.example.advising.test;

import com.example.advising.otherActivity2;
import com.example.asquare.R;

import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Intent;
import android.content.IntentFilter;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.KeyEvent;
import android.widget.Button;


public class  otherActivity2Test  extends	ActivityInstrumentationTestCase2<otherActivity2> {

	// 2.Change MainActivity
	private  otherActivity2 mActivity;

	// 3.Change MainActivity
	public  otherActivity2Test() {
		super( otherActivity2.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();
		button3 = (Button) mActivity.findViewById(R.id.button3);

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
	public void testbutton3() {
	   

		
	       Instrumentation instr = getInstrumentation(); 
           IntentFilter callFilter = new IntentFilter(Intent.ACTION_CALL); 

           callFilter.addCategory(Intent.CATEGORY_DEFAULT); 

           Instrumentation.ActivityMonitor monitor = 
instr.addMonitor(callFilter, null, true); 

           ActivityMonitor mMonitor = new ActivityMonitor(callFilter, null, false);


           mActivity.runOnUiThread( 
                           new Runnable() { 

                                   public void run() { 
                       				button3.performClick();

                                   } 
                           } 
           ); 
           
           getInstrumentation().addMonitor(mMonitor);

           this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER); 
           assertEquals(1, monitor.getHits()); 


	    

		


	}*/

	
	
	Button button3;

}
