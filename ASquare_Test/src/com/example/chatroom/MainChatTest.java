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
import android.test.suitebuilder.annotation.SmallTest;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainChatTest extends ActivityInstrumentationTestCase2<MainChat> {


	public MainChatTest() {
		super(MainChat.class);
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
		mActivity = getActivity();  
		assertNotNull(getActivity()); 
	 } 
	
	@SmallTest 
	 public void testPeterChat() { 
		
		mActivity = getActivity();  
		PeterChat = (TextView)mActivity.findViewById(R.id.PeterChat);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ChatroomActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      PeterChat.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  ChatroomActivity nextActivity = (ChatroomActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
	 }
	
	@SmallTest 
	 public void testPeterHelp() { 
		
		mActivity = getActivity();  
		PeterHelp = (TextView)mActivity.findViewById(R.id.PeterHelp);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ChatHelpActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      PeterHelp.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  ChatHelpActivity nextActivity = (ChatHelpActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
	 }
	
	@SmallTest 
	 public void testKenChat() { 
		
		mActivity = getActivity();  
		KenChat = (TextView)mActivity.findViewById(R.id.KenChat);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ChatroomActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      KenChat.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  ChatroomActivity nextActivity = (ChatroomActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
	 }
	
	@SmallTest 
	 public void testKenHelp() { 
		
		mActivity = getActivity();  
		KenHelp = (TextView)mActivity.findViewById(R.id.KenHelp);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ChatHelpActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      KenHelp.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  ChatHelpActivity nextActivity = (ChatHelpActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
	 }
	
	@SmallTest 
	 public void testBrianChat() { 
		
		mActivity = getActivity();  
		BrianChat = (TextView)mActivity.findViewById(R.id.BrianChat);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ChatroomActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      BrianChat.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  ChatroomActivity nextActivity = (ChatroomActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
	 }
	
	@SmallTest 
	 public void testBrianHelp() { 
		
		mActivity = getActivity();  
		BrianHelp = (TextView)mActivity.findViewById(R.id.BrianHelp);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ChatHelpActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      BrianHelp.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  ChatHelpActivity nextActivity = (ChatHelpActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
	 }
	
	@SmallTest 
	 public void testMaryChat() { 
		
		mActivity = getActivity();  
		MaryChat = (TextView)mActivity.findViewById(R.id.MaryChat);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ChatroomActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      MaryChat.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  ChatroomActivity nextActivity = (ChatroomActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
	 }
	
	@SmallTest 
	 public void testMaryHelp() { 
		
		mActivity = getActivity();  
		MaryHelp = (TextView)mActivity.findViewById(R.id.MaryHelp);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ChatHelpActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      MaryHelp.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  ChatHelpActivity nextActivity = (ChatHelpActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
	 }
	
	@SmallTest 
	 public void testAlanChat() { 
		
		mActivity = getActivity();  
		AlanChat = (TextView)mActivity.findViewById(R.id.AlanChat);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ChatroomActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      AlanChat.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  ChatroomActivity nextActivity = (ChatroomActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
	 }
	
	@SmallTest 
	 public void testAlanHelp() { 
		
		mActivity = getActivity();  
		AlanHelp = (TextView)mActivity.findViewById(R.id.AlanHelp);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ChatHelpActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      AlanHelp.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  ChatHelpActivity nextActivity = (ChatHelpActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
	 }
	
	@SmallTest 
	 public void testChrisChat() { 
		
		mActivity = getActivity();  
		ChrisChat = (TextView)mActivity.findViewById(R.id.ChrisChat);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ChatroomActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      ChrisChat.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  ChatroomActivity nextActivity = (ChatroomActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
	 }
	
	@SmallTest 
	 public void testChrisHelp() { 
		mActivity = getActivity();  
		ChrisHelp = (TextView)mActivity.findViewById(R.id.ChrisHelp);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ChatHelpActivity.class.getName(), null, false);

		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			      ChrisHelp.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  ChatHelpActivity nextActivity = (ChatHelpActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
	 }
	
	private MainChat mActivity;
	TextView PeterChat;
	TextView KenChat;
	TextView BrianChat;
	TextView MaryChat;
	TextView PeterHelp;
	TextView KenHelp;
	TextView BrianHelp;
	TextView MaryHelp;

	TextView AlanChat;
	TextView ChrisChat;
	TextView AlanHelp;
	TextView ChrisHelp;
	
}
