package com.example.study_path.test;


import java.io.IOException;

import com.example.asquare.R;
import com.example.exam_count_down.DataBaseUtility2;
import com.example.study_path.Advanced_Activity;
import com.example.study_path.Advanced_Activity2;
import com.example.study_path.DataBaseHelper1;
import com.example.study_path.DataBaseUtility1;
import com.example.study_path.Study_Path;

import android.app.Instrumentation.ActivityMonitor;
import android.content.SharedPreferences;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;

public class Study_Path_Test extends ActivityInstrumentationTestCase2<Study_Path> {

	Study_Path mActivity;
	private Button button1;
    private Button button2;
    private Button button3;
    Button button111;
    private ListView listView1;
    private View view1;
    private View view2;
    private View view3;
    RadioButton radioButton1;
    RadioButton radioButton2;
    CheckBox checkbox1;
    
	public Study_Path_Test() {
		super(Study_Path.class);

	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
        Log.d("  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"); 

		mActivity = getActivity();  
		button1 = (Button)mActivity.findViewById(R.id.button1);
		button2 = (Button)mActivity.findViewById(R.id.button2);
		button3 = (Button)mActivity.findViewById(R.id.button3);
		button111 = (Button)mActivity.findViewById(R.id.button111);
		checkbox1 = (CheckBox)mActivity.findViewById(R.id.checkBox1);
		listView1 = (ListView)mActivity.findViewById(R.id.listView1);
		view1 = (View)mActivity.findViewById(R.id.View1);
		view2 = (View)mActivity.findViewById(R.id.View2);
		view3 = (View)mActivity.findViewById(R.id.View3);
		radioButton1 = (RadioButton)mActivity.findViewById(R.id.radioButton10);
		radioButton2 = (RadioButton)mActivity.findViewById(R.id.radioButton2);
	}
	
	@Override 
	 protected void tearDown() throws Exception { 

		 //this method is called every time after any test execution 
		 // we want to clean the texts 
		 super.tearDown(); 
	 } 

	@SmallTest // SmallTest: this test doesn't interact with any file system or network. 
	 public void testView() throws Exception { // checks if the activity is created 

		assertNotNull(getActivity()); 
	 } 
	
	@SmallTest 
	public void testOnCreate() throws Exception {

		assertFalse(view1.isShown());
		assertFalse(view2.isShown());
		assertFalse(view3.isShown());
		assertEquals("COMP",mActivity.getMajor());
		assertEquals("1",mActivity.getYear());
		assertEquals("T",mActivity.getPure());
	 }
	
