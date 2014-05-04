
package com.example.gpa_calculator.test;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Context;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.Button;

import com.example.asquare.R;
// com.example.gpa_calculator.GPAactivity2;
import com.example.gpa_calculator.MainActivity;
import com.example.gpa_calculator.add_course_record;
import com.example.gpa_calculator.advice1;
import com.example.gpa_calculator.printTGA;
import com.example.gpa_calculator.print_course_record;

//1.Change the things inside <XXXX>
public class StudentTest extends ActivityInstrumentationTestCase2<MainActivity> {

	//2.Change MainActivity
	private MainActivity mActivity;

	//3.Change MainActivity
	public StudentTest() {
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
	public void testSemIntToWords() { 
		  
		String fall = MainActivity.student1.SemIntToWords(0);
		String winter = MainActivity.student1.SemIntToWords(1);
		String spring = MainActivity.student1.SemIntToWords(2);
		String summer = MainActivity.student1.SemIntToWords(3);
		
		assertEquals("Fall", fall);
		assertEquals("Winter", winter);
		assertEquals("Spring", spring);
		assertEquals("Summer", summer);

	}
	
	@SmallTest
	public void testGradeToNum() { 
		  
		double A_plus = MainActivity.student1.GradeToNum("A+");
		double A = MainActivity.student1.GradeToNum("A");
		double A_minus = MainActivity.student1.GradeToNum("A-");
		double B_plus = MainActivity.student1.GradeToNum("B+");
		double B = MainActivity.student1.GradeToNum("B");
		double B_minus = MainActivity.student1.GradeToNum("B-");
		double C_plus = MainActivity.student1.GradeToNum("C+");
		double C = MainActivity.student1.GradeToNum("C");
		double C_minus = MainActivity.student1.GradeToNum("C-");
		double D = MainActivity.student1.GradeToNum("D");
		double F = MainActivity.student1.GradeToNum("F");

		assertEquals(4.3, A_plus);
		assertEquals(4.0, A);
		assertEquals(3.7, A_minus);
		assertEquals(3.3, B_plus);
		assertEquals(3.0, B);
		assertEquals(2.7, B_minus);
		assertEquals(2.3, C_plus);
		assertEquals(2.0, C);
		assertEquals(1.7, C_minus);
		assertEquals(1.0, D);
		assertEquals(0.0, F);


	}
	
	@SmallTest
	public void testNumToGrade() { 
		  
		String A_plus = MainActivity.student1.NumToGrade(4.3);
		String A = MainActivity.student1.NumToGrade(4);
		String A_minus = MainActivity.student1.NumToGrade(3.7);
		String B_plus = MainActivity.student1.NumToGrade(3.3);
		String B = MainActivity.student1.NumToGrade(3);
		String B_minus = MainActivity.student1.NumToGrade(2.7);
		String C_plus = MainActivity.student1.NumToGrade(2.3);
		String C = MainActivity.student1.NumToGrade(2);
		String C_minus = MainActivity.student1.NumToGrade(1.7);
		String D = MainActivity.student1.NumToGrade(1);
		String F = MainActivity.student1.NumToGrade(0);

		assertEquals("A+", A_plus);
		assertEquals("A", A);
		assertEquals("A-", A_minus);
		assertEquals("B+", B_plus);
		assertEquals("B", B);
		assertEquals("B-", B_minus);
		assertEquals("C+", C_plus);
		assertEquals("C", C);
		assertEquals("C-", C_minus);
		assertEquals("D", D);
		assertEquals("F", F);

	}

	
}
