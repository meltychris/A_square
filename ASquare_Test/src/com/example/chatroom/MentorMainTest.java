package com.example.chatroom;

import com.example.asquare.MainActivity;
import com.example.asquare.R;
import com.example.chatroom.MainChat;
import com.example.chatroom.MentorMain;
import com.example.exam_count_down.Exam_countdown;
import com.example.study_path.Study_Path;

import android.app.AlertDialog;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class MentorMainTest extends ActivityInstrumentationTestCase2<MentorMain> {


	public MentorMainTest() {
		super(MentorMain.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  
 		

	    SharedPreferences shareduser = mActivity.getSharedPreferences("user", 0);
 		shareduser.edit().putString("user", "Ken").commit();
 		
		button1 = (Button)mActivity.findViewById(R.id.button1);
	    button2 = (Button)mActivity.findViewById(R.id.button2);
	    Send = (Button)mActivity.findViewById(R.id.Send);
       	view1 = (View) mActivity.findViewById(R.id.View1);
    	view2 = (View) mActivity.findViewById(R.id.View2);
    	view1.setVisibility(View.VISIBLE);
    	view2.setVisibility(View.INVISIBLE);
	    listView = (ListView)mActivity.findViewById(R.id.msgbraod);
	    msg = (EditText)mActivity.findViewById(R.id.msg);

	    //SharedPreferences shareduser = mActivity.getSharedPreferences("user", 0);
 		//user = shareduser.getString("user", "Ken");


	}
	

	
	@Override 
	 protected void tearDown() throws Exception { 
		 //this method is called every time after any test execution 
		 // we want to clean the texts 
		 super.tearDown(); 
	 } 


	@MediumTest // SmallTest: this test doesn't interact with any file system or network. 
	 public void testView() { // checks if the activity is created 
		assertNotNull(getActivity()); 
	 } 
	
	@MediumTest 
	 public void testOnCreate() { 
 		
    	assertTrue(view1.isShown());
    	assertFalse(view2.isShown()); 
	 } 
	
	@MediumTest 
	 public void testbutton1() { 
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MentorMain.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      button1.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		  assertTrue(view1.isShown());
		  assertFalse(view2.isShown()); 
	 }
	
	@MediumTest 
	 public void testbutton2() { 
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MentorMain.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      button2.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		  assertFalse(view1.isShown());
		  assertTrue(view2.isShown()); 
	 }
	
	@MediumTest 
	 public void testSend1() { 

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      Send.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT

	 }
	
	@MediumTest 
	 public void testSend2() { 
		
		
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			  		listView.performItemClick(
			    		    listView.getAdapter().getView(0, null, null), 1, 0);

			    }
			  });	
			ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MentorMain.class.getName(), null, false);
			  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);

		  
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.

			      Send.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT

	 }
	
	@MediumTest 
	 public void testSend3() { 
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MentorMain.class.getName(), null, false);

		
		 //INTERACTIONS
		 mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			  		msg.setText("hi");

			  		listView.performItemClick(
			    		    listView.getAdapter().getView(0, null, null), 0, 0);				    
			 
			    }
			  });	
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);

		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.

			      Send.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		  assertEquals("",msg.getText().toString());
	 }
	
	@MediumTest 
	 public void testSend4andlist() { 
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MentorMain.class.getName(), null, false);
		
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			  		msg.setText("hi");
			  		button2.performClick();
			    }
			  });	
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		  
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      Send.performClick();
			    }
			  });	
		  
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);

		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
					listView.performItemClick(
			    		    listView.getAdapter().getView(0, null, null), 0, 0);						    }
			  });	
		 //CHECK THE RESULT
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		  assertEquals("",msg.getText().toString());
	 }
	

	
	private MentorMain mActivity;
	Button Send;
	ListView listView;
	View view1;
	View view2;
	Button button1;
	Button button2;
	EditText msg;

}
