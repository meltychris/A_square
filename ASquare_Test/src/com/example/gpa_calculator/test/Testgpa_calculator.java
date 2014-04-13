package com.example.gpa_calculator.test;

import com.example.gpa_calculator.Student;
import com.example.study_path.Study_Path;
import com.example.asquare.MainActivity;
import com.example.asquare.R;

import android.app.AlertDialog;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.DialogInterface;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;

public class Testgpa_calculator extends ActivityInstrumentationTestCase2<Student> {

	
	private Student mActivity;
	private static final String LOG_TAG = "Brian";
	//http://stackoverflow.com/questions/2220547/why-doesnt-system-out-println-work-in-android
	
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
		
		//http://stackoverflow.com/questions/2220547/why-doesnt-system-out-println-work-in-android
		//Log.e(LOG_TAG, "expectedNameString = " + expectedNameString);
		//Log.e(LOG_TAG, "actualtNameString = " + actualtNameString);
		 
		
		 //CHECK THE RESULT 
	    assertEquals("testbutton1() fails", expectedNameString, actualtNameString);
	    //assertTrue("testbutton1() fails", expectedNameString.equals(actualtNameString));
	}
	
	@SmallTest 
	 public void testEditText1() {
		//Name:
		//copied from above testbutton1(), exactly same, just try to avoid empty
		
		
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
		
		//http://stackoverflow.com/questions/2220547/why-doesnt-system-out-println-work-in-android
		//Log.e(LOG_TAG, "expectedNameString = " + expectedNameString);
		//Log.e(LOG_TAG, "actualtNameString = " + actualtNameString);
		 
		
		 //CHECK THE RESULT 
	    assertEquals("testbutton1() fails", expectedNameString, actualtNameString);
	    //assertTrue("testbutton1() fails", expectedNameString.equals(actualtNameString));
		
	    //assertTrue(true);
		
	}
	
	@SmallTest 
	 public void testradioButton1() {
		//current Year 1
		//copy from Study_Path_Test.java
		
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Student.class.getName(), null, false);

		//for (int tempyear=1; tempyear <=3 ; tempyear++){
		//mActivity.setYear(Integer.toString(tempyear));
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	//radioButton2.setChecked(true);
			    	//assertTrue(radioButton2.isChecked());
			    	//radioGroup.check(R.id.radioButton1);
			    	radioButton1.performClick();
			    	//System.out.println(radioButton1.performClick());

			    	//radioButton2.performClick();
			    }


			  });	
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		assertTrue(radioButton1.isChecked());
		assertFalse(RadioButton04.isChecked());
		assertFalse(RadioButton06.isChecked());
		assertFalse(RadioButton07.isChecked());
		assertFalse(RadioButton08.isChecked());
		

/*
		 //CHECK THE RESULT
		  //assertEquals("COMP",major);
		  if (mActivity.getYear().equals("1"))
			  assertTrue(view1.isShown());
		  else if (mActivity.getYear().equals("2"))
			  assertTrue(view2.isShown());
    	  else
			  assertTrue(view3.isShown());
		}
*/		
	} 
		

	
	@SmallTest 
	 public void testRadioButton04() {
		//current Year 2
		//copy from Study_Path_Test.java
		
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Student.class.getName(), null, false);

		//for (int tempyear=1; tempyear <=3 ; tempyear++){
		//mActivity.setYear(Integer.toString(tempyear));
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	//radioButton2.setChecked(true);
			    	//assertTrue(radioButton2.isChecked());
			    	//radioGroup.check(R.id.radioButton1);
			    	RadioButton04.performClick();
			    	//System.out.println(radioButton1.performClick());

			    	//radioButton2.performClick();
			    }


			  });	
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		assertFalse(radioButton1.isChecked());
		assertTrue(RadioButton04.isChecked());
		assertFalse(RadioButton06.isChecked());
		assertFalse(RadioButton07.isChecked());
		assertFalse(RadioButton08.isChecked());
		

