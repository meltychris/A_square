package com.example.study_path.test;


import com.example.asquare.MainActivity;
import com.example.asquare.R;
import com.example.exam_count_down.Exam_countdown;
import com.example.study_path.Study_Path;

import android.app.AlertDialog;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.DialogInterface;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Study_Path_Test extends ActivityInstrumentationTestCase2<Study_Path> {

	Study_Path mActivity;
	/*private Button button1;
    private Button button2;
    private Button button3;
    private Button button111;
    private ListView listView1;
    private View view1;
    private View view2;
    private View view3;*/
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioGroup radioGroup;
    CheckBox checkbox1;
    
	public Study_Path_Test() {
		super(Study_Path.class);

	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();  
		/*button1 = (Button)mActivity.findViewById(R.id.button1);
		button2 = (Button)mActivity.findViewById(R.id.button2);
		button3 = (Button)mActivity.findViewById(R.id.button3);
		button111 = (Button)mActivity.findViewById(R.id.button111);
		checkbox1 = (CheckBox)mActivity.findViewById(R.id.checkBox1);
		listView1 = (ListView)mActivity.findViewById(R.id.listView1);
		view1 = (View)mActivity.findViewById(R.id.View1);
		view2 = (View)mActivity.findViewById(R.id.View2);
		view3 = (View)mActivity.findViewById(R.id.View3);*/
		radioButton1 = (RadioButton)mActivity.findViewById(R.id.radioButton1);
		radioButton2 = (RadioButton)mActivity.findViewById(R.id.radioButton2);
		RadioGroup radioGroup = (RadioGroup)mActivity.findViewById(R.id.RadioGroup1);
		//System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	   /* major = mActivity.major;
	    private String year;
	    private String pure;*/
	}
	
	@Override 
	 protected void tearDown() throws Exception { 
		 //this method is called every time after any test execution 
		 // we want to clean the texts 
		 super.tearDown(); 
	 } 

/*
	@SmallTest // SmallTest: this test doesn't interact with any file system or network. 
	 public void testView() { // checks if the activity is created 
		assertNotNull(getActivity()); 
	 } 
	
	@SmallTest 
	public void testOnCreate() throws Exception {
		assertFalse(view1.isShown());
		assertFalse(view2.isShown());
		assertFalse(view3.isShown());
		//assertEquals("COMP",major.toString());
		//assertEquals("1",year);
		//assertEquals("T",pure);
	 }
	*/
	@SmallTest 
	 public void testradiobutton1() { 

		/*for (int tempyear=1; tempyear <=3 ; tempyear++){
			mActivity.setYear(Integer.toString(tempyear));
			 //INTERACTIONS*/
			  mActivity.runOnUiThread(new Runnable() {
				    @Override
				    public void run() {
				      // click button and open next activity.
				    	//radioButton2.setChecked(true);
				    	//assertTrue(radioButton2.isChecked());
				    	//radioGroup.check(R.id.radioButton1);

				    	radioButton2.performClick();
				    }
			    	

				  });	
			 //CHECK THE RESULT
			  //assertEquals("COMP",major);
			/*  if (mActivity.getYear().equals("1"))
				  assertTrue(view1.isShown());
			  else if (mActivity.getYear().equals("2"))
				  assertTrue(view2.isShown());
          	  else
				  assertTrue(view3.isShown());*/
			//}
		}
		  
			  
}

