package com.example.login;

import java.io.File;

import com.example.asquare.MainActivity;
import com.example.asquare.R;
import com.example.manual.ManualMainActivity;
import com.example.study_path.Advanced_Activity;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;
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
		Register = (Button) mActivity.findViewById(R.id.Register);

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
		  MainActivity nextActivity = (MainActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();


	
	 }
	
	@UiThreadTest 
	 public void testLogin_fail() { 
	
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
					edit_password.setText("STSK1");
					edit_username.setText("STSK");
			      Login.performClick();
			    }
			  });	

	 }
	
	@MediumTest 
	 public void testRegister_success() { 
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);
		
		String DB_PATH = "data/data/"+ mActivity.getPackageName()+"/databases/logininfo";
		  try{
	            File file = new File(DB_PATH);
	            file.delete();
	    }catch(Exception ex)
	    {}
		  
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
			  		edit_password.setText("aaaabb");
					edit_username.setText("aaaabb");
			      Register.performClick();
			    }
			  });	
		  
		 //CHECK THE RESULT
		  MainActivity nextActivity = (MainActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  assertNotNull(nextActivity);
		  nextActivity.finish();
		  
		 
	 }
	
	@UiThreadTest 
	 public void testRegister_fail() { 
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			  	@Override
			    public void run() {
			      // click button and open next activity.
					edit_password.setText("Ken");
					edit_username.setText("Ken");
			      Register.performClick();
			    }
			  });	
	
	 }
	
	@MediumTest 
	 public void testMenu() { 

		getInstrumentation().invokeMenuActionSync(mActivity, R.id.year1, 0);		//test for default option
		
		getInstrumentation().invokeMenuActionSync(mActivity, R.id.manual_help, 0);

	//CHECK THE RESULT

		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ManualMainActivity.class.getName(), null, false);
		  ManualMainActivity nextactivity = (ManualMainActivity) getInstrumentation().waitForMonitor(activityMonitor);
		  
		  assertNotNull(nextactivity);
		  nextactivity.finish();
	 }
	
	private LoginActivity mActivity;
	String user;
	String password;
	EditText edit_password;
	EditText edit_username;
	Button Login;
	Button Register;
}
