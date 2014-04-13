package com.example.gpa_calculator.test;

import com.example.gpa_calculator.Student;
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
import android.widget.RadioButton;

public class Testgpa_calculator extends ActivityInstrumentationTestCase2<Student> {

	private Student mActivity;
	Button button1;//Next
	//Button button2;
	//Button button3;
	//ListView listView1;
	EditText editText1;//Name
	//EditText Code;
	//EditText Date;
	
    RadioButton radioButton1;//year1
    RadioButton RadioButton04;//year2
    RadioButton RadioButton06;//year3
    RadioButton RadioButton07;//year4
    RadioButton RadioButton08;//year5

    RadioButton RadioButton02;//Fall
    RadioButton RadioButton01;//Winter
    RadioButton RadioButton03;//Spring
    RadioButton RadioButton05;//Summer
    
	public Testgpa_calculator() {
		super(Student.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	
		mActivity = getActivity();  
		
		button1 = (Button)mActivity.findViewById(R.id.Button01);;//Next
		
		editText1 = (EditText)mActivity.findViewById(R.id.editText1);;//Name
		
		//listView1 = (ListView)mActivity.findViewById(R.id.listView1);;
		//Code = (EditText)mActivity.findViewById(R.id.Code);;
		//Date = (EditText)mActivity.findViewById(R.id.Date);;
		
		
		radioButton1 = (RadioButton)mActivity.findViewById(R.id.radioButton1); //year1
		RadioButton04 = (RadioButton)mActivity.findViewById(R.id.RadioButton04);//year2
		RadioButton06 = (RadioButton)mActivity.findViewById(R.id.RadioButton06);//year3
		RadioButton07 = (RadioButton)mActivity.findViewById(R.id.RadioButton07);//year4
		RadioButton08 = (RadioButton)mActivity.findViewById(R.id.RadioButton08);//year5

		RadioButton02 = (RadioButton)mActivity.findViewById(R.id.RadioButton02);//Fall
		RadioButton01 = (RadioButton)mActivity.findViewById(R.id.RadioButton01);//Winter
		RadioButton03 = (RadioButton)mActivity.findViewById(R.id.RadioButton03);//Spring
		RadioButton05 = (RadioButton)mActivity.findViewById(R.id.RadioButton05);//Winter
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
		//Next
		//check whether go next page
		//2 page layout used the same button button1
		
		
		
		
		//int expectedCount = listView1.getAdapter().getCount() + 1;
		String expectedNameString = "Chan Tai Man";

		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	
			      editText1.setText("Chan Tai Man");
			      //Code.setText("COMP3111");
			      //Date.setText("2014/02/30");
			      button1.performClick();
			    }
			  });
		  
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Student.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		  
		
		//int actualCount = editText1.getAdapter().getCount();
		String actualtNameString = editText1.getText().toString();
		
		 //CHECK THE RESULT 
	    assertEquals("testbutton1() fails", expectedNameString, actualtNameString);
	}
	
	@SmallTest 
	 public void testeditText1() {
		//Name:
		
	}
	
	@SmallTest 
	 public void testradioButton1() {
		//current Year 1
		
		
	}
	
	@SmallTest 
	 public void testRadioButton04() {
		//current Year 2
		
	}
	
	@SmallTest 
	 public void testRadioButton06() {
		//current Year 3
		
	}
	
	@SmallTest 
	 public void testRadioButton07() {
		//current Year 4
		
	}
	
	@SmallTest 
	 public void testRadioButton08() {
		//current Year 5
	}
	
	@SmallTest 
	 public void testRadioButton02() {
		//Fall
	}
	
	@SmallTest 
	 public void testRadioButton01() {
		//Winter
	}
	
	@SmallTest 
	 public void testRadioButton03() {
		//Spring
	}
	
	@SmallTest 
	 public void testRadioButton05() {
		//Summer
	}
	
	
	//below directly copied from Study_Path_Test, not yet checked!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	
	
	
	
	
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
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Exam_countdown.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
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
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Exam_countdown.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
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
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
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
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Exam_countdown.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
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
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Exam_countdown.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
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
			      button1.performClick();
			    }
			  });	
		  
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Exam_countdown.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);

		  
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
			      button1.performClick();
			    }
			  });	
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Exam_countdown.class.getName(), null, false);
		  getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		  assertEquals("2014/01/01",Date.getText());

	 }
}
