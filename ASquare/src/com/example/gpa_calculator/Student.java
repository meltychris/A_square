package com.example.gpa_calculator;

import java.util.ArrayList;

import android.app.Activity;
import android.widget.Toast;


//This file contains all functions used by android

public class Student extends Activity {

		public static final int MAX_STUDY_YEAR = 5;
		public static final int MAX_SEMESTER = 4;
		public static final int MAX_SEM_COURSES = 10;
		//int currentYear;
		//int currentSem;
		public double CGA = 0;
		double GGA = 0;	
		
		//TGA for each sem
		//no need to initialize, all 0.0
		double[][] TGA = new double[MAX_STUDY_YEAR][MAX_SEMESTER];
		

		//before 13/4 [4]
		//courseRecord[year][sem][course][name/credit/grade/course code without space]
		//why course code at last, as forgotten to add in the initial stage
		
		//after 13/4 [3]
		//courseRecord[year][sem][course][course code without space/credit/grade]
		//course name deleted as required large no. of database or user input
		
		//no need to initialize, all null
		public String[][][][] courseRecord = new String[MAX_STUDY_YEAR][MAX_SEMESTER][MAX_SEM_COURSES][3];
		

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
				//TODO change here output
				//System.out.println("The grade cannot be converted, there is a bug");
				//System.out.println("Program exit!");
				//System.exit(0);
			}
			
			return strGrade;
	
		}
		
	
		
	
	public void insertCourseRecord(int year, int sem, String courseCode, String credit, String grade) {
	
	
		
	//Now assume android no need to check these
	/*	
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
	*/	
		
		//checked already, whether will out of bound
		year_sem_course_counter[year][sem]++;
		
		//Find null row to insert
		//boolean inserted = false;
		for (int course = 0 ; course < MAX_SEM_COURSES ; course++)
		{		
			if (courseRecord[year][sem][course][0] == null)
			{
				courseRecord[year][sem][course][0] = courseCode;
				courseRecord[year][sem][course][1] = credit;
				courseRecord[year][sem][course][2] = grade;
				//courseRecord[year][sem][course][3] = 
				
				//inserted = true;
				
				//inserted
				break;
			}
		}
		
	/*	
		if (inserted == false)
		{
			System.out.println("There is a bug, the recorded is not insered! Fix it! ");
			return;
		}
	*/	
		
		//as new record inserted, all things needed to update
		updateAll();
	
		
	}
		

	//ONLY condition 1 from diff_performance_advice() will come to here
	//Clicking the above button will show the improvement needed to reach the target CGA,
	//e.g.: "You need a term grade average (TGA) of A or above to get a CGA A-"
	public String adviceMinGradePointRequiredForCGA(int currentYear, int currentSem, double no_of_credit_taken_current_sem, double targetCGA) {
		
		//ensure all data in the TGA array,CGA and GGA in the latest version
		updateAll();
		
		//create a currentCGA to avoid careless modification of global varable CGA
		
		
		//cal CGA from 1st term to right before the current sem
		//exclude the info in the current sem and any later sem
		double currentCGA = calCGAUntilYearSem(currentYear, currentSem);
		
		//double currentCGA = 16/13;
				
//		double diffCGA = currentCGA - targetCGA;
		
		//	if (diffCGA < 0)
		//	{
		//		
		//		//currentCGA is poorer
		//		System.out.println("Your current CGA is lower than your target CGA! Improvement is needed!");
		//		//continue in the this function to give advices
		//		
		//	}
		//	
//		if (diffCGA > 0)
//		{
//			//currentCGA is better
//			return "Your current CGA is higher than your target CGA!";
//		}
//		else if (diffCGA == 0)//diff = 0
//		{
//			return "Your currentCGA same as your target CGA!";
//		}
		
		
			
		//diffCGA is useless onwards	
//		//cast to +ve
//		diffCGA = (-1)*diffCGA;
		
		//start advising
		
		
		//for loop to get total credit taken before
		double total_credit_taken_without_current_sem = 0;
		//<=
		for (int year = 0 ; year <= currentYear ; year++)
		{
			//<, skip currentsem, add that out of the loop
			for (int sem = 0 ; sem < MAX_SEMESTER ; sem++)
			{
				//reach the current year AND sem
				if ((year == currentYear)&&(sem == currentSem))
				{
					break;
				}
				
				total_credit_taken_without_current_sem = total_credit_taken_without_current_sem + year_sem_credit_counter[year][sem];

			}
		}		
		//add credit of current sem taken also
		double total_credit_taken = total_credit_taken_without_current_sem + no_of_credit_taken_current_sem;
		
		
		if (total_credit_taken <= 0)
		{
			return "You don't have any course record input in our calculator function!";
		}
		
		// = (targetCGA*total_credit_taken)-grade point of year1 fall to summer exclude year2 sem1 and sem after that
		double minTargetGradePointforCGA = (targetCGA*total_credit_taken)-(currentCGA*total_credit_taken_without_current_sem);
		
		//currentCGA is poorer, continue in the this function to give advices
		return "Your current CGA is lower than your target CGA! \nImprovement is needed! \n" +
				"In order to achieve the target CGA " + targetCGA + " in current semester, Year " + (currentYear+1) + " " + SemIntToWords(currentSem) + " Semester, \nYou need to raise Minimum Grade Point " + minTargetGradePointforCGA + " or above!";
	

	}

		
		
	
