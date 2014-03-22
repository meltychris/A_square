package advanced_sp;


import java.util.Scanner;

public class Activity {
	public static void main(String[] args) {
		int option = Choice.Chooseoption();
		if (option == 1)
		{
			//recommend path
		}
		else if (option == 2)
		{
			UserInfor.studentinput();
			
			if(UserInfor.Major.equals("COMP"))
			{
				Comp_Advancedpath.suggestion();
				Comp_Advancedpath.printout();
			}
			else if (UserInfor.Major.equals("CPEG"))
			{
				Cpeg_Advancedpath.suggestion();
				Cpeg_Advancedpath.printout();
			}
			
		}
		else
			System.out.println("Thx and bye");
	}
}


class Choice{
	public static int Chooseoption() {
		Scanner input = new Scanner(System.in);
		int option = 0;

			System.out.println("# # Choose one of the options below # #");
			System.out.println("Option 1 - Watch Recommend study path");
			System.out.println("Option 2 - Design Advanced Study path");
			System.out.println("Option 0 - Quit App");
			System.out.println("**************************");

			System.out.print("Enter your choice here:");
			option = Integer.parseInt(input.nextLine());

	return option;
}
	
}

class UserInfor{
	public static void studentinput() {
		Scanner input = new Scanner(System.in);
				System.out.print("My Major:");
				Major=input.nextLine();
				
				
				System.out.print("Studied AL Pure(Y/N):");
				Pure=input.nextLine();
				
				
				System.out.print("Study year:");
				Year=Integer.parseInt(input.nextLine());
				
				
				System.out.print("Credits Studied:");
				Credone=Integer.parseInt(input.nextLine());
				
				
				System.out.print("Common Core Studied:");
				CC=input.nextLine();
				
				
				System.out.print("Elective Studied:");
				Elective=input.nextLine();
				
				
				System.out.print("Recommend path's course failed/skipped:");
				Fail=input.nextLine();
				

				System.out.println(Major + "*"+ Pure +"*"+Year+ "*" + Credone+"*"+ CC+"*"+Elective+"*"+Fail);
}	

			
	static public String Major;
	static public String Pure;
	static public int Year;
	static public int Credone;
	static public String CC;
	static public String Elective;
	static public String Fail;
}

class Comp_Advancedpath extends UserInfor{
	public static void suggestion(){	
		
		if ((Credneed/(3 - Year))>=42)
			Defer = true;
		else Defer = false;
		
		Year1Suggest= "SELECT Course from Year1 where course name != 'CC'";
		Year1Suggest = "SELECT Course from Year1Suggest where course name != 'Elective'";
		
		Year2Suggest= "SELECT Course from Year2 where course name != 'CC'";
		Year2Suggest = "SELECT Course from Year2Suggest where course name != 'Elective'";
		
		Year3Suggest= "SELECT Course from Year3 where course name != 'CC'";
		Year3Suggest = "SELECT Course from Year3Suggest where course name != 'Elective'";
		
		
		if (Pure.equals("N") == true&& Year == 1 )
		{
			Year2Suggest = Year2Suggest+"MATH 2011"+"MATH 2111";
		}
		
		if (Year==1)
		{
			if (Fail.equals("SELECT Course from Year1Suggest where course name= 'Fail")==true)
				Year2Suggest = Year2Suggest + Fail;
		}
		else if (Year==2)
		{
			if (Fail.equals("SELECT Course from Year1Suggest where course name= 'Fail")||
					Fail.equals("SELECT Course from Year2Suggest where course name= 'Fail")==true)
				Year3Suggest = Year3Suggest + Fail;
		}

		
	}
	public static void printout(){
		if (Defer == true)
			System.out.println("Sorry you need to defer");
		else System.out.println("Congraduation! you can grad on time");
		
		System.out.println("Suggest Year1 study:");
		System.out.println(Year1Suggest);
		System.out.println("Suggest Year2 study:");
		System.out.println(Year2Suggest);
		System.out.println("Suggest Year1 study:");
		System.out.println(Year3Suggest);
	}
	static String Year1 = "Select course code from database where recommended year = year1";
	static String Year2 = "Select course code from database where recommended year = year2";
	static String Year3 = "Select course code from database where recommended year = year3";
	static int Credneed = 90 - Credone;
	static boolean Defer;
	static String Year1Suggest;
	static String Year2Suggest;
	static String Year3Suggest;
}

class Cpeg_Advancedpath extends UserInfor{
	public static void suggestion(){
		Scanner input3 = new Scanner(System.in);
		System.out.println("As CPEG student, choose COMP or ELEC approach?");
		approach= input3.nextLine();
		
		Year1Suggest= "SELECT Course from Year1 where course name != 'CC'";
		Year1Suggest = "SELECT Course from Year1Suggest where course name != 'Elective'";
		
		Year2Suggest= "SELECT Course from Year2 where course name != 'CC'";
		Year2Suggest = "SELECT Course from Year2Suggest where course name != 'Elective'";
		
		Year3Suggest= "SELECT Course from Year3 where course name != 'CC'";
		Year3Suggest = "SELECT Course from Year3Suggest where course name != 'Elective'";
		
	}
	
	
	public static void printout(){
		if (Defer == true)
			System.out.println("Sorry you need to defer");
		else System.out.println("Congraduation! you can grad on time");
		
		System.out.println("Suggest Year1 study:");
		System.out.println(Year1Suggest);
		System.out.println("Suggest Year2 study:");
		System.out.println(Year2Suggest);
		System.out.println("Suggest Year1 study:");
		System.out.println(Year3Suggest);
	}
	static String approach;
	static String Year1 = "Select course code from database where recommended year = year1";
	static String Year2 = "Select course code from database where recommended year = year2";
	static String Year3 = "Select course code from database where recommended year = year3";
	static int Credneed = 90 - Credone;
	static boolean Defer;
	static String Year1Suggest;
	static String Year2Suggest;
	static String Year3Suggest;
}
