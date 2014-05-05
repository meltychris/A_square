package com.example.gpa_calculator.test;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.asquare.R;
// com.example.gpa_calculator.GPAactivity2;
import com.example.gpa_calculator.MainActivity;
import com.example.gpa_calculator.add_course_record;
import com.example.gpa_calculator.advice1;
import com.example.gpa_calculator.printTGA;
import com.example.gpa_calculator.print_course_record;

//ref : //http://blogs.lessthandot.com/index.php/desktopdev/suntech/java/android-testing-if-an-activity/
//whole test follows this url, and only test the close activity button, buttonGPAadd2
public class add_course_recordTest2 extends android.test.ActivityUnitTestCase<add_course_record> {
 
	private Intent mStartIntent;
	
	public add_course_recordTest2() {
		super(add_course_record.class);
	}

	    
	    @Override
	    protected void setUp() throws Exception {
	        super.setUp();
	        mStartIntent = new Intent(Intent.ACTION_MAIN);
	}    
	
	    
	//ONLY test the exit button in inserting record!!!    
	@SmallTest
	public void testButtonGPAadd2() { 

        startActivity(mStartIntent, null, null);
        Button buttonGPAadd2 = (Button)getActivity().findViewById(R.id.buttonGPAadd2);
        buttonGPAadd2.performClick();
        assertTrue(this.isFinishCalled());

		
	}
	

	
	

	//Button buttonGPAadd2;


	
}