/*	
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
*/		
		
/*	
	public void delCourseRecord(int year, int sem, int course_to_del) {
		
		System.out.println("Delete CourseRecord func starts");
		
		//Array!!! drawback, if del record in middle....deal with them here!!!!!!!!!!!!
		//String->>>null
		
		courseRecord[year][sem][course_to_del][0] = null;
		courseRecord[year][sem][course_to_del][1] = null;
		courseRecord[year][sem][course_to_del][2] = null;
		//courseRecord[year][sem][course_to_del][3] = null;
		
	
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
				//courseRecord[year][sem][counter][3] = courseRecord[year][sem][counter+1][3];
			
				//del duplicated old record
				courseRecord[year][sem][counter+1][0] = null;
				courseRecord[year][sem][counter+1][1] = null;
				courseRecord[year][sem][counter+1][2] = null;
				//courseRecord[year][sem][counter+1][3] = null;
			}
		}
		
		
		//update all record after deletion
		updateAll();
		
		
	}
*/	
	//independent of delCourseRecord()
	public void resetAllRecord() {
		
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
					//courseRecord[year][sem][course][3] = null;
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
	public void modifyCourseRecord() {
		
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
	
	public void updateAll()  {
		
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
	
	public void  update_year_sem_course_counter()  {
			
		
		
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
	
	public void update_year_sem_credit_counter() {
		
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
	
	
	public void calAllTGA() {
		
		for (int year = 0 ; year < MAX_STUDY_YEAR ; year++)
		{
			for (int sem = 0 ; sem < MAX_SEMESTER ; sem++)
			{
				calTGA(year,sem);
			}
		}		
	}
	
	

	//parameter  year,semester
	public void calTGA(int year, int sem) {
		
		//as calculation will give out decimal point number
		double sum_of_grade_point = 0;

		for (int i = 0 ;  i  < year_sem_course_counter[year][sem] ; i++)
		{
			sum_of_grade_point = sum_of_grade_point + GradeToNum(courseRecord[year][sem][i][2])*Integer.parseInt(courseRecord[year][sem][i][1]);

		}
	
		if (year_sem_credit_counter[year][sem] == 0)
		{
			TGA[year][sem] = 0;
		}
		else
		{
			TGA[year][sem] = sum_of_grade_point/year_sem_credit_counter[year][sem];
		}
	}
	
	public void calCGA() {
		
		double sum_of_grade_point = 0;
		int sum_of_all_credit_taken = 0;
		

		for (int year = 0; year < MAX_STUDY_YEAR ; year++)
		{	
			for (int sem = 0;sem < MAX_SEMESTER ; sem++)
			{				
				sum_of_grade_point = sum_of_grade_point +  TGA[year][sem]*year_sem_credit_counter[year][sem];
				sum_of_all_credit_taken = sum_of_all_credit_taken +  year_sem_credit_counter[year][sem];
			}
		}
		
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
	
	//This function, you pass year2 fall
	//then only CGA from year1 fall to summer is calculated
	//exclude the course record of year2 fall and after year2 fall
	//to avoid the side effect if the users has input some course record that they are not taken yet at the moment
	public double calCGAUntilYearSem(int currentYear, int currentSem) {
		
		double sum_of_grade_point = 0;
		int sum_of_all_credit_taken = 0;
		
		//<=
		for (int year = 0; year <= currentYear ; year++)
		{	
			//<
			for (int sem = 0 ; sem < MAX_SEMESTER ; sem++)
			{	
				//reach the current year AND sem
				if ((year == currentYear)&&(sem == currentSem))
				{
					break;
				}
				
				sum_of_grade_point = sum_of_grade_point +  TGA[year][sem]*year_sem_credit_counter[year][sem];
				sum_of_all_credit_taken = sum_of_all_credit_taken +  year_sem_credit_counter[year][sem];
			}
		}
		
		
		//avoid division by zero NaN
		if (sum_of_all_credit_taken == 0)
		{
			return 0;
		}
		else
		{
			return (sum_of_grade_point/sum_of_all_credit_taken);
		}
		
		
		
	}
	
	public double cal_CGA_without_1st_sem()  {
		
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
	
	public void calGGA() {
		
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


				}
				else {
					sum_of_grade_point = sum_of_grade_point +  TGA[year][sem]*year_sem_credit_counter[year][sem];
					
					sum_of_all_credit_taken = sum_of_all_credit_taken +  year_sem_credit_counter[year][sem];

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
	public ArrayList<String> printTGA()  {
		
		
		calAllTGA();
		
		//to pay safe
		updateAll();
		
		ArrayList<String> return_print_arraylist = new ArrayList<String>();
		
		for (int year = 0 ; year < MAX_STUDY_YEAR ; year++)
		{
			for (int sem = 0 ; sem < MAX_SEMESTER ; sem++)
			{
				
				//ignore the semester without any input of course course record
				if (year_sem_course_counter[year][sem] == 0)
				{
					//not break, still have to check other sem
					continue;
				}
				
				return_print_arraylist.add("Year " + (year+1) + " " + 
											SemIntToWords(sem) + "\n" + 					 
											TGA[year][sem]
											);
				
			}
		}

		return return_print_arraylist;
	}
		
	
	public ArrayList<String> printWarningTGA()  {
		
		//Academic Warning
		//If your term grade average (TGA) or cumulative grade average (CGA) is less than 1.7 at the end of any regular term
		//you will be placed on academic warning and required to seek academic advice.
		//Reference: http://ugadmin.ust.hk/ug-guide/assessment/probation.html
		
		//loop all TGA array
		//if have this condition, record which year,sem , pop-up window in android
		
		ArrayList<String> return_print_arraylist = new ArrayList<String>();
		
		for (int year = 0 ; year < MAX_STUDY_YEAR ; year++)
		{
			for (int sem = 0 ; sem < MAX_SEMESTER ; sem++)
			{
				
				//ignore the semester without any input of course course record
				if (year_sem_course_counter[year][sem] == 0)
				{
					//not break, still have to check other sem
					continue;
				}
				

				//record down if there is a sem TGA is not >= 1.7
				if ( TGA[year][sem] < 1.7 )
				{
					//below 4 lines warning moved to printTGA.java
					//System.out.println("According to UST ACADEMIC REGULATIONS for student, Academic Probation & Dismissal,");
					//System.out.println("You are now placed on Academic Warning and required to seek academic advice.");
					//System.out.println("as your TGA in year " + (year+1) + SemIntToWords(sem) + " semester is < 1.7");
					//System.out.println("Please work hard! :) ");
					
					//as year and sem can only be 1 digit each, combine it together for easy printing
					//later needed to 1.convert to int, 2.use division to decompose the int to year, sem
					return_print_arraylist.add(Integer.toString(year+1) + Integer.toString(sem+1));
				}
			}
		}
		
		return return_print_arraylist;
		
		
		
	}
	
	public String printCGA() {
		
		calCGA();
		//print below
		//System.out.println("CGA is " + CGA);
		
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
			//System.out.println("According to UST ACADEMIC REGULATIONS for student, Academic Probation & Dismissal,");
			//System.out.println("You are now placed on Academic Warning and required to seek academic advice.");
			//System.out.println("as your CGA is < 1.7");
			//System.out.println("Please work hard! :) ");
			
			return ("Your CGA is " + CGA + "\n" +
					"According to UST ACADEMIC REGULATIONS for student, Academic Probation & Dismissal," + "\n" +
					"You are now placed on Academic Warning and required to seek academic advice." + "\n" +
					"as your CGA is < 1.7" +
					"Please work hard! :) "
					);
		}
		else if (CGA_without_1st_sem < 1.5)
		{
			//System.out.println("According to UST ACADEMIC REGULATIONS for student, Academic Probation & Dismissal,");
			//System.out.println("You are now put on Academic Probation.");
			//System.out.println("as your CGA is < 1.5 at the end of any fall or spring term, excluding your first regular term at the University.");
			//System.out.println("You need to obtain approval to enroll in courses, and may be required to reduce your study load.");
			//System.out.println("You will remain on academic probation until your CGA rises to 1.5 or above.");
			//System.out.println("Please work hard! :) ");
			
			return ("Your CGA is " + CGA + "\n" +
					"According to UST ACADEMIC REGULATIONS for student, Academic Probation & Dismissal," + "\n" +
					"You are now put on Academic Probation." + "\n" +
					"as your CGA is < 1.5 at the end of any fall or spring term, excluding your first regular term at the University." + "\n" +
					"You need to obtain approval to enroll in courses, and may be required to reduce your study load." + "\n" +
					"You will remain on academic probation until your CGA rises to 1.5 or above." + "\n" +
					"Please work hard! :) "
					);
		}
		else //Normal, no warning
		{
			return ("Your CGA is " + CGA);
		}
		
		

	}
	
	public String printGGA() {
		
		calGGA();
		return ("Your GGA is " + GGA);
	}
	
	//for android print_course_record.java
	public ArrayList<String> printAllCourse(){
		
		ArrayList<String> return_print_arraylist = new ArrayList<String>();
		
		for (int year = 0 ; year < MAX_STUDY_YEAR ; year++)
		{
			for (int sem = 0 ; sem < MAX_SEMESTER ; sem++)
			{					
				for (int course = 0 ; course < MAX_SEM_COURSES; course++)
				{
					//avoid printing null things
					if (courseRecord[year][sem][course][0] == null)
					{
						break;
					}
					
					return_print_arraylist.add("Year " + (year+1) + " " + 
											SemIntToWords(sem) + "\n" + 					 
											courseRecord[year][sem][course][0] + " " +
											"Credit: " + courseRecord[year][sem][course][1] + " " +
											"Grade: " + courseRecord[year][sem][course][2]);
					
				}

			}
		}
		
		return return_print_arraylist;
		
	}

	
}