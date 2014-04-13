package com.example.gpa_calculator.test;


import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;

import com.example.gpa_calculator.MainActivity;


//1.Change the things inside <XXXX>
public class MainActivity_Test extends ActivityInstrumentationTestCase2<MainActivity> {

	//2.Change MainActivity
	private MainActivity mActivity;

	//3.Change MainActivity
	public MainActivity_Test() {
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  
		
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
	 public void testSetUp() throws Exception {
		setUp();
		assertNotNull(mActivity);
	 }

	@SmallTest
	 public void testTearDown() throws Exception {
		tearDown();
		assertNull(mActivity);
		 
	 }
	 

}
