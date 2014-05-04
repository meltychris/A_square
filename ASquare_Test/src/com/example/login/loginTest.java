package com.example.login;

import com.example.asquare.MainActivity;
import com.example.asquare.R;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;

public class loginTest extends ActivityInstrumentationTestCase2<LoginActivity> {

	public loginTest() {
		super(LoginActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  
		edit_password = (EditText) mActivity.findViewById(R.id.edit_password);
		edit_username = (EditText) mActivity.findViewById(R.id.edit_username);
		Login = (Button) mActivity.findViewById(R.id.Login);
		
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
	 public void testLogin_success() { 
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);
		
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			  		edit_password.setText("STSK");
					edit_username.setText("STSK");
			      Login.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  MainActivity nextActivity = (MainActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
	 }
	
	@SmallTest 
	 public void testLogin_fail() { 
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

		
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
					edit_password.setText("STSK");
					edit_username.setText("STSK1");
			      Login.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  MainActivity nextActivity = (MainActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		  assertNull(nextActivity);
	 }
	
	private LoginActivity mActivity;
	String user;
	String password;
	EditText edit_password;
	EditText edit_username;
	Button Login;
}
