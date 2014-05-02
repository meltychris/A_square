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
import android.test.suitebuilder.annotation.SmallTest;
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
	 public void testView() { // checks if the activity is created 
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
	 public void testradiobutton1() { 
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);

		for (int tempyear=1; tempyear <=3 ; tempyear++){
			mActivity.setYear(Integer.toString(tempyear));
			 //INTERACTIONS
			mActivity.runOnUiThread(new Runnable() {
				 @Override
				 public void run() {
					 radioButton1.performClick();
				 }
			});	
			getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);

	
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
	public void testradiobutton2() { 
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);

		for (int tempyear=1; tempyear <=3 ; tempyear++){
			mActivity.setYear(Integer.toString(tempyear));
			//INTERACTIONS
			mActivity.runOnUiThread(new Runnable() {
				 @Override
				 public void run() {
					 radioButton2.performClick();
				 }
			});	
			getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);

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
	public void testcheckbox1() { 
		mActivity.setPure("T");
		//INTERACTIONS
		mActivity.runOnUiThread(new Runnable() {
			 @Override
			 public void run() {
				 checkbox1.performClick();
			 }
		});	
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);
		
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
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);
		
		 //CHECK THE RESULT
		assertEquals("T",mActivity.getPure());
	} 
	
	public void testbutton1() {
		//INTERACTIONS
		mActivity.runOnUiThread(new Runnable() {
			 @Override
			 public void run() {
				 button1.performClick();
			 }
		});	
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);
		
		 //CHECK THE RESULT
		assertTrue(view1.isShown());
		assertFalse(view2.isShown());
		assertFalse(view3.isShown());
		assertEquals("1",mActivity.getYear());
	}
	
	public void testbutton2() {
		//INTERACTIONS
		mActivity.runOnUiThread(new Runnable() {
			 @Override
			 public void run() {
				 button2.performClick();
			 }
		});	
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);
		
		 //CHECK THE RESULT
		assertFalse(view1.isShown());
		assertTrue(view2.isShown());
		assertFalse(view3.isShown());
		assertEquals("2",mActivity.getYear());
	}
	
	public void testbutton3() {
		//INTERACTIONS
		mActivity.runOnUiThread(new Runnable() {
			 @Override
			 public void run() {
				 button3.performClick();
			 }
		});	
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);
		
		 //CHECK THE RESULT
		assertFalse(view1.isShown());
		assertFalse(view2.isShown());
		assertTrue(view3.isShown());
		assertEquals("3",mActivity.getYear());
	}
	
	@SmallTest 
	 public void testbutton111true() { 
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Advanced_Activity.class.getName(), null, false);
       	
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
		  Advanced_Activity nextActivity = (Advanced_Activity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);
		  assertNotNull(nextActivity);
		  nextActivity.finish();

	 }
	
	@SmallTest 
	 public void testbutton111false() { 
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Advanced_Activity2.class.getName(), null, false);
      	
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
		  Advanced_Activity2 nextActivity = (Advanced_Activity2) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);
		  assertNotNull(nextActivity);
		  nextActivity.finish();

	 }
	
	@SmallTest 
	 public void testlistView1() { 
		//precondition
		//assertFalse(mActivity.getToastshown());
		
		//INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      button1.performClick();
			    }
			  });	
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Study_Path.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);
		  
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			    	listView1.performItemClick(
			    		    listView1.getAdapter().getView(0, null, null), 0, 0);	
			    }
		  });	
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 50000);
		 //CHECK THE RESULT 
		 assertTrue(mActivity.getToastshown());
		 
	 }
	
	@SmallTest 
	 public void testDataBaseHelper1() { 
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
	public void testother(){
	      DataBaseUtility1.ShowMessageBox(mActivity, "AA");

	}
		 
}

