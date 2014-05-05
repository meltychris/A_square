package com.example.study_path.test;

import com.example.asquare.R;
import com.example.study_path.Advanced_Activity;
import com.example.study_path.Advanced_Activity_choose;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Advanced_Activity_Test extends ActivityInstrumentationTestCase2<Advanced_Activity> {

	Advanced_Activity mActivity;
	Button button1;
	 RadioButton Major1;
    RadioButton Major2;
	    CheckBox Pure;
	    RadioButton Year1;
	    RadioButton Year2;
	    RadioButton Year3;
	    RadioButton Sem1;
	    RadioButton Sem2;
	    EditText Credit;
	    CheckBox SA;
	    CheckBox S_T;
	    CheckBox A_H;
	    CheckBox Free;
	    CheckBox SBM;
	    CheckBox ENGG;
	    CheckBox FreeE;
	    RadioButton compx1;
	    RadioButton compx2;
	    RadioButton compx3;
	    RadioButton compx4;
	    RadioButton compx5;
	    RadioButton CEMx1;
	    RadioButton CEMx2;
	
	public Advanced_Activity_Test() {
		super(Advanced_Activity.class);

	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  

	    button1 = (Button)mActivity.findViewById(R.id.button1);
	    Major1 = (RadioButton)mActivity.findViewById(R.id.radioButton10);
 	   Major2 = (RadioButton)mActivity.findViewById(R.id.radioButton2);
 	    Pure = (CheckBox)mActivity.findViewById(R.id.checkBox1);
 	     Year1 = (RadioButton)mActivity.findViewById(R.id.year1);
 	     Year2 = (RadioButton)mActivity.findViewById(R.id.year2);
 	     Year3 = (RadioButton)mActivity.findViewById(R.id.year3);
 	     Sem1 = (RadioButton)mActivity.findViewById(R.id.fall);
 	     Sem2 = (RadioButton)mActivity.findViewById(R.id.spring);
 	     Credit = (EditText)mActivity.findViewById(R.id.editText1);
 	     SA = (CheckBox)mActivity.findViewById(R.id.SA);
 	     S_T = (CheckBox)mActivity.findViewById(R.id.S_T);
 	     A_H = (CheckBox)mActivity.findViewById(R.id.A_H);
 	     Free = (CheckBox)mActivity.findViewById(R.id.Free);
 	     SBM = (CheckBox)mActivity.findViewById(R.id.SBM);
 	     ENGG = (CheckBox)mActivity.findViewById(R.id.ENGG);
 	     FreeE = (CheckBox)mActivity.findViewById(R.id.FreeE);
 	     compx1 = (RadioButton)mActivity.findViewById(R.id.compx1);
 	     compx2 = (RadioButton)mActivity.findViewById(R.id.compx2);
 	     compx3 = (RadioButton)mActivity.findViewById(R.id.compx3);
 	     compx4 = (RadioButton)mActivity.findViewById(R.id.compx4);
 	     compx5 = (RadioButton)mActivity.findViewById(R.id.compx5);
 	     CEMx1 = (RadioButton)mActivity.findViewById(R.id.CEMx1);
 	     CEMx2 = (RadioButton)mActivity.findViewById(R.id.CEMx2);
	}
	
	@Override 
	 protected void tearDown() throws Exception { 
		 //this method is called every time after any test execution 
		 // we want to clean the texts 
		 super.tearDown(); 
	 } 


	@UiThreadTest // SmallTest: this test doesn't interact with any file system or network. 
	 public void testView() { // checks if the activity is created 
		assertNotNull(getActivity()); 
	 } 
	
	
	
	@MediumTest 
	 public void testbutton1() { 
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Advanced_Activity_choose.class.getName(), null, false);

		//INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      button1.performClick();
			    }
			  });	
		//CHECK THE RESULT
		  Advanced_Activity_choose nextActivity = (Advanced_Activity_choose) getInstrumentation().waitForMonitor(activityMonitor);
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
     	
		  nextActivity.finish();

	 }
	
}

