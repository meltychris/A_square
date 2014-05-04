package com.example.gpa_calculator.test;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Context;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.Button;

import com.example.asquare.R;
// com.example.gpa_calculator.GPAactivity2;
import com.example.gpa_calculator.MainActivity;
import com.example.gpa_calculator.add_course_record;
import com.example.gpa_calculator.advice1;
import com.example.gpa_calculator.printTGA;
import com.example.gpa_calculator.print_course_record;

//1.Change the things inside <XXXX>
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	//2.Change MainActivity
	private MainActivity mActivity;

	//3.Change MainActivity
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  
		ButtonGPAmain1 = (Button)mActivity.findViewById(R.id.ButtonGPAmain1);
		ButtonGPAmain2 = (Button)mActivity.findViewById(R.id.ButtonGPAmain2);
		ButtonGPAmain3 = (Button)mActivity.findViewById(R.id.ButtonGPAmain3);
		ButtonGPAmain4 = (Button)mActivity.findViewById(R.id.ButtonGPAmain4);
		ButtonGPAmain5 = (Button)mActivity.findViewById(R.id.ButtonGPAmain5);
		ButtonGPAmain6 = (Button)mActivity.findViewById(R.id.ButtonGPAmain6);
		ButtonGPAmain7 = (Button)mActivity.findViewById(R.id.ButtonGPAmain7);

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
	public void testButtonGPAmain1() { 
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(print_course_record.class.getName(), null, false);

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	ButtonGPAmain1.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		 print_course_record nextActivity = (print_course_record) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 20000);
		 assertNotNull(nextActivity);
		 nextActivity.finish();

	}
	
	@SmallTest
	public void testButtonGPAmain2() { 
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(advice1.class.getName(), null, false);

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	ButtonGPAmain2.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  advice1 nextActivity = (advice1) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 20000);
		 assertNotNull(nextActivity);
		 nextActivity.finish();
	}
	
	@SmallTest
	public void testButtonGPAmain3() { 
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(add_course_record.class.getName(), null, false);

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	ButtonGPAmain3.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  add_course_record nextActivity = (add_course_record) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 20000);
		 assertNotNull(nextActivity);
		 nextActivity.finish();
	}
	
	@SmallTest
	public void testButtonGPAmain4() { 
		
		//TODO
		assertFalse(true);
		
		
	}
	
	@SmallTest
	public void testButtonGPAmain5() { 
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(printTGA.class.getName(), null, false);

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	ButtonGPAmain5.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  printTGA nextActivity = (printTGA) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 20000);
		 assertNotNull(nextActivity);
		 nextActivity.finish();
	}
	
	@SmallTest
	public void testButtonGPAmain6() { 
	
		//TODO
		
		//INTERACTIONS 
		mActivity.runOnUiThread(new Runnable() {
			   @Override
			   public void run() {
			     // click button and open next activity.
			    	ButtonGPAmain6.performClick();
			    }
		});
		  
		  
/*		
		AlertDialog myAlertDialog = new AlertDialog(MainActivity.this);

		if(!MyAlertDialog.isShowing())
		{  
			MyAlertDialog.show(); 
		}
		
		
		
		DialogCredits dialog  = new DialogCredits(this); 

		if(!dialog.isShowing())
		{  
		    dialog.show(); 
		}
*/		
		//assertFalse(true);
	}
	
	@SmallTest
	public void testButtonGPAmain7() { 
	
		//TODO
		assertFalse(true);
	}
/*	
	public class DialogCredits extends Dialog
	{

	    public DialogCredits(Context context) {
	        super(context);
	    }

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        setTitle(R.string.dialog_credits_title);
	        setContentView(R.layout.dialog_credits);

	        final Dialog d = this;

	        Button buttonOk = (Button) findViewById(R.id.dialog_credits_button_ok);
	        buttonOk.setOnClickListener(new View.OnClickListener() {            
	            public void onClick(View v) {
	                // close dialog
	                d.dismiss();            
	            }
	        });
	            
	    }

	}
*/	
	Button ButtonGPAmain1;
	Button ButtonGPAmain2;
	Button ButtonGPAmain3;
	Button ButtonGPAmain4;
	Button ButtonGPAmain5;
	Button ButtonGPAmain6;
	Button ButtonGPAmain7;
	
}
