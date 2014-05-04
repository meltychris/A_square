package com.example.gpa_calculator.test;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
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
	
	//see http://stackoverflow.com/questions/17526005/how-to-test-an-alertdialog-in-android
	@SmallTest
	public void testButtonGPAmain4() { 
		
		//TODO
		
		//add record
		MainActivity.student1.courseRecord[1][1][0][0] = "COMP1001";
		MainActivity.student1.courseRecord[1][1][0][1] = "3";
		MainActivity.student1.courseRecord[1][1][0][2] = "A";
		
		//INTERACTIONS 
		 mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	// click button and open next activity
			    	
			    	//no clicking for dialog test, dont ask me why
			    	//ButtonGPAmain4.performClick();
			    	
			    	
			    	AlertDialog dialog = mActivity.createAndShowAlertDialogButtonGPAmain4();
			    	//click Yes!
			    	//dialog.show();
			    	dialog.getButton(DialogInterface.BUTTON_POSITIVE).performClick();

			    }
			  });	
		  
		 //CHECK THE RESULT
	
	
		 ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);
		 getInstrumentation().waitForMonitorWithTimeout(activityMonitor,2000);
		
		String testing0 = MainActivity.student1.courseRecord[1][1][0][0];
		String testing1 = MainActivity.student1.courseRecord[1][1][0][1];
		String testing2 = MainActivity.student1.courseRecord[1][1][0][2];
		assertEquals(null, testing0);
		assertEquals(null, testing1);
		assertEquals(null, testing2);
		
		//if do this, null pointer exception, dont know why
		//assertTrue(MainActivity.student1.courseRecord[1][1][0][0].equals(null));

		
		
	}

/*	
	@MediumTest
	public void testButtonGPAmain4() {
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

		//add record
		MainActivity.student1.courseRecord[1][1][0][0] = "COMP1001";
		MainActivity.student1.courseRecord[1][1][0][1] = "3";
		MainActivity.student1.courseRecord[1][1][0][2] = "A";
		
	    TouchUtils.clickView(this, ButtonGPAmain4);

	    MainActivity myActivity = (MainActivity) activityMonitor.waitForActivityWithTimeout(2000);
	    //assertNotNull("MyActivity activity not started, activity is null", myActivity);

	    final AlertDialog dialog = myActivity.createAndShowAlertDialogButtonGPAmain4(); // I create getLastDialog method in MyActivity class. Its return last created AlertDialog
	    
	    if (dialog.isShowing())
	    {
	        try
	        {
	        	runTestOnUiThread(new Runnable()
	        	{

	        		@Override
	        	    public void run()
	        		{  	
	        			//dialog.show();
	        			//button.performClick()
	        			dialog.getButton(DialogInterface.BUTTON_POSITIVE).performClick();
	        	    }
	        	});
	        	
	        	getInstrumentation().waitForIdleSync();
	        	    
	        }
	        catch (Throwable e) 
	        {
	            e.printStackTrace();
	        }
	    }
	    
	    //assertTrue(MainActivity.student1.courseRecord[1][1][0][0].equals("COMP1001"));
	    
	    assertTrue((MainActivity.student1.courseRecord[1][1][0][0].equals(null)) &&
	    			(MainActivity.student1.courseRecord[1][1][0][1].equals(null)) &&
	    			(MainActivity.student1.courseRecord[1][1][0][2].equals(null))
	    		);
	    
	    
	    
	    myActivity.finish();
	    getInstrumentation().removeMonitor(activityMonitor);

	}
*/
	
	
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
	
	//ref testButtonGPAmain4
	//running 2nd branch, else if (CGA_without_1st_sem < 1.5), in MainActivity.printCGA()
	@SmallTest
	public void testButtonGPAmain6_1() { 
	
		//TODO
		
		//INTERACTIONS 
		 mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	// click button and open next activity
			    	
			    	
			    	//ButtonGPAmain6.performClick();
			    	
			    	AlertDialog dialog = mActivity.createAndShowAlertDialogButtonGPAmain6();
			    	//click Yes!
			    	//dialog.show();
			    	//dialog.getButton(DialogInterface.BUTTON_POSITIVE).performClick();
			    	assertTrue(dialog.isShowing());
			    	
			    	dialog.dismiss();
			    }
			  });	
		  
		 //CHECK THE RESULT
	
	
		 ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);
		 getInstrumentation().waitForMonitorWithTimeout(activityMonitor,2000);
		

	}
	
	//ref testButtonGPAmain4
	//running 1st branch, if ( ( CGA >= 1.5 ) && ( CGA < 1.7 ) ), in MainActivity.printCGA()
	@SmallTest
	public void testButtonGPAmain6_2() { 
	
		//TODO
		
		MainActivity.student1.CGA =  1.6;
		
		//INTERACTIONS 
		 mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	// click button and open next activity
			    	
			    	
			    	//ButtonGPAmain6.performClick();
			    	
			    	AlertDialog dialog = mActivity.createAndShowAlertDialogButtonGPAmain6();
			    	//click Yes!
			    	//dialog.show();
			    	//dialog.getButton(DialogInterface.BUTTON_POSITIVE).performClick();
			    	assertTrue(dialog.isShowing());
			    	
			    	dialog.dismiss();
			    }
			  });	
		  
		 //CHECK THE RESULT
	
	
		 ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);
		 getInstrumentation().waitForMonitorWithTimeout(activityMonitor,2000);
		

	}
	
	//ref testButtonGPAmain4
	//running 3rd branch, last else, in MainActivity.printCGA()
	@SmallTest
	public void testButtonGPAmain6_3() { 
	
		//TODO
		
		MainActivity.student1.CGA =  1.8;
		//add record
		MainActivity.student1.courseRecord[0][1][0][0] = "COMP1001";
		MainActivity.student1.courseRecord[0][1][0][1] = "3";
		MainActivity.student1.courseRecord[0][1][0][2] = "A";
		
		
		
		//INTERACTIONS 
		 mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	// click button and open next activity
			    	
			    	
			    	//ButtonGPAmain6.performClick();
			    	
			    	AlertDialog dialog = mActivity.createAndShowAlertDialogButtonGPAmain6();
			    	//click Yes!
			    	//dialog.show();
			    	//dialog.getButton(DialogInterface.BUTTON_POSITIVE).performClick();
			    	assertTrue(dialog.isShowing());
			    	
			    	dialog.dismiss();
			    }
			  });	
		  
		 //CHECK THE RESULT
	
	
		 ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);
		 getInstrumentation().waitForMonitorWithTimeout(activityMonitor,2000);
		

	}
	
	//ref testButtonGPAmain4
	@SmallTest
	public void testButtonGPAmain7() { 
	
		//TODO
		
		//INTERACTIONS 
		 mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	// click button and open next activity
			    	
			    	
			    	//ButtonGPAmain7.performClick();
			    	
			    	
			    	AlertDialog dialog = mActivity.createAndShowAlertDialogButtonGPAmain7();
			    	//click Yes!
			    	//dialog.show();
			    	//dialog.getButton(DialogInterface.BUTTON_POSITIVE).performClick();
			    	assertTrue(dialog.isShowing());
			    	
			    	dialog.dismiss();
			    }
			  });	
		  
		 //CHECK THE RESULT
	
	
		 ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);
		 getInstrumentation().waitForMonitorWithTimeout(activityMonitor,2000);
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