/*
		 //CHECK THE RESULT
		  //assertEquals("COMP",major);
		  if (mActivity.getYear().equals("1"))
			  assertTrue(view1.isShown());
		  else if (mActivity.getYear().equals("2"))
			  assertTrue(view2.isShown());
  	  else
			  assertTrue(view3.isShown());
		}
*/		
	}
	
	@SmallTest 
	 public void testRadioButton06() {
		//current Year 3
		//copy from Study_Path_Test.java
		
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Student.class.getName(), null, false);

		//for (int tempyear=1; tempyear <=3 ; tempyear++){
		//mActivity.setYear(Integer.toString(tempyear));
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	//radioButton2.setChecked(true);
			    	//assertTrue(radioButton2.isChecked());
			    	//radioGroup.check(R.id.radioButton1);
			    	RadioButton06.performClick();
			    	//System.out.println(radioButton1.performClick());

			    	//radioButton2.performClick();
			    }


			  });	
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		assertFalse(radioButton1.isChecked());
		assertFalse(RadioButton04.isChecked());
		assertTrue(RadioButton06.isChecked());
		assertFalse(RadioButton07.isChecked());
		assertFalse(RadioButton08.isChecked());
		

/*
		 //CHECK THE RESULT
		  //assertEquals("COMP",major);
		  if (mActivity.getYear().equals("1"))
			  assertTrue(view1.isShown());
		  else if (mActivity.getYear().equals("2"))
			  assertTrue(view2.isShown());
	  else
			  assertTrue(view3.isShown());
		}
*/		
	}
	
	@SmallTest 
	 public void testRadioButton07() {
		//current Year 4		
		//copy from Study_Path_Test.java
		
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Student.class.getName(), null, false);

		//for (int tempyear=1; tempyear <=3 ; tempyear++){
		//mActivity.setYear(Integer.toString(tempyear));
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	//radioButton2.setChecked(true);
			    	//assertTrue(radioButton2.isChecked());
			    	//radioGroup.check(R.id.radioButton1);
			    	RadioButton07.performClick();
			    	//System.out.println(radioButton1.performClick());

			    	//radioButton2.performClick();
			    }


			  });	
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		assertFalse(radioButton1.isChecked());
		assertFalse(RadioButton04.isChecked());
		assertFalse(RadioButton06.isChecked());
		assertTrue(RadioButton07.isChecked());
		assertFalse(RadioButton08.isChecked());
		

/*
		 //CHECK THE RESULT
		  //assertEquals("COMP",major);
		  if (mActivity.getYear().equals("1"))
			  assertTrue(view1.isShown());
		  else if (mActivity.getYear().equals("2"))
			  assertTrue(view2.isShown());
	  else
			  assertTrue(view3.isShown());
		}
*/		
	}
	
	@SmallTest 
	 public void testRadioButton08() {
		//current Year 5	
		//copy from Study_Path_Test.java
		
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Student.class.getName(), null, false);

		//for (int tempyear=1; tempyear <=3 ; tempyear++){
		//mActivity.setYear(Integer.toString(tempyear));
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	//radioButton2.setChecked(true);
			    	//assertTrue(radioButton2.isChecked());
			    	//radioGroup.check(R.id.radioButton1);
			    	RadioButton08.performClick();
			    	//System.out.println(radioButton1.performClick());

			    	//radioButton2.performClick();
			    }


			  });	
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		assertFalse(radioButton1.isChecked());
		assertFalse(RadioButton04.isChecked());
		assertFalse(RadioButton06.isChecked());
		assertFalse(RadioButton07.isChecked());
		assertTrue(RadioButton08.isChecked());
		

/*
		 //CHECK THE RESULT
		  //assertEquals("COMP",major);
		  if (mActivity.getYear().equals("1"))
			  assertTrue(view1.isShown());
		  else if (mActivity.getYear().equals("2"))
			  assertTrue(view2.isShown());
	  else
			  assertTrue(view3.isShown());
		}
*/	
	}
	
	@SmallTest 
	 public void testRadioButton02() {
		//Fall
		
		//copy from Study_Path_Test.java
		
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Student.class.getName(), null, false);

		//for (int tempyear=1; tempyear <=3 ; tempyear++){
		//mActivity.setYear(Integer.toString(tempyear));
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	//radioButton2.setChecked(true);
			    	//assertTrue(radioButton2.isChecked());
			    	//radioGroup.check(R.id.radioButton1);
			    	RadioButton02.performClick();
			    	//System.out.println(radioButton1.performClick());

			    	//radioButton2.performClick();
			    }


			  });	
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		
		assertTrue(RadioButton02.isChecked());
		assertFalse(RadioButton01.isChecked());
		assertFalse(RadioButton03.isChecked());
		assertFalse(RadioButton05.isChecked());
		

