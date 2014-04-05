package com.example.gpa_calculator;

//import android.os.Bundle;
//import android.app.Activity;
//import android.view.Menu;

import java.io.*;

public class cgaCalculator {

	public static void main(String[] args) throws IOException {

		Student user = new Student();
		
		
		
		
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
		
		user.insertCourseRecordEnquiry();
		
		//System.out.println("user.TGA[0][0] = " + user.TGA[0][0]);
		//System.out.println("user.TGA[0][1]= " + user.TGA[0][1]);
		//System.out.println("user.TGA[0][2]= " + user.TGA[0][2]);
		
		
		
		
		System.out.println(user.courseRecord[0][0][0][0]);
		System.out.println(user.courseRecord[0][0][0][1]);
		System.out.println(user.courseRecord[0][0][0][2]);
		System.out.println(user.courseRecord[0][0][0][3]);
		System.out.println(user.year_sem_course_counter[0][0]);
		System.out.println(user.year_sem_credit_counter[0][0]);
		System.out.println(user.TGA[0][0]);
		System.out.println(user.CGA);
		System.out.println(user.GGA);
		
		
		
		//System.out.println(user.courseRecord[0][0][1][0]);
		//System.out.println(user.courseRecord[0][0][1][1]);
		//System.out.println(user.courseRecord[0][0][1][2]);
		//System.out.println(user.courseRecord[0][0][1][3]);
		
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
