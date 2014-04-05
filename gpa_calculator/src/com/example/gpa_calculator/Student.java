package com.example.gpa_calculator;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {

		public static final int MAX_STUDY_YEAR = 5;
		public static final int MAX_SEMESTER = 4;
		public static final int MAX_SEM_COURSES = 10;
		//int currentYear;
		//int currentSem;
		double CGA = 0;
		double GGA = 0;	
		
		//TGA for each sem
		//no need to initialize, all 0.0
		double[][] TGA = new double[MAX_STUDY_YEAR][MAX_SEMESTER];
		

		
		//courseRecord[year][sem][course][name/credit/grade/course code without space]
		//why course code at last, as forgotten to add in the initial stage
		//no need to initialize, all null
		String[][][][] courseRecord = new String[MAX_STUDY_YEAR][MAX_SEMESTER][MAX_SEM_COURSES][4];
		

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
	
		public String NumToGrade(double targetCourseGrade)
		{
			String strGrade = null;
			
			if (targetCourseGrade == 4.3)
			{
				strGrade = "A+";
				
			}
			else if (targetCourseGrade == 4)
			{
				strGrade = "A";
	
			}
			else if (targetCourseGrade == 3.7)
			{
				strGrade = "A-";
				
			}
			else if (targetCourseGrade == 3.3)
			{
				strGrade = "B+";
				
			}
			else if (targetCourseGrade == 3)
			{
				strGrade = "B";
				
			}
			else if (targetCourseGrade == 2.7)
			{
				strGrade = "B-";
				
			}
			else if (targetCourseGrade == 2.3)
			{
				strGrade = "C+";
				
			}
			else if (targetCourseGrade == 2)
			{
				strGrade = "C";
				
			}
			else if (targetCourseGrade == 1.7)
			{
				strGrade = "C-";
				
			}
			else if (targetCourseGrade == 1)
			{
				strGrade = "D";
			}
			else if (targetCourseGrade == 0)
			{
				strGrade = "F";
			}
			else
			{
				System.out.println("The grade cannot be converted, there is a bug");
				System.out.println("Program exit!");
				System.exit(0);
			}
			
			return strGrade;
	
		}
		

		public void insertCourseRecordEnquiry()throws IOException {
			
			String Answer0 = "Y";
			
			while (Answer0.equals("Y"))
			{					
				int year;
				int sem;		
			
				Scanner input = new Scanner(System.in);

				System.out.print("Course Study year (Type 1-5) : ");
				year=Integer.parseInt(input.nextLine()) - 1;
				
				String Answer1 = "Y";
				
				while (Answer1.equals("Y"))
				{
						
					System.out.print("Which Semester is the course taken in year " + year + "  Fall (Type 1) / Winter (Type 2) / Spring (Type 3) / Summer (Type 4) : ");
					sem=Integer.parseInt(input.nextLine()) - 1;
					
					String Answer2 = "Y";
				
					while (Answer2.equals("Y"))
					{
						System.out.print("Course Code (without space): ");
						String courseCode=input.nextLine();
				
						System.out.print("Course Name: ");
						String courseName=input.nextLine();

						System.out.print("Credits Studied: ");
						String credit=input.nextLine();

						System.out.print("Grade: ");
						String grade=input.nextLine();
						
						//!!
						insertCourseRecord(year,sem,courseName, credit, grade, courseCode);
						
						System.out.print("Still have other course information to input for Year" + (year+1) + " Sem" + (sem+1) + "? Y/N: ");
						Answer2=input.nextLine();
						
			
					}
					System.out.print("Still have other course information to input for Year" + (year+1) + "? Y/N: ");
					Answer1=input.nextLine();
				
				}
				System.out.print("Still have other course information to input ? Y/N: ");
				Answer0=input.nextLine();
			}
			

	}

	public void insertCourseRecord(int year, int sem, String courseName, String credit, String grade, String courseCode)throws IOException {
		
		//as year sem are array index
		if (year >= MAX_STUDY_YEAR)
		{
			System.out.println("year exceeds the range!, insertCourseRecord() end");
			return;
		}
		
		if (sem >= MAX_SEMESTER)
		{
			System.out.println("sem exceeds the range!, insertCourseRecord() end");
			return;
		}
		
		if (year_sem_course_counter[year][sem] > MAX_SEM_COURSES)
		{
			System.out.println("Year " + year + " Sem " + sem + " reach the max. no. of enrolled course!, insertCourseRecord() end");
			return;
		}
		
		//checked already, whether will out of bound
		year_sem_course_counter[year][sem]++;
		
		//Find null row to insert
		boolean inserted = false;
		for (int course = 0 ; course < MAX_SEM_COURSES ; course++)
		{		
			if (courseRecord[year][sem][course][0] == null)
			{
				courseRecord[year][sem][course][0] = courseName;
				courseRecord[year][sem][course][1] = credit;
				courseRecord[year][sem][course][2] = grade;
				courseRecord[year][sem][course][3] = courseCode;
				
				inserted = true;
				
				//inserted
				break;
			}
		}
		
		if (inserted == false)
		{
			System.out.println("There is a bug, the recorded is not insered! Fix it! ");
			return;
		}
		
		//as new record inserted, allthings needed to update
		updateAll();
	
		
	}
		


	//Bottom left position show the button with figure "-x.y" e.g. "-0.3" 
	//to show the difference between target CGA and actual performance (1 d.p.)
	
	//Clicking the above button will show the improvement needed to reach the target CGA,
	//e.g.: "You need a term grade average (TGA) of A or above to get a CGA A-"
	public void diff_performance_advice() throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your current year? (Type 1-5)");
		int currentYear=Integer.parseInt(input.nextLine()) - 1;
		
		
		System.out.println("What is your current semester of year" + currentYear + "? (Fall (Type 1) / Winter (Type 2) / Spring (Type 3) / Summer (Type 4)");
		int currentSem=Integer.parseInt(input.nextLine()) - 1;
		
		//need to use exception to check input?
		System.out.println("What is your target CGA (Type 0.0 - 4.3)");
		double targetCGA=Double.parseDouble(input.nextLine());
		
		//ensure all data in the TGA array,CGA and GGA in the latest version
		updateAll();
		
		//create a currentCGA to avoid careless modification of global varable CGA
		double currentCGA = CGA;
				
		double diffCGA = currentCGA - targetCGA;
		
		if (diffCGA < 0) {
			
			//currentCGA is poorer
			System.out.println("Your current CGA is lower than your target CGA! Improvement is needed!");
			//continue in the this function to give advices
			
		}
		else if (diffCGA > 0){
			
			//currentCGA is better
			System.out.println("Your current CGA is higher than your target CGA!");
			System.out.println("CGA performance comparison is end");
			return;
		}
		else //diff = 0
		{
			System.out.println("Your currentCGA same as your target CGA!");
			System.out.println("CGA performance comparison is end");
			return;
		}
	
		
		
		
		//ONLY condition 1 will come to here
		//Clicking the above button will show the improvement needed to reach the target CGA,
		//e.g.: "You need a term grade average (TGA) of A or above to get a CGA A-"
		
		//ask whether user needs Advice on grade 
		
		//cast to +ve
		diffCGA = (-1)*diffCGA;
		
		System.out.println("Do you want advices for rasing grade of courses to achieve the target CGA? Y/N ");
		String ans = input.nextLine();
		if (ans.equals("N"))
		{
			System.out.println("End of function of comparing target CGA with actual performance");
			return;
		}
		
		
		System.out.println("Now referring to advising function");
		advice(diffCGA,currentYear,currentSem);
		

		System.out.println("End of function of comparing target CGA with actual performance and giving advices");
	}

	
	
	//ONLY condition 1 from diff_performance_advice() will come to here
	//Clicking the above button will show the improvement needed to reach the target CGA,
	//e.g.: "You need a term grade average (TGA) of A or above to get a CGA A-"
	public void advice(double diffCGA, int currentYear, int currentSem) {
		
		
		//grade to raise for specific no. of credit course
	
		
		//loop for each course to check what can the user to raise the grade to achieve the targetCGA
		//year_sem_course_counter[currentYear][currentSem] is from 0-max 5			
		for (int counter = 0 ; counter <= year_sem_course_counter[currentYear][currentSem] ; counter++)
		{
			
			//diffCGA*total sem credit <= course1 grade*course1 credit
			//diffCGA*total sem credit / course1 credit = course1 grade <<
			
			if (courseRecord[currentYear][currentSem][counter][1] == null)
			{
				//none at all or no further record, stop advice
				return;
			}
			
			double targetCourseGrade = 
					(diffCGA*year_sem_credit_counter[currentYear][currentSem]) / 
					(Double.parseDouble(courseRecord[currentYear][currentSem][counter][1]));
			
			//covert targetCourseGrade to real grade A+ to F
			String strGrade = NumToGrade(targetCourseGrade);
			
			//DO NOT print the statement if the current!!!!!!! course 1 is already A+, 4.3
			if (Double.parseDouble(courseRecord[currentYear][currentSem][counter][2]) < 4.3)
			{
				System.out.println("In order to achieve the target CGA,");
				System.out.println("You need to obtain grade" + strGrade + " or above from " + courseRecord[currentYear][currentSem][counter][0] + ". Now grade of this course is " + courseRecord[currentYear][currentSem][counter][2]);
			}
			

		}
		
		
	}

	
	public void delCourseRecordEnquiry()throws IOException {
		
		//Ask which year
		//which sem
		//print out course list of that year, sem
		//ask del which or del ALL
		
		System.out.println("delCourseRecordEnquiry() function starts.");
		
		String Answer0 = "Y";
		int i = 0;
		
		while (Answer0.equals("Y"))
		{
			Scanner input = new Scanner(System.in);

			System.out.print("The course you want to delete is in year ___ ? (Type 1-5): ");
			int year=Integer.parseInt(input.nextLine()) - 1;
			
			String Answer1 = "Y";
			int j = 0;
			
			while (Answer1.equals("Y") && (year < MAX_STUDY_YEAR))
			{
					
				System.out.print("The course you want to delete is in year " + (year+1) + " Semester ___ ? (Fall (Type 1) / Winter (Type 2) / Spring (Type 3) / Summer (Type 4): ");
				int sem=Integer.parseInt(input.nextLine()) - 1;
				
				if (year_sem_course_counter[year][sem] == 0)
				{
					System.out.println("No course is taken in Year "+ (year+1) + " Semester " + (sem+1) + ". Nothing can be deleted!");
					System.out.println("Exit from this sem");
					break;
				}
				
				String Answer2 = "Y";
				int k = 0;
			
				while (Answer2.equals("Y") && (year_sem_course_counter[year][sem] <= MAX_SEM_COURSES))
				{
					printCourses(year, sem);
					
					System.out.print("Which course you want to delete in the above list course record in year" + (year+1) + " " + SemIntToWords(sem) + "Semester? (Type 1-10 to indicate the course) : ");
					int course_to_del = Integer.parseInt(input.nextLine()) - 1;

					delCourseRecord(year, sem, course_to_del);
					
					System.out.print("Still have other course to delete for Year" + (year+1) + " Sem" + (sem+1) + "? Y/N: ");
					Answer2=input.nextLine();
					
					k++;
		
				}
				System.out.print("Still have other course to delete for Year" + (year+1) + "? Y/N : ");
				Answer1=input.nextLine();
				j++;
			
			}
			System.out.print("Still have other course to del ? Y/N : ");
			Answer0=input.nextLine();
		}
			
	}
		
		
	
	public void delCourseRecord(int year, int sem, int course_to_del)throws IOException {
		
		System.out.println("Delete CourseRecord func starts");
		
		//Array!!! drawback, if del record in middle....dual with here!!!!!!!!!!!!
		//String->>>null
		
		courseRecord[year][sem][course_to_del][0] = null;
		courseRecord[year][sem][course_to_del][1] = null;
		courseRecord[year][sem][course_to_del][2] = null;
		courseRecord[year][sem][course_to_del][3] = null;
		
	
		//PACK UP CourseRecord, no null record between some non-null record
		//lower record to up if the lower one is not null OR last record (becareful out bound array)
		
		//MAX_SEM_COURSES-1 = 9, to avoid out bound array, if course_to_del already is the last row [9]	
		for (int counter = course_to_del ; counter < MAX_SEM_COURSES-1 ; counter++)
		{		
			if (courseRecord[year][sem][counter+1][0] == null)
			{
				//nothing to push up already, below is all null
				break;
			}
			else // have record in courseRecord[year][sem][counter+1]
			{
				courseRecord[year][sem][counter][0] = courseRecord[year][sem][counter+1][0];
				courseRecord[year][sem][counter][1] = courseRecord[year][sem][counter+1][1];
				courseRecord[year][sem][counter][2] = courseRecord[year][sem][counter+1][2];
				courseRecord[year][sem][counter][3] = courseRecord[year][sem][counter+1][3];
			
				//del duplicated old record
				courseRecord[year][sem][counter+1][0] = null;
				courseRecord[year][sem][counter+1][1] = null;
				courseRecord[year][sem][counter+1][2] = null;
				courseRecord[year][sem][counter+1][3] = null;
			}
		}
		
		
		//update all record after deletion
		updateAll();
		
		
	}
	
	//independent of delCourseRecord()
	public void resetAllRecord()throws IOException {
		
		System.out.println("Reset All Record");
		
		//loop all delCourseRecord	
		for (int year = 0 ; year < MAX_STUDY_YEAR ; year++)
		{
			for (int sem = 0 ; sem < MAX_SEMESTER ; sem++)
			{
				for (int course = 0 ; course < MAX_SEM_COURSES ; course++)
				{
					courseRecord[year][sem][course][0] = null;
					courseRecord[year][sem][course][1] = null;
					courseRecord[year][sem][course][2] = null;
					courseRecord[year][sem][course][3] = null;
				}
			}
		}
		
		
		//Set all int array to 0	
		for (int year = 0 ; year < MAX_STUDY_YEAR ; year++)
		{
			for (int sem = 0 ; sem < MAX_SEMESTER ; sem++)
			{
				TGA[year][sem] = 0;
				year_sem_course_counter[year][sem] = 0;
				year_sem_credit_counter[year][sem] = 0;
			}
		}

		CGA = 0;
		GGA = 0;	
		
		//update all record after deletion
		updateAll();
		
		
	}
	
	/*
	//del then insert?
	public void modifyCourseRecord()throws IOException {
		
		System.out.println("Modify Course Record");
		//ask for operation, insert new,del, change content
		//1 ask for year sem
		//2 print list of that year sem, course code ,name , credit, grade
		//3 choose 1 course code to modify
		//4 ask change name/credit/grade [year][sem][course][name/credit/grade]
		
		
		//just del and re-enter???
		
		
		//update all record after modification
		updateAll();
		
	}
	*/
	
	
	
	//Every time after modifying the data of array, calTGA, calCGA, calGGA must be executed
	//CGA and GGA both based on TGA array
	
	//¥¼write update function!!!!!!!!!!!!!
	//int[][] year_sem_course_counter = new int[MAX_STUDY_YEAR][MAX_SEMESTER];
	//int[][] year_sem_credit_counter = new int[MAX_STUDY_YEAR][MAX_SEMESTER];
	//as they also needed to be updated!
	
	public void updateAll() throws IOException {
		
		//NOT finished the update func
		//year_sem_credit_counter  needed to be updated before year_sem_course_counter
		//year_sem_course_counter and year_sem_credit_counter needed to be updated 
		//before execution of calAllTGA() , calCGA() and calGGA()
		//and 3 cal is basing on them!!!
		//Therefore, sequence, year_sem_course_counter, year_sem_credit_counter, TGA, CGA, GGA
		update_year_sem_course_counter();
		update_year_sem_credit_counter();
		calAllTGA();
		calCGA();
		calGGA();
	}
	
	public void  update_year_sem_course_counter() throws IOException {
			
		
		
		for (int year = 0; year < MAX_STUDY_YEAR; year++)
		{			
			for (int sem = 0; sem < MAX_SEMESTER; sem++)
			{
				year_sem_course_counter[year][sem] = 0; //set the array content to be 0, for incrementing during the counter loop
				
				for (int course = 0 ; course < MAX_SEM_COURSES ; course++)
				{					
					if ( courseRecord[year][sem][course][0] == null) 
					{
						//that year that sem that course row is empty
					}
					else
					{
						//not empty
						year_sem_course_counter[year][sem]++;
					}
				}
				
			}
		}
		
	}
	
	public void update_year_sem_credit_counter() throws IOException {
		
		for (int year = 0; year < MAX_STUDY_YEAR; year++)
		{			
			for (int sem = 0; sem < MAX_SEMESTER; sem++)
			{
				year_sem_credit_counter[year][sem] = 0; //set the array content to be 0, for incrementing during the counter loop
				
				for (int course = 0 ; course < MAX_SEM_COURSES ; course++)
				{
					if ( courseRecord[year][sem][course][0] == null )
					{
						//that year that sem that course row is empty
					}
					else
					{
						//not empty
						year_sem_credit_counter[year][sem] = year_sem_credit_counter[year][sem] + Integer.parseInt(courseRecord[year][sem][course][1]);
					}
				}
				
			}
		}
		
		
		
	}
	
	
	public void calAllTGA() throws IOException {
		
		int year = 0;
		

		while (year < MAX_STUDY_YEAR) {
			int sem = 0;
			while (sem < MAX_SEMESTER) {
				calTGA(year,sem);
				sem++;
			}
			year++;
		}
		
	}
	
	
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
		
		//avoid division by zero NaN
		if (sum_of_all_credit_taken == 0)
		{
			CGA = 0;
		}
		else
		{
			CGA = sum_of_grade_point/sum_of_all_credit_taken;
		}
		
		
		
	}
	
	public double cal_CGA_without_1st_sem() throws IOException {
		
		double sum_of_grade_point = 0;
		int sum_of_all_credit_taken = 0;
		
		
		int year = 0;
		
		//sum_of_grade_point + sum_of_all_credit_taken
		while (year < MAX_STUDY_YEAR)
		{
			int sem;
			
			if (year == 0) 
			{
				sem = 1;//<<cal_CGA_without_1st_sem(), omit 1st sem in year1
			}
			else
			{
				sem = 0;
			}
			
			while (sem < MAX_SEMESTER)
			{
				
				sum_of_grade_point = sum_of_grade_point +  TGA[year][sem]*year_sem_credit_counter[year][sem];
				
				sum_of_all_credit_taken = sum_of_all_credit_taken +  year_sem_credit_counter[year][sem];
				
				sem++;

				
			}
			year++;
		}
		
		double CGA_without_1st_sem = 0;
		
		//avoid division by zero NaN
		if (sum_of_all_credit_taken == 0)
		{
			CGA_without_1st_sem = 0;
		}
		else
		{
			CGA_without_1st_sem = sum_of_grade_point / sum_of_all_credit_taken;
		}
		
		return CGA_without_1st_sem;
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
		
		//avoid division by zero NaN
		if (sum_of_all_credit_taken == 0)
		{
			GGA = 0;
		}
		else
		{
			GGA = sum_of_grade_point / sum_of_all_credit_taken;
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
				
				//Academic Warning
				//If your term grade average (TGA) or cumulative grade average (CGA) is less than 1.7 at the end of any regular term
				//you will be placed on academic warning and required to seek academic advice.
				//Reference: http://ugadmin.ust.hk/ug-guide/assessment/probation.html
				if ( TGA[year][sem] < 1.7 )
				{
					System.out.println("According to UST ACADEMIC REGULATIONS for student, Academic Probation & Dismissal,");
					System.out.println("You are now placed on Academic Warning and required to seek academic advice.");
					System.out.println("as your TGA in year " + (year+1) + SemIntToWords(sem) + " semester is < 1.7");
					System.out.println("Please work hard! :) ");
				}
				
				
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
		
		//Academic Warning
		//If your term grade average (TGA) or cumulative grade average (CGA) is less than 1.7 at the end of any regular term
		//you will be placed on academic warning and required to seek academic advice.
		//Reference: http://ugadmin.ust.hk/ug-guide/assessment/probation.html
		
		//Academic Probation
		//If your CGA falls below 1.5 at the end of any fall or spring term, excluding your first regular term at the University, you will be put on academic probation.
		//You will need to obtain approval to enroll in courses, and may be required to reduce your study load.
		//You will remain on academic probation until your CGA rises to 1.5 or above.
		//Reference: http://ugadmin.ust.hk/ug-guide/assessment/probation.html
		

		
		double CGA_without_1st_sem = cal_CGA_without_1st_sem();
		
		if ( ( CGA >= 1.5 ) && ( CGA < 1.7 ) )
		{
			System.out.println("According to UST ACADEMIC REGULATIONS for student, Academic Probation & Dismissal,");
			System.out.println("You are now placed on Academic Warning and required to seek academic advice.");
			System.out.println("as your CGA is < 1.7");
			System.out.println("Please work hard! :) ");
		}
		else if (CGA_without_1st_sem < 1.5)
		{
			System.out.println("According to UST ACADEMIC REGULATIONS for student, Academic Probation & Dismissal,");
			System.out.println("You are now put on Academic Probation.");
			System.out.println("as your CGA is < 1.5 at the end of any fall or spring term, excluding your first regular term at the University.");
			System.out.println("You need to obtain approval to enroll in courses, and may be required to reduce your study load.");
			System.out.println("You will remain on academic probation until your CGA rises to 1.5 or above.");
			System.out.println("Please work hard! :) ");
		}

	}
	
	public void printGGA() throws IOException {
		
		calGGA();
		System.out.println("GGA is " + GGA);
	}
	
	public void printAllCourses() throws IOException {
		
		//print All course records showing currently studying courses,
		//followed by the courses taken
					
		for (int year = 0 ; year < MAX_STUDY_YEAR ; year++)
		{
			for (int sem = 0 ; sem < MAX_SEMESTER ; sem++)
			{					
				printCourses(year,sem);
			}
		}
	}
	
	public void printCourses(int year, int sem) throws IOException {
		
		//print List of course records of specific year and sem
		
		System.out.println("------------------------------");
		
		System.out.print("List of courses taken in Year" + (year+1) + " " + SemIntToWords(sem) + " Semester :");
		
		System.out.print("------------------------------");
		
		for (int course = 0 ; course < MAX_SEM_COURSES; course++)
		{
			//avoid printing null things
			if (courseRecord[year][sem][course][0] == null)
			{
				System.out.println("------------------------------End of printing Courses------------------------------");
				break;
			}
			
			System.out.println((course+1) + " " + 
								"Course Code: " + courseRecord[year][sem][course][3] + ", " +
								"Course Name: " + courseRecord[year][sem][course][0] + ", " +
								"Credit: " + courseRecord[year][sem][course][1] + ", " +
								"Grade: " + courseRecord[year][sem][course][2]);
		}
		


	}

	//public void printChart(){
	//	
	//}
	
	
	
}