/*
		 //CHECK THE RESULT
		  //assertEquals("COMP",major);
		  if (mActivity.getYear().equals("1"))
			  assertTrue(view1.isShown());
		  else if (mActivity.getYear().equals("2"))
			  assertTrue(view2.isShown());
	  else
			  assertTrue(view3.isShown());
		}
*/	
	}
	
	@SmallTest 
	 public void testRadioButton01() {
		//Winter
		
		//copy from Study_Path_Test.java
		
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Student.class.getName(), null, false);

		//for (int tempyear=1; tempyear <=3 ; tempyear++){
		//mActivity.setYear(Integer.toString(tempyear));
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	//radioButton2.setChecked(true);
			    	//assertTrue(radioButton2.isChecked());
			    	//radioGroup.check(R.id.radioButton1);
			    	RadioButton01.performClick();
			    	//System.out.println(radioButton1.performClick());

			    	//radioButton2.performClick();
			    }


			  });	
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		
		assertFalse(RadioButton02.isChecked());
		assertTrue(RadioButton01.isChecked());
		assertFalse(RadioButton03.isChecked());
		assertFalse(RadioButton05.isChecked());
		

/*
		 //CHECK THE RESULT
		  //assertEquals("COMP",major);
		  if (mActivity.getYear().equals("1"))
			  assertTrue(view1.isShown());
		  else if (mActivity.getYear().equals("2"))
			  assertTrue(view2.isShown());
	  else
			  assertTrue(view3.isShown());
		}
*/	
	}
	
	@SmallTest 
	 public void testRadioButton03() {
		//Spring
		
		//copy from Study_Path_Test.java
		
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Student.class.getName(), null, false);

		//for (int tempyear=1; tempyear <=3 ; tempyear++){
		//mActivity.setYear(Integer.toString(tempyear));
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	//radioButton2.setChecked(true);
			    	//assertTrue(radioButton2.isChecked());
			    	//radioGroup.check(R.id.radioButton1);
			    	RadioButton03.performClick();
			    	//System.out.println(radioButton1.performClick());

			    	//radioButton2.performClick();
			    }


			  });	
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		
		assertFalse(RadioButton02.isChecked());
		assertFalse(RadioButton01.isChecked());
		assertTrue(RadioButton03.isChecked());
		assertFalse(RadioButton05.isChecked());
		

/*
		 //CHECK THE RESULT
		  //assertEquals("COMP",major);
		  if (mActivity.getYear().equals("1"))
			  assertTrue(view1.isShown());
		  else if (mActivity.getYear().equals("2"))
			  assertTrue(view2.isShown());
	  else
			  assertTrue(view3.isShown());
		}
*/	
	}
	
	@SmallTest 
	 public void testRadioButton05() {
		//Summer
		
		//copy from Study_Path_Test.java
		
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Student.class.getName(), null, false);

		//for (int tempyear=1; tempyear <=3 ; tempyear++){
		//mActivity.setYear(Integer.toString(tempyear));
		 //INTERACTIONS
		  mActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			    	//radioButton2.setChecked(true);
			    	//assertTrue(radioButton2.isChecked());
			    	//radioGroup.check(R.id.radioButton1);
			    	RadioButton05.performClick();
			    	//System.out.println(radioButton1.performClick());

			    	//radioButton2.performClick();
			    }


			  });	
		getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		
		assertFalse(RadioButton02.isChecked());
		assertFalse(RadioButton01.isChecked());
		assertFalse(RadioButton03.isChecked());
		assertTrue(RadioButton05.isChecked());
		

/*
		 //CHECK THE RESULT
		  //assertEquals("COMP",major);
		  if (mActivity.getYear().equals("1"))
			  assertTrue(view1.isShown());
		  else if (mActivity.getYear().equals("2"))
			  assertTrue(view2.isShown());
	  else
			  assertTrue(view3.isShown());
		}
*/	
	}
	
	
	//below directly copied from Study_Path_Test, not yet checked!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	
	
	
	
/*	
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
*/
}
