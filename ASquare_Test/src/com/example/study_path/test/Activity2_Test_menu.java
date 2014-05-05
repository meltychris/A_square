package com.example.study_path.test;


import android.app.Instrumentation.ActivityMonitor;
import android.content.ClipData.Item;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.asquare.R;
import com.example.study_path.Advanced_Activity;
import com.example.study_path.Advanced_Activity2;


public class Activity2_Test_menu extends ActivityInstrumentationTestCase2<Advanced_Activity2> {

	Advanced_Activity2 mActivity;
	Button button1;
	Button button2;
	View view1;
	View view2;
	ListView listView1;


	
	public Activity2_Test_menu() {
		super(Advanced_Activity2.class);

	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	
		Intent intent = new Intent();
     	
     	intent.putExtra ("Major1", true);
     	intent.putExtra ("Major2", false);
     	intent.putExtra ("Pure", false);
     	intent.putExtra ("Year1", true);
     	intent.putExtra ("Year2", false);
     	intent.putExtra ("Year3", false);
     	intent.putExtra ("Sem1",true);
     	intent.putExtra ("Sem2",false);
     	intent.putExtra ("Credit", "18");
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


	@SmallTest // SmallTest: this test doesn't interact with any file system or network. 
	 public void testView() { // checks if the activity is created 
		assertNotNull(getActivity()); 
	 } 
	
	
	
	@SmallTest 
	 public void testM() { 

		getInstrumentation().invokeMenuActionSync(mActivity, R.id.year1, 0);

		getInstrumentation().invokeMenuActionSync(mActivity, R.id.menu_delete, 0);

	//CHECK THE RESULT

		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Advanced_Activity.class.getName(), null, false);
		  Advanced_Activity nextactivity = (Advanced_Activity) getInstrumentation().waitForMonitor(activityMonitor);
		  
		  assertNotNull(nextactivity);
		  nextactivity.finish();
		  
	
      	

	 }
	

}
