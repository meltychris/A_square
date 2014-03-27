package com.example.gpa_calculator;

//import android.os.Bundle;
//import android.app.Activity;
//import android.view.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class cgaCalculator {
	
	public static void main(String[] args) throws IOException 
	{
		
		
		Student abc = new Student();
		
		//System.out.println("abc.TGA[0][0]= " + abc.TGA[0][0]);
		//System.out.println("abc.TGA[0][1]= " + abc.TGA[0][1]);
		//System.out.println("abc.TGA[0][2]= " + abc.TGA[0][2]);
		
		//System.out.println(abc.GradeToNum("A"));
		
		
		//System.out.println(abc.courseRecord[0][0][0][0]);
		//System.out.println(abc.courseRecord[0][0][0][1]);
		//System.out.println(abc.courseRecord[0][0][0][2]);
		
		abc.studentinput();
		
		//System.out.println(abc.courseRecord[0][0][0][0]);
		//System.out.println(abc.courseRecord[0][0][0][1]);
		//System.out.println(abc.courseRecord[0][0][0][2]);
		
		//System.out.println("abc.TGA[0][0]= " + abc.TGA[0][0]);
		//System.out.println("abc.TGA[0][1]= " + abc.TGA[0][1]);
		//System.out.println("abc.TGA[0][2]= " + abc.TGA[0][2]);
		
		
		//int year = 0;
		//int sem = 0;
		abc.printTGA();
	
		abc.printCGA();
		abc.printGGA();
		
	}

}
	
	class Student {
		
		
		
		public static final int MAX_STUDY_YEAR = 5;
		public static final int MAX_SEMESTER = 4;
		public static final int MAX_SEM_COURSES = 10;
		int currentYear;
		int currentSem;
		double CGA = 0;
		double GGA = 0;	
		
		//TGA for each sem
		//no need to initialize, all 0.0
		double[][] TGA = new double[MAX_STUDY_YEAR][MAX_SEMESTER];
		

		
		//courseRecord[year][sem][course][name/credit/grade]
		//no need to initialize, all null
		String[][][][] courseRecord = new String[MAX_STUDY_YEAR][MAX_SEMESTER][MAX_SEM_COURSES][3];
		
		//courseRecord[year][sem][course][name/credit/grade]
		//no need to initialize, all 0
		int[][] year_sem_course_counter = new int[MAX_STUDY_YEAR][MAX_SEMESTER];
		int[][] year_sem_credit_counter = new int[MAX_STUDY_YEAR][MAX_SEMESTER];



		public String SemIntToWords(int a)
		{
		    switch(a) { 
            case 0: 
                return "Fall"; 
                //break; 
            case 1: 
            	 return "Winter"; 
                //break; 
            case 2: 
            	 return "Spring";  
                //break;  
            default: 
            	 return "Summer"; 
            
		    }
		}
		
		public double GradeToNum(String a)
		{
			//grade table from A+ to D

			if (a.equals("A+"))
			{
				return 4.3;
			}
			else if (a.equals("A"))
			{
				return 4;
			}
			else if (a.equals("A-"))
			{
				return 3.7;
			}
			else if (a.equals("B+"))
			{
				return 3.3;
			}
			else if (a.equals("B"))
			{
				return 3;
			}
			else if (a.equals("B-"))
			{
				return 2.7;
			}
			else if (a.equals("C+"))
			{
				return 2.3;
			}
			else if (a.equals("C"))
			{
				return 2;
			}
			else if (a.equals("C-"))
			{
				return 1.7;
			}
			else if (a.equals("D"))
			{
				return 1;
			}
			else //grade other than A-D, eg. F,PP
			{
				return 0.0;
			}
		
		}
	
	
	public void studentinput()throws IOException {
		
			String Answer0 = "Y";
			int i = 0;
			
			while (Answer0.equals("Y"))
			{
				
				int year;
				int sem;
				String CourseName;
				String Credit;
				String Grade;		
			
				Scanner input = new Scanner(System.in);

				System.out.print("Study year: (Type 1-5)");
				year=Integer.parseInt(input.nextLine()) - 1;
				
				String Answer1 = "Y";
				int j = 0;
				
				while (Answer1.equals("Y") && (year < MAX_STUDY_YEAR))
				{
						
					System.out.print("Semester:(Fall (Type 1) / Winter (Type 2) / Spring (Type 3) / Summer (Type 4) ):");
					sem=Integer.parseInt(input.nextLine()) - 1;
					
					String Answer2 = "Y";
					int k = 0;
				
					while (Answer2.equals("Y") && (year_sem_course_counter[year][sem] <= MAX_SEM_COURSES))
					{
						year_sem_course_counter[year][sem]++;
					
						System.out.print("Course Name:");
						CourseName=input.nextLine();
						courseRecord[year][sem][k][0] = CourseName;
					
					
						System.out.print("Credits Studied:");
						Credit=input.nextLine();
						courseRecord[year][sem][k][1] = Credit;
						year_sem_credit_counter[year][sem] = year_sem_credit_counter[year][sem] + Integer.parseInt(Credit);
						//System.out.print("year_sem_credit_counter[year][sem]=" + year_sem_credit_counter[year][sem]);
							
						System.out.print("Grade:");
						Grade=input.nextLine();
						courseRecord[year][sem][k][2] = Grade;
	
						
						System.out.print("Still have other course information to input for Year" + (year+1) + " Sem" + (sem+1) + "? Y/N: ");
						Answer2=input.nextLine();
						
						k++;
			
					}
					System.out.print("Still have other course information to input for Year" + (year+1) + "? Y/N");
					Answer1=input.nextLine();
					j++;
				
				}
				System.out.print("Still have other course information to input ? Y/N");
				Answer0=input.nextLine();
				i++;
			}
			
			
			//Calculate TGA CGA GGA after all input
			//input TGA into TGA table
			//for (int year = 0 ; year < MAX_STUDY_YEAR ; year++)
			//{
			//	for (int sem = 0 ; sem < MAX_SEMESTER ; sem++)
			//	calTGA(year,sem);
			//}
			//
			//calCGA();
			//calGGA();
	}


			
	

				


	

		//Users can type in their target CGA or target honor for graduation at the first time of using this app
		/*while (true) {
			System.out.println("Please enter the target CGA form of ???);
			System.out.println("Please enter in the target honor form of ???);
		
		}
		*/
		

/*
	//Bottom left position show the button with figure "-x.y" e.g. "-0.3" 
	//to show the difference between target CGA and actual performance (1 d.p.)
	public static void diff_targetCGA(String args[]) throws IOException {
		
		
		
		diff = current_CGA-target_CGA;
		
		if (diff < 0) {
			
		}
		else if (diff > 0){
			
		}
		else
		{
			
		}
		
	}
*/

	//not finished
	//parameter  year,semester
	public void calTGA(int year, int sem) throws IOException {
		
		//as calculation will give out decimal point number
		double sum_of_grade_point = 0;
		//double total_no_of_credit;
		
		//System.out.println("year = " + year);
		//System.out.println("sem = " + sem);		
		//System.out.println("year_sem_course_counter[year][sem] = " + year_sem_course_counter[year][sem]);
		//System.out.println("courseRecord[year][sem][i][0]) = " + (courseRecord[year][sem][0][0]));
		//System.out.println("Integer.parseInt(courseRecord[year][sem][i][1]) = " + Integer.parseInt(courseRecord[year][sem][0][1]));
		//System.out.println("GradeToNum(courseRecord[year][sem][i][2]) = " + GradeToNum(courseRecord[year][sem][0][2]));
		
		int i = 0;
		while ( i  < year_sem_course_counter[year][sem] ){
			sum_of_grade_point = sum_of_grade_point + GradeToNum(courseRecord[year][sem][i][2])*Integer.parseInt(courseRecord[year][sem][i][1]);
			//System.out.println("sum_of_grade_point  1 = " + sum_of_grade_point);
			i++;
			//System.out.println("i = " + i);
		}
		
		//System.out.println("sum_of_grade_point  2 = " + sum_of_grade_point);
		
		//System.out.println("year_sem_credit_counter[year][sem]" + year_sem_credit_counter[year][sem]);
		
		if (year_sem_credit_counter[year][sem] == 0)
		{
			TGA[year][sem] = 0;
		}
		else
		{
			TGA[year][sem] = sum_of_grade_point/year_sem_credit_counter[year][sem];
		}
		
		
		//System.out.println("TGA[year][sem] " + TGA[year][sem]);

				

	}
	
	public void calCGA() throws IOException {
		
		double sum_of_grade_point = 0;
		int sum_of_all_credit_taken = 0;
		
		
		int year = 0;
		
		
		//System.out.println("CGA 0 = " + CGA);
		
		//sum_of_grade_point + sum_of_all_credit_taken
		while (year < MAX_STUDY_YEAR)
		{
			int sem = 0;
			while (sem < MAX_SEMESTER)
			{
				//System.out.println("CGA 1 = " + CGA);
				//System.out.println("sum_of_grade_point 3 = " + sum_of_grade_point);
				
				//System.out.println("TGA[year][sem] = " + TGA[year][sem]);
				//System.out.println("year_sem_credit_counter[year][sem] = " + year_sem_credit_counter[year][sem]);
				
				sum_of_grade_point = sum_of_grade_point +  TGA[year][sem]*year_sem_credit_counter[year][sem];
				
				sum_of_all_credit_taken = sum_of_all_credit_taken +  year_sem_credit_counter[year][sem];
				
				sem++;
				
				//System.out.println("year = " + year);
				//System.out.println("sem = " + sem);
				//System.out.println("sum_of_grade_point 4 = " + sum_of_grade_point);
				
			}
			year++;
		}
		
/*		//sum_of_All_credit
		
		System.out.println("Inside sum_of_All_credit loop");
		
		int sum_of_all_credit_taken = 0;
		
		System.out.println("sum_of_all_credit_taken 1 = " + sum_of_all_credit_taken);
		System.out.println("year_sem_credit_counter[year][sem] 1 = " + year_sem_credit_counter[year][sem]);
		
		
		while (year < MAX_STUDY_YEAR)
		{
			while (sem < MAX_SEMESTER)
			{
				System.out.println("year_sem_credit_counter[year][sem] 2 = " + year_sem_credit_counter[year][sem]);
	
				sum_of_all_credit_taken = sum_of_all_credit_taken +  year_sem_credit_counter[year][sem];
				sem++;
				
				System.out.println("year = " + year);
				System.out.println("sem = " + sem);
				System.out.println("sum_of_all_credit_taken 2 = " + sum_of_all_credit_taken);
				System.out.println("sum_of_all_credit_taken 1 = " + sum_of_all_credit_taken);
				System.out.println("------------------");
			}
			year++;
		}
		*/
		CGA = sum_of_grade_point/sum_of_all_credit_taken;
		
	}
	
	public void calGGA() throws IOException {
		
		double sum_of_grade_point = 0;
		double sum_of_all_credit_taken = 0;
		
		
		int year = 0;
		
	
		//sum_of_grade_point + sum_of_all_credit_taken
		while (year < MAX_STUDY_YEAR)
		{	
			int sem = 0;
			while (sem < MAX_SEMESTER)
			{			
				//year1 weighting is lower
				if (year == 0)
				{
					sum_of_grade_point = sum_of_grade_point +  (0.5*TGA[year][sem]*year_sem_credit_counter[year][sem]);
					
					sum_of_all_credit_taken = sum_of_all_credit_taken +  (0.5*year_sem_credit_counter[year][sem]);

					
					//System.out.println("GGA 1 = " + GGA);
				}
				else {
					sum_of_grade_point = sum_of_grade_point +  TGA[year][sem]*year_sem_credit_counter[year][sem];
					
					sum_of_all_credit_taken = sum_of_all_credit_taken +  year_sem_credit_counter[year][sem];

				
					//System.out.println("GGA 2 = " + GGA);
				}
				
				sem++;
			}
			year++;
		}
		GGA = sum_of_grade_point/sum_of_all_credit_taken;

		
	}
	

	public void printCourses(int year, int sem) throws IOException {
		
		//print List of records showing currently studying courses,
		//followed by the courses taken
		
		//courseRecord[year][sem][i]
		
				
		while (year < MAX_STUDY_YEAR)
		{
			while (sem < MAX_SEMESTER)
			{			
		
				System.out.println("Year" + year + SemIntToWords(sem) + 
							", Course Name" + courseRecord[year][sem][0] +
							", Credit" + courseRecord[year][sem][1] +
							", Grade" + courseRecord[year][sem][2]);
			}
		}
	}

	

	//year semester?
	//current ?
	//public static void printGPA(year, semester?) throws IOException {
	public void printTGA() throws IOException {
		
		//calTGA(year,sem);
		for (int year = 0 ; year < MAX_STUDY_YEAR ; year++)
		{
			for (int sem = 0 ; sem < MAX_SEMESTER ; sem++)
			{
				//System.out.println("year=" + year);
				//		System.out.println("sem=" + sem);
				//System.out.println("TGA[0][0]= " + TGA[0][0]);
				//System.out.println("TGA[0][1]= " + TGA[0][1]);
				//System.out.println("TGA[0][2]= " + TGA[0][2]);
				
				calTGA(year,sem);
			}
			

		}
		
		
		
		Scanner input = new Scanner(System.in);
		
		
		String Answer0 = "Y";
		
		while (Answer0.equals("Y"))
		{
			System.out.print("Which year TGA you want to see? (Year 1 to 5)");
			int year=Integer.parseInt(input.nextLine())-1;
			
			String Answer1 = "Y";
			while (Answer1.equals("Y"))
			{
				System.out.print("Which semster of year" + (year+1) + " TGA you want to see? (Fall (Type 1) / Winter (Type 2) / Spring (Type 3) / Summer (Type 4) )");
				int sem=Integer.parseInt(input.nextLine())-1;
				
				System.out.println("The TGA of year" + (year+1) + SemIntToWords(sem) + " semester" + "  is " + TGA[year][sem]);
				
				System.out.print("Still have other semster of year" + (year+1) + " TGA you want to see? Y/N: ");
				Answer1=input.nextLine();

			}			
			System.out.print("Still have other year TGA you want to see? Y/N: ");
			Answer0=input.nextLine();

		}
		
		
	
	}
	
	public void printCGA() throws IOException {
		
		calCGA();
		System.out.println("CGA is " + CGA);
	}
	
	public void printGGA() throws IOException {
		
		calGGA();
		System.out.println("GGA is " + GGA);
	}
	

}
