package com.example.exam_count_down.test;

import com.example.exam_count_down.DataBaseUtility2;
import com.example.exam_count_down.Exam_countdown;
import com.example.study_path.Study_Path;
import com.example.asquare.MainActivity;
import com.example.asquare.R;

import android.app.AlertDialog;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.DialogInterface;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class Testexam_count_down extends ActivityInstrumentationTestCase2<Exam_countdown> {

	private Exam_countdown mActivity;
	Button button1;
	Button button2;
	Button button3;
	ListView listView1;
	EditText Code;
	EditText Date;
	
	public Testexam_count_down() {
		super(Exam_countdown.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	
		mActivity = getActivity();  
		
		button1 = (Button)mActivity.findViewById(R.id.Add);;
		button2 = (Button)mActivity.findViewById(R.id.Delete);;
		button3 = (Button)mActivity.findViewById(R.id.reset);;
		listView1 = (ListView)mActivity.findViewById(R.id.listView1);;
		Code = (EditText)mActivity.findViewById(R.id.Code);;
		Date = (EditText)mActivity.findViewById(R.id.Date);;
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
		 		int expectedCount = listView1.getAdapter().getCount() + 1;

		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      Code.setText("COMP3111");
			      Date.setText("2014/02/30");

			      button1.performClick();
			    }
			  });	
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Exam_countdown.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
		int actualCount = listView1.getAdapter().getCount();

		 //CHECK THE RESULT 
	    assertEquals(expectedCount, actualCount);

	 }
	
	@SmallTest
	 public void testbutton2() { 
		  mActivity.runOnUiThread(new Runnable() {
		    @Override
		    	public void run() {
		      // click button and open next activity.
		    	Code.setText("AAAAAAAAAAAAA");
		    	Date.setText("2014/02/30");
		    	button1.performClick();
		    	}
		  	});	
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Exam_countdown.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
		int expectedCount = listView1.getAdapter().getCount() - 1;

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      Code.setText("AAAAAAAAAAAAA");
			      button2.performClick();
			    }
			  });	
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		  int actualCount = listView1.getAdapter().getCount();
	  
		 //CHECK THE RESULT 
	      assertEquals(expectedCount, actualCount);

	      
	 }
	
	@SmallTest 
		 public void testlistView1() { 
			//Still doing
		
			mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      Code.setText("COMP3111");
			      Date.setText("2014/02/30");
			      button1.performClick();
			    }
			  });	
			  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Exam_countdown.class.getName(), null, false);
			  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
			  String expectedinput = "COMP3111\t\t\t\t\t2014/02/30";
			  String actualinput = listView1.getAdapter().getItem(0).toString();
		 
			 //CHECK THE RESULT 
		      assertEquals(expectedinput, actualinput);
	
		 }

	
	

	
	@SmallTest 
	 public void testbutton3() { 

		//INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      button3.performClick();
			    }
			  });	
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Exam_countdown.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
		int expectedCount = 0;
		int actualCount = listView1.getAdapter().getCount();
	  
		 //CHECK THE RESULT 
	    assertEquals(expectedCount, actualCount);

	 }
	
	@SmallTest  
	 public void testCode() { 


		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {

			    @Override
			    public void run() {
			      // click button and open next activity.
			      Code.setText("COMP3111");
			    }
			  });	
		  
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Exam_countdown.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);

		  
		 //CHECK THE RESULT
		  assertEquals("COMP3111",Code.getText().toString());


	 }
	
	@SmallTest 
	 public void testDate() { 


		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      Date.setText("2014/01/01");
			    }
			  });	
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Exam_countdown.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		  assertEquals("2014/01/01",Date.getText().toString());

	 }
	
	@SmallTest
	public void testother(){
	      DataBaseUtility2.ShowMessageBox(mActivity, "AA");

	}
}
