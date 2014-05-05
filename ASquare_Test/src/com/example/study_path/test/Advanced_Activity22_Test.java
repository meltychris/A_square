package com.example.study_path.test;


import android.app.Instrumentation.ActivityMonitor;
import android.content.Intent;
import android.content.SharedPreferences;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.asquare.R;
import com.example.study_path.Advanced_Activity2;


public class Advanced_Activity22_Test extends ActivityInstrumentationTestCase2<Advanced_Activity2> {

	Advanced_Activity2 mActivity;
	Button button1;
	Button button2;
	View view1;
	View view2;
	ListView listView1;


	
	public Advanced_Activity22_Test() {
		super(Advanced_Activity2.class);

	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	
		Intent intent = new Intent();
     	
     	intent.putExtra ("Major1", true);
     	intent.putExtra ("Major2", false);
     	intent.putExtra ("Pure", false);
     	intent.putExtra ("Year1", false);
     	intent.putExtra ("Year2", true);
     	intent.putExtra ("Year3", false);
     	intent.putExtra ("Sem1",true);
     	intent.putExtra ("Sem2",false);
     	intent.putExtra ("Credit", "0");
     	intent.putExtra ("SA", false);
     	intent.putExtra ("S_T", true);
     	intent.putExtra ("A_H", false);
     	intent.putExtra ("Free", true);
     	intent.putExtra ("SBM", false);
     	intent.putExtra ("ENGG", false);
     	intent.putExtra ("FreeE", false);
     	intent.putExtra ("compx1", true);
     	intent.putExtra ("compx2", false);
     	intent.putExtra ("compx3", false);
     	intent.putExtra ("compx4", false);
     	intent.putExtra ("compx5", false);
     	intent.putExtra ("CEMx1", false);
     	intent.putExtra ("CEMx2", false);

     	String[] course = {"COMP3111","COMP1004"};
     	String[] checked = {"false", "true"};
    	intent.putExtra ("Course", course);
    	intent.putExtra ("Checked", checked);
     	
		setActivityIntent(intent) ;
		mActivity = getActivity();  
		 SharedPreferences xadvanced = mActivity.getSharedPreferences("advanced", 0);
		  xadvanced.edit().putBoolean("advanced", false).commit();
	    button1 = (Button)mActivity.findViewById(R.id.button1);
	    button2 = (Button)mActivity.findViewById(R.id.button2);
       	view1 = (View) mActivity.findViewById(R.id.View1);
    	view2 = (View) mActivity.findViewById(R.id.View2);
	    listView1 = (ListView)mActivity.findViewById(R.id.listView1);
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
	
	
	
	@UiThreadTest 
	 public void testbutton1() { 
		try{

			//INTERACTIONS
			  mActivity.runOnUiThread(new Runnable() {
				    @Override
				    public void run() {
				      // click button and open next activity.
				    	button1.performClick();
				    }
				  });	
			  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Advanced_Activity2.class.getName(), null, false);
			  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
			  
			//CHECK THE RESULT
	
	      	assertTrue(view1.isShown());
	      	assertFalse(view2.isShown());
	  		
	  		assertTrue(listView1.isEnabled());	
		}
		
		 catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }

	 }
	
	@UiThreadTest 
	 public void testbutton2() { 

		try{
		//INTERACTIONS
			  mActivity.runOnUiThread(new Runnable() {
				    @Override
				    public void run() {
				      // click button and open next activity.
				    	button2.performClick();
				    }
				  });	
			  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Advanced_Activity2.class.getName(), null, false);
			  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
			  
			//CHECK THE RESULT
	
	     	assertFalse(view1.isShown());
	     	assertTrue(view2.isShown());
	 		assertTrue(listView1.isEnabled());	
		}
		 catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	 }
	


}
