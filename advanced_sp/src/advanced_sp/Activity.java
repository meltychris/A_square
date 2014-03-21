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
			
			Advancedpath.suggestion();
			
			Advancedpath.printout();
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

class Advancedpath extends UserInfor{
	public static void suggestion(){	
		
		if ((Credneed/(3 - Year))>=42)
			Defer = true;
		else Defer = false;
		
		if (Pure.equals("N") == true&& Year == 1 )
		{
			Year2 = Year2+"MATH 2011"+"MATH 2111";
		}
		
	}
	public static void printout(){
		if (Defer == true)
			System.out.println("Sorry you need to defer");
		else System.out.println("Congraduation! you can grad on time");
		
		System.out.println("Suggest Year1 study:");
		System.out.println(Year1);
		System.out.println("Suggest Year2 study:");
		System.out.println(Year2);
		System.out.println("Suggest Year1 study:");
		System.out.println(Year3);
	}
	static String Year1 = "nothing";
	static String Year2 = "nothing";
	static String Year3 = "nothing";
	static String Path;
	static int Credneed = 90 - Credone;
	static boolean Defer;
}