	@SmallTest 
	 public void testradiobutton1() throws Exception  { 

		for (int tempyear=1; tempyear <=3 ; tempyear++){
			mActivity.setYear(Integer.toString(tempyear));
			 //INTERACTIONS
			mActivity.runOnUiThread(new Runnable() {
				 @Override
				 public void run() {
					 radioButton1.performClick();
				 }
			});	
			  
			ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);
			getInstrumentation().waitForMonitorWithTimeout(activityMonitor,10000);
		

	
			//CHECK THE RESULT
			assertTrue(radioButton1.isChecked());
			assertFalse(radioButton2.isChecked());
			assertEquals("COMP",mActivity.getMajor());
			if (mActivity.getYear().equals("1"))
				assertTrue(view1.isShown());
			else if (mActivity.getYear().equals("2"))
				assertTrue(view2.isShown());
	      	else
				assertTrue(view3.isShown());
		}
	} 
	
	
	@SmallTest 
	public void testradiobutton2() throws Exception  { 

		for (int tempyear=1; tempyear <=3 ; tempyear++){
			mActivity.setYear(Integer.toString(tempyear));
			//INTERACTIONS
			mActivity.runOnUiThread(new Runnable() {
				 @Override
				 public void run() {
					 radioButton2.performClick();
				 }
			});	
	
			ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);
			getInstrumentation().waitForMonitorWithTimeout(activityMonitor,10000);

			 //CHECK THE RESULT
			assertTrue(radioButton2.isChecked());
			assertFalse(radioButton1.isChecked());
			assertEquals("CPEG",mActivity.getMajor());
			if (mActivity.getYear().equals("1"))
				assertTrue(view1.isShown());
			else if (mActivity.getYear().equals("2"))
				assertTrue(view2.isShown());
	     	else
				assertTrue(view3.isShown());
		}
	} 
	
	@SmallTest 
	public void testcheckbox1() throws Exception  { 
		mActivity.setPure("T");
		//INTERACTIONS
		mActivity.runOnUiThread(new Runnable() {
			 @Override
			 public void run() {
				 checkbox1.performClick();
			 }
		});	
	
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor,10000);
		
		 //CHECK THE RESULT
		assertEquals("F",mActivity.getPure());

		mActivity.setPure("F");
		//INTERACTIONS
		mActivity.runOnUiThread(new Runnable() {
			 @Override
			 public void run() {
				 checkbox1.performClick();
			 }
		});	


		 //CHECK THE RESULT
		assertEquals("T",mActivity.getPure());
	} 

	@UiThreadTest
	public void testbutton1() throws Exception  {
		//INTERACTIONS
		
		mActivity.runOnUiThread(new Runnable() {
			 @Override
			 public void run() {
				 button1.performClick();
			 }
		});	
		
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor,10000);

		 //CHECK THE RESULT
		assertTrue(view1.isShown());
		assertFalse(view2.isShown());
		assertFalse(view3.isShown());
		assertEquals("1",mActivity.getYear());
	}
	
	@UiThreadTest
	public void testbutton2() throws Exception  {

		//INTERACTIONS
		mActivity.runOnUiThread(new Runnable() {
			 @Override
			 public void run() {
				 button2.performClick();
			 }
		});	

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor,10000);
		
		//CHECK THE RESULT
		assertFalse(view1.isShown());
		assertTrue(view2.isShown());
		assertFalse(view3.isShown());
		assertEquals("2",mActivity.getYear());
	}
	
	@UiThreadTest
	public void testbutton3() throws Exception  {
		//INTERACTIONS
		mActivity.runOnUiThread(new Runnable() {
			 @Override
			 public void run() {
				 button3.performClick();
			 }
		});	

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor,10000);
		
		 //CHECK THE RESULT
		assertFalse(view1.isShown());
		assertFalse(view2.isShown());
		assertTrue(view3.isShown());
		assertEquals("3",mActivity.getYear());
	}
	
	@SmallTest 
	 public void testbutton111true()  throws Exception { 
	
		  SharedPreferences xadvanced = mActivity.getSharedPreferences("advanced", 0);
		  xadvanced.edit().putBoolean("advanced", false).commit();


		//INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      button111.performClick();
			    }
			  });	
		//CHECK THE RESULT
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Advanced_Activity.class.getName(), null, false);
		  Advanced_Activity nextActivity = (Advanced_Activity) getInstrumentation().waitForMonitor(activityMonitor);
	

		  assertNotNull(nextActivity);
		  nextActivity.finish();

	 }
	
	@SmallTest 
	 public void testbutton111false()  throws Exception { 

		  SharedPreferences xadvanced = mActivity.getSharedPreferences("advanced", 0);
		  xadvanced.edit().putBoolean("advanced", true).commit();


		//INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      button111.performClick();
			    }
			  });	
		//CHECK THE RESULT
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Advanced_Activity2.class.getName(), null, false);
		  Advanced_Activity2 nextActivity = (Advanced_Activity2) getInstrumentation().waitForMonitor(activityMonitor);
	

		  
		  assertNotNull(nextActivity);
		  nextActivity.finish();

	 }
	
	@SmallTest 
	 public void testlistView1() throws Exception  { 
		//precondition
		//assertFalse(mActivity.getToastshown());
		
		//INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      button1.performClick();
			    }
			  });	

		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	listView1.performItemClick(
			    		    listView1.getAdapter().getView(0, null, null), 0, 0);	
			    }
		  });	
			ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);
			getInstrumentation().waitForMonitorWithTimeout(activityMonitor,10000);
		

		 //CHECK THE RESULT 
		 assertTrue(mActivity.getToastshown());
		 
	 }
	
	@SmallTest 
	 public void testDataBaseHelper1() throws Exception  { 
		//initial
		DataBaseHelper1 a = new DataBaseHelper1(mActivity);
		
		//INTERACTIONS
		try {
			a.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		a.onCreate(null);
		a.onUpgrade(null, 0, 0);
		a.openDataBase();
		a.close();
		 //CHECK THE RESULT 
		 
	 }
	
	@SmallTest
	public void testother() throws Exception {
	      DataBaseUtility1.ShowMessageBox(mActivity, "AA");

	}
		
}

