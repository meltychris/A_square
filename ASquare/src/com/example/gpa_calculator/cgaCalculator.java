package com.example.gpa_calculator;

//import android.os.Bundle;
//import android.app.Activity;
//import android.view.Menu;

import java.io.*;
import java.util.Scanner;

public class cgaCalculator {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to GPA calculator function!");
		Student user = new Student();
		
		while (true)
		{
			Scanner input = new Scanner(System.in);
			
			System.out.println("Menu" + "\n"
							+ "1.Insert Course Record" + "\n"
							+ "2.Seek acadmic advices on course grade promotion to achieve target CGA" + "\n"
							+ "3.Delete Course Record" + "\n"
							+ "4.Reset all records in GPA calculator" + "\n"
							+ "5.Print TGA" + "\n"
							+ "6.Print CGA" + "\n"
							+ "7.Print GGA" + "\n"
							+ "8.Print all course record" + "\n"
							+ "9.Exit program"
							);
			
			System.out.print("Choice: ");

			int ans = Integer.parseInt(input.nextLine())-1;
		
		    switch(ans) { 
	        case 0: 
	        	user.insertCourseRecordEnquiry(); 
	            break; 
	        case 1: 
	        	user.diff_performance_advice();
	            break; 
	        case 2: 
	        	user.delCourseRecordEnquiry(); 
	            break;
	        case 3: 
	        	user.resetAllRecord();
	            break; 
	        case 4: 
	        	user.printTGA();
	            break; 
	        case 5: 
	        	user.printCGA();
	            break;
	        case 6: 
	        	user.printGGA();
	            break;
	        case 7: 
	        	user.printAllCourses();
	            break;
	        case 8:
	        	System.out.println("Program Exits");
	        	System.exit(0);
	            break; 
	        default: 
	        	System.out.println("Answer is out of range. Please retype");
	        	break;
		    }
		}

		
		
		
		
		//debug code
		
		/*
		user.insertCourseRecordEnquiry();
		
		System.out.println(user.courseRecord[0][0][0][0]);
		System.out.println(user.courseRecord[0][0][0][1]);
		System.out.println(user.courseRecord[0][0][0][2]);
		System.out.println(user.courseRecord[0][0][0][3]);
		System.out.println(user.year_sem_course_counter[0][0]);
		System.out.println(user.year_sem_credit_counter[0][0]);
		System.out.println(user.TGA[0][0]);
		System.out.println(user.CGA);
		System.out.println(user.GGA);
		
		user.resetAllRecord();
		//user.delCourseRecordEnquiry();

		System.out.println(user.courseRecord[0][0][0][0]);
		System.out.println(user.courseRecord[0][0][0][1]);
		System.out.println(user.courseRecord[0][0][0][2]);
		System.out.println(user.courseRecord[0][0][0][3]);
		System.out.println(user.year_sem_course_counter[0][0]);
		System.out.println(user.year_sem_credit_counter[0][0]);
		System.out.println(user.TGA[0][0]);
		System.out.println(user.CGA);
		System.out.println(user.GGA);
		*/
		
		//user.TGA[0][0] = 1;
		//user.CGA= 1;
		//user.GGA = 1;
		
		//user.printTGA();
		//user.printCGA();
		//user.printGGA();
		
		//System.out.println(user.NumToGrade(4.3));
		//System.out.println(user.NumToGrade(0));
		//System.out.println(user.NumToGrade(1.2));
		//System.out.println(user.GradeToNum("A"));
		

		
		//System.out.println("user.TGA[0][0] = " + user.TGA[0][0]);
		//System.out.println("user.TGA[0][1]= " + user.TGA[0][1]);
		//System.out.println("user.TGA[0][2]= " + user.TGA[0][2]);
		
		
		
		

		
		
		
		//System.out.println(user.courseRecord[0][0][1][0]);
		//System.out.println(user.courseRecord[0][0][1][1]);
		//System.out.println(user.courseRecord[0][0][1][2]);
		//System.out.println(user.courseRecord[0][0][1][3]);
		

		
		
		
		//user.studentinput();
		
		//System.out.println(user.courseRecord[0][0][0][0]);
		//System.out.println(user.courseRecord[0][0][0][1]);
		//System.out.println(user.courseRecord[0][0][0][2]);
		
		//System.out.println("user.TGA[0][0]= " + user.TGA[0][0]);
		//System.out.println("user.TGA[0][1]= " + user.TGA[0][1]);
		//System.out.println("user.TGA[0][2]= " + user.TGA[0][2]);
		
		
		//int year = 0;
		//int sem = 0;
		//user.printTGA();
		//user.printCGA();
		//user.printGGA();

	}
}
