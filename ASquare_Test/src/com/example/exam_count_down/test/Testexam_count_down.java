package com.example.exam_count_down.test;

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
	
	@SuppressWarnings("deprecation")
	public Testexam_count_down() {
	super("com.example.exam_count_down",Exam_countdown.class);
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
		    	Code.setText("COMP3111");
		    	Date.setText("2014/02/30");
		    	button1.performClick();
		    	}
		  	});	
		int expectedCount = listView1.getAdapter().getCount() - 1;

		 //INTERACTIONS 
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      Code.setText("COMP3111");
			      button2.performClick();
			    }
			  });	
		  
		  int actualCount = listView1.getAdapter().getCount();
	  
		 //CHECK THE RESULT 
	      assertEquals(expectedCount, actualCount);

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
		int expectedCount = 0;
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
		  String expectedinput = "COMP3111\t2014/02/30";
		  String actualinput = listView1.getChildAt(0).toString();	  
		 //CHECK THE RESULT 
	      assertEquals(expectedinput, actualinput);

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
		  
		 //CHECK THE RESULT
		  assertEquals("COMP3111",Code.getText());


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
		  assertEquals("2014/01/01",Code.getText());

	 }
}
