package com.example.manual.test;

import com.example.asquare.MainActivity;
import com.example.asquare.R;
import com.example.manual.ManualMainActivity;
import com.example.study_path.Advanced_Activity;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class manualTest extends ActivityInstrumentationTestCase2<ManualMainActivity> {

	public manualTest() {
		super(ManualMainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  
        myBrowser=(WebView)mActivity.findViewById(R.id.mybrowser);

		
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
	
	@MediumTest 
	 public void testWebView() { 
		  assertNotNull(myBrowser.isShown());
	 }
	
	
	
	private ManualMainActivity mActivity;
	WebView myBrowser;
}
