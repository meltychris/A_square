package com.example.gpa_calculator.test;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
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
import com.example.gpa_calculator.advice2;
import com.example.gpa_calculator.printTGA;
import com.example.gpa_calculator.print_course_record;

//ref : //http://blogs.lessthandot.com/index.php/desktopdev/suntech/java/android-testing-if-an-activity/
//whole test follows this url, and only test the close activity button, buttonGPAadd2
public class advice2Test2 extends android.test.ActivityUnitTestCase<advice2> {
 
	private Intent mStartIntent;
	
	public advice2Test2() {
		super(advice2.class);
	}

	    
	    @Override
	    protected void setUp() throws Exception {
	        super.setUp();
	        mStartIntent = new Intent(Intent.ACTION_MAIN);
	}    
	
	    
	//ONLY test the exit button in advice2!!!    
	@SmallTest
	public void testButtonGPAadvice2_1() { 

        startActivity(mStartIntent, null, null);
        Button buttonGPAadvice2_1 = (Button)getActivity().findViewById(R.id.buttonGPAadvice2_1);
        buttonGPAadvice2_1.performClick();
        assertTrue(this.isFinishCalled());

		
	}
	

	
	

;


	
}
