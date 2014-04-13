package com.example.asquare.test;

import com.example.asquare.MainActivity;
import com.example.asquare.R;
import com.example.exam_count_down.Exam_countdown;
import com.example.study_path.Study_Path;

import android.app.AlertDialog;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.DialogInterface;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity_Test extends ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mActivity;
	ImageButton button1;
	ImageButton button2;
	ImageButton button3;
	ImageButton button4;
	ImageButton button5;
	ImageButton button6;
	
	public MainActivity_Test() {
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  
		button1 = (ImageButton)mActivity.findViewById(R.id.imageButton1);
		button2 = (ImageButton)mActivity.findViewById(R.id.imageButton2);
		button3 = (ImageButton)mActivity.findViewById(R.id.imageButton3);
		button4 = (ImageButton)mActivity.findViewById(R.id.imageButton4);
		button5 = (ImageButton)mActivity.findViewById(R.id.imageButton5);
		button6 = (ImageButton)mActivity.findViewById(R.id.imageButton6);
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
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(com.example.gpa_calculator.MainActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      button1.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  com.example.gpa_calculator.MainActivity nextActivity = (com.example.gpa_calculator.MainActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
		  assertNotNull(nextActivity);
		  nextActivity.finish();

	 }
	
	@SmallTest
	 public void testbutton2() { 
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      button2.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  Study_Path nextActivity = (Study_Path) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
		  assertNotNull(nextActivity);
		  nextActivity.finish();

	 }
	

	
	@SmallTest 
	 public void testbutton3() { 
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Exam_countdown.class.getName(), null, false);

		//INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      button3.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT 
		  Exam_countdown nextActivity = (Exam_countdown) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
		  assertNotNull(nextActivity);
		  nextActivity.finish();

	 }
	
	@SmallTest 
	 public void testbutton4() { 
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      button4.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT 
		  MainActivity nextActivity = (MainActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
		  assertNotNull(nextActivity);
		  nextActivity.finish();

	 }
	
	@SmallTest  
	 public void testbutton5() { 
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      button5.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  MainActivity nextActivity = (MainActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
		  assertNotNull(nextActivity);
		  nextActivity.finish();

	 }
	
	@SmallTest 
	 public void testbutton6() { 
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      button6.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  MainActivity nextActivity = (MainActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
		  assertNotNull(nextActivity);
		  nextActivity.finish();

	 }
	
	@SmallTest 
	 public void testonkeydown() { 
		// register next activity that need to be monitored.
		Instrumentation inst = getInstrumentation();
		ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

		// INTERACTIONS 
		inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);

		  
		 //CHECK THE RESULT 
		AlertDialog dialog = mActivity.isExit; 
		assertTrue(dialog.isShowing());			//test if dialog is opened
		
	    if (dialog.isShowing()) {
	        try {
	            performClick(dialog.getButton(DialogInterface.BUTTON_NEGATIVE));
	    		assertFalse(mActivity.isFinishing());
	        	
	            performClick(dialog.getButton(DialogInterface.BUTTON_POSITIVE));
	    		assertTrue(mActivity.isFinishing());

	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
	    }

	    mActivity.finish();
	    getInstrumentation().removeMonitor(monitor);
	 }
	
	private void performClick(final Button button) throws Throwable {
	    runTestOnUiThread(new Runnable() {
	        @Override
	        public void run() {
	            button.performClick();
	        }
	    });
	    getInstrumentation().waitForIdleSync();
	}
}
