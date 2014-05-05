package com.example.schedule.test;

import com.example.asquare.MainActivity;
import com.example.asquare.R;
import com.example.chatroom.MainChat;
import com.example.chatroom.MentorMain;
import com.example.exam_count_down.Exam_countdown;
import com.example.schedule.CalendarView;
import com.example.study_path.Study_Path;

import android.app.AlertDialog;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CalendarViewTest extends ActivityInstrumentationTestCase2<CalendarView> {

	private CalendarView mActivity;
	Button button1;
	EditText editText1;
	TextView textView101;
	RelativeLayout previous;
	RelativeLayout next;
	GridView gridview;
	
	public CalendarViewTest() {
		super(CalendarView.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  

		gridview = (GridView) mActivity.findViewById(R.id.gridview);
		previous = (RelativeLayout) mActivity.findViewById(R.id.previous);
		editText1 = (EditText) mActivity.findViewById(R.id.editText1);
		textView101 = (TextView) mActivity.findViewById(R.id.textView101);
		button1 = (Button) mActivity.findViewById(R.id.button1);
		next = (RelativeLayout) mActivity.findViewById(R.id.next);
	}
	
	@Override 
	 protected void tearDown() throws Exception { 
		 //this method is called every time after any test execution 
		 // we want to clean the texts 
		 super.tearDown(); 
	 } 


	@MediumTest // MediumTest: this test doesn't interact with any file system or network. 
	 public void testView() { // checks if the activity is created 

		assertNotNull(getActivity()); 
	 } 
	
	@UiThreadTest 
	 public void testgridview() { 
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			  		gridview.performClick();
			    }
			  });	
		  
	 }
	
	@UiThreadTest 
	 public void testbutton1() { 
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			  		editText1.setText("18");
			  		button1.performClick();
			    }
			  });	
		  
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			  		editText1.setText("");
			  		button1.performClick();
			    }
			  });	
		  
	 }
	
	
	@UiThreadTest
	 public void testnext() { 
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			  		next.performClick();
			    }
			  });	
		  
	 }
	
}
