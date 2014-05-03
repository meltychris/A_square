package com.example.study_path.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Instrumentation.ActivityMonitor;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.asquare.R;
import com.example.study_path.Advanced_Activity;
import com.example.study_path.Advanced_Activity2;
import com.example.study_path.Advanced_Activity_choose;
import com.example.study_path.Model;



public class Advanced_Activity_choose_Test extends ActivityInstrumentationTestCase2<Advanced_Activity_choose> {

	Advanced_Activity_choose mActivity;
	
	Button button1;

	/*Boolean Major1;
	Boolean Major2;
	Boolean Pure;
	Boolean Year1;
	Boolean Year2;
	Boolean Year3;
	Boolean Sem1;
	Boolean Sem2;
	String Credit;
	Boolean SA;
	Boolean S_T;
	Boolean A_H;
	Boolean Free;
	Boolean SBM;
	Boolean ENGG;
	Boolean FreeE;
	Boolean compx1;
	Boolean compx2;
	Boolean compx3;
	Boolean compx4;
	Boolean compx5;
	Boolean CEMx1;
	Boolean CEMx2;*/
	
   ListView listView;
     ArrayAdapter<Model> adapter;
    List<Model> list = new ArrayList<Model>();
    Button btn;

	
	public Advanced_Activity_choose_Test() {
		super(Advanced_Activity_choose.class);

	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();



	}
	
	@Override 
	 protected void tearDown() throws Exception { 
		 //this method is called every time after any test execution 
		 // we want to clean the texts 
		 super.tearDown(); 
	 } 


	@SmallTest // SmallTest: this test doesn't interact with any file system or network. 
	 public void testView() { // checks if the activity is created 
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
     	
		setActivityIntent(intent) ;
		mActivity = getActivity();  
        listView = (ListView) mActivity.findViewById(R.id.my_list);
        btn = (Button) mActivity.findViewById(R.id.submit);

        
		assertNotNull(getActivity()); 
	 } 
	
	
	
	@SmallTest 
	 public void testbtn() { 
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
     	
		setActivityIntent(intent) ;
		mActivity = getActivity();  
        listView = (ListView) mActivity.findViewById(R.id.my_list);
        btn = (Button) mActivity.findViewById(R.id.submit);

		//INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      btn.performClick();
			    }
			  });	
		//CHECK THE RESULT
		  ActivityMonitor activityMonitor2 = getInstrumentation().addMonitor(Advanced_Activity2.class.getName(), null, false);
		  Advanced_Activity2 nextActivity = (Advanced_Activity2) getInstrumentation().waitForMonitorWithTimeout(activityMonitor2, 50000);
		  assertNotNull(nextActivity);
		assertTrue(nextActivity.getIntent().hasExtra("Major1"));
     	assertTrue(nextActivity.getIntent().hasExtra("Major2"));
     	assertTrue(nextActivity.getIntent().hasExtra("Pure"));
     	assertTrue(nextActivity.getIntent().hasExtra("Year1"));
     	assertTrue(nextActivity.getIntent().hasExtra("Year2"));
     	assertTrue(nextActivity.getIntent().hasExtra("Year3"));
     	assertTrue(nextActivity.getIntent().hasExtra("Sem1"));
     	assertTrue(nextActivity.getIntent().hasExtra("Sem2"));
     	assertTrue(nextActivity.getIntent().hasExtra("Credit"));
     	assertTrue(nextActivity.getIntent().hasExtra("SA"));
     	assertTrue(nextActivity.getIntent().hasExtra("S_T"));
     	assertTrue(nextActivity.getIntent().hasExtra("A_H"));
     	assertTrue(nextActivity.getIntent().hasExtra("Free"));
     	assertTrue(nextActivity.getIntent().hasExtra("SBM"));
     	assertTrue(nextActivity.getIntent().hasExtra("ENGG"));
     	assertTrue(nextActivity.getIntent().hasExtra("FreeE"));
     	assertTrue(nextActivity.getIntent().hasExtra("compx1"));
     	assertTrue(nextActivity.getIntent().hasExtra("compx2"));
     	assertTrue(nextActivity.getIntent().hasExtra("compx3"));
     	assertTrue(nextActivity.getIntent().hasExtra("compx4"));
     	assertTrue(nextActivity.getIntent().hasExtra("compx5"));
     	assertTrue(nextActivity.getIntent().hasExtra("CEMx1"));
     	assertTrue(nextActivity.getIntent().hasExtra("CEMx2"));
     	assertTrue(nextActivity.getIntent().hasExtra("Course"));
     	assertTrue(nextActivity.getIntent().hasExtra("Checked"));
     	
		  nextActivity.finish();

	 }
	
}
