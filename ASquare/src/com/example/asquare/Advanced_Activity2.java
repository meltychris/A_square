package com.example.asquare;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Advanced_Activity2 extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.adv_path_main2);   
	
	    // TODO Auto-generated method stub
	    
	    Bundle params = getIntent().getExtras();
	    if (params!= null) {
	    	Major1 = params.getBoolean ("Major1");
	    	Major2 = params.getBoolean ("Major2");
	    	Pure = params.getBoolean ("Pure");
	    	Year1 = params.getBoolean ("Year1");
	    	Year2 = params.getBoolean ("Year2");
	    	Year3 = params.getBoolean ("Year3");
	    	Sem1 = params.getBoolean ("Sem1");
	    	Sem2 = params.getBoolean ("Sem2");
	    	Credit = params.getString ("Credit");
	    	SA = params.getBoolean ("SA");
	    	S_T = params.getBoolean ("S_T");
	    	A_H = params.getBoolean ("A_H");
	    	Free = params.getBoolean ("Free");
	    	SBM = params.getBoolean ("SBM");
	    	ENGG = params.getBoolean ("ENGG");
	    	FreeE = params.getBoolean ("FreeE");
	    	compx1 = params.getBoolean ("compx1");
	    	compx2 = params.getBoolean ("compx2");
	    	compx3 = params.getBoolean ("compx3");
	    	compx4 = params.getBoolean ("compx4");
	    	compx5 = params.getBoolean ("compx5");
	    	CEMx1 = params.getBoolean ("CEMx1");
	    	CEMx2 = params.getBoolean ("CEMx2");
	    	Fail = params.getString ("Fail");

	    	textView1 = (TextView)findViewById(R.id.textView1);
	        textView1.setText( Boolean.toString(Major1) 
	        		+" & " + Boolean.toString(Major2)+" & " + Boolean.toString(Pure)+" & " +
	        		Boolean.toString(Year1)+" & " + Boolean.toString(Year2)+" & " + Boolean.toString(Year3)+" & "
	        		+ Boolean.toString(Sem1)+" & " + Boolean.toString(Sem2)+" & " + Credit+
	        		" & " + Boolean.toString(S_T)+ " & " + Boolean.toString(A_H)+ " & " + Boolean.toString(Free)
	        		+ " & " + Boolean.toString(SBM)+ " & " + Boolean.toString(ENGG)+ " & " + 
	        		Boolean.toString(FreeE)+ " & " + Boolean.toString(compx1)+ " & " + Boolean.toString(compx2)
	        		+ " & " + Boolean.toString(compx3)+ " & " + Boolean.toString(compx4)+ " & " +
	        		Boolean.toString(compx5)+ " & " +
	    	        		Boolean.toString(CEMx1)+ " & " +
	    	    	        		Boolean.toString(CEMx2)+ " & " +
	    	    	        		Fail);
	    }
	    


/*	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    // TODO Auto-generated method stub
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




	    				System.out.print("Semester:(Fall/Spring):");
	    				Sem=input.nextLine();




	    				System.out.print("Credits Studied:");
	    				Credone=Integer.parseInt(input.nextLine());




	    				System.out.print("Common Core Studied:(HUMA/SCIS/SOSC)"); // checkbox huma, science, sosc 
	    				CC=input.nextLine();




	    				System.out.print("Elective Studied:"); // checkbox COMP, ELEC, ENGG
	    				Elective=input.nextLine();




	    				System.out.print("Recommend path's course failed/skipped:"); // checkbox of recommended path
	    				Fail=input.nextLine();




	    				System.out.println(Major + "*"+ Pure +"*"+Year+ "*" + Credone+"*"+ CC+"*"+Elective+"*"+Fail);
	    }	




	    	static public String Major;
	    	static public String Pure;
	    	static public int Year;
	    	static public String Sem;
	    	static public int Credone;
	    	static public String CC;
	    	static public String Elective;
	    	static public String Fail;
	    }




	    class Comp_Advancedpath extends UserInfor{
	    	public static void suggestion(){	


	    		if (Sem.equals("fall"))
	    			{
	    				if((Credneed/(2*(3-Year)+1))>=21)
	    				Defer = true;
	    				else Defer = false;
	    				SemtoGrad= 2*(3-Year)+1;
	    			}
	    		else 
	    			{
	    			if( Year==3 && Credneed!=0 || (Credneed/(2*(3-Year)))>=21)
	    				Defer = true;
	    				else Defer = false;
	    			SemtoGrad= 2*(3-Year);
	    			}


	    		Year1Suggest= "SELECT Course from Year1 where course name != 'CC'";
	    		Year1Suggest = Year1Suggest + "SELECT Course from Year1Suggest where course name != 'Elective'";
	    		// checkbox
	    		Year2Suggest= "SELECT Course from Year2 where course name != 'CC'";
	    		Year2Suggest = Year2Suggest + "SELECT Course from Year2Suggest where course name != 'Elective'";
	    		//checkbox
	    		Year3Suggest= "SELECT Course from Year3 where course name != 'CC'";
	    		Year3Suggest = Year3Suggest + "SELECT Course from Year3Suggest where course name != 'Elective'";
	    		//checkbox


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


	    		if (Year==1&&Sem.equals("Spring")==false)
	    		{	
	    			System.out.println("In Year 1 Spring, please choose "+(Credneed/SemtoGrad)+" Credits from Advanced path of Year 1 below:");
	    			System.out.println(Year1Suggest);
	    		}
	    		if (Year==1)
	    		{
	    			System.out.println("In Year 2 Fall, please choose "+(Credneed/SemtoGrad)+" Credits from Advanced path of Year 1 below:");
	    			System.out.println(Year1Suggest);
	    		}
	    		if (Year==1||Year==2&&Sem.equals("Spring")==false)
	    		{
	    			System.out.println("In Year 2 Spring, please choose "+(Credneed/SemtoGrad)+" Credits from Advanced path of Year 2 below:");
	    			System.out.println(Year2Suggest);
	    		}
	    		if (Year==1||Year==2)
	    		{
	    			System.out.println("In Year 3 fall, please choose "+(Credneed/SemtoGrad)+" Credits from Advanced path of Year 3 below:");
	    			System.out.println(Year3Suggest);
	    		}


	    			System.out.println("In Year 3 fall, please choose "+(Credneed/SemtoGrad)+" Credits from Advanced path of Year 3 below:");
	    			System.out.println(Year3Suggest);


	    	}
	    	static String Year1 = "Select course code from database where recommended year = year1";
	    	static String Year2 = "Select course code from database where recommended year = year2";
	    	static String Year3 = "Select course code from database where recommended year = year3";
	    	static int Credneed = 90 - Credone;
	    	static int SemtoGrad;
	    	static boolean Defer;
	    	static String Year1Suggest;
	    	static String Year2Suggest;
	    	static String Year3Suggest;
	    }




	    class Cpeg_Advancedpath extends UserInfor{
	    	public static void suggestion(){


	    		if (Sem.equals("fall"))
	    			{
	    				if((Credneed/(2*(3-Year)+1))>=21)
	    				Defer = true;
	    				else Defer = false;
	    				SemtoGrad=(2*3-Year)+1;
	    			}
	    		else 
	    			{
	    			if( Year==3 && Credneed!=0 || (Credneed/(2*(3-Year)))>=21)
	    				Defer = true;
	    				else Defer = false;
	    			SemtoGrad=(2*(3-Year));
	    			}


	    		Scanner input3 = new Scanner(System.in);
	    		System.out.println("As CPEG student, choose COMP or ELEC approach?");
	    		approach= input3.nextLine();


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


	    		if (Year==1&&Sem.equals("Spring")==false)
	    		{	
	    			System.out.println("In Year 1 Spring, please choose "+(Credneed/SemtoGrad)+" Credits from Advanced path of Year 1 below:");
	    			System.out.println(Year1Suggest);
	    		}
	    		if (Year==1)
	    		{
	    			System.out.println("In Year 2 Fall, please choose "+(Credneed/SemtoGrad)+" Credits from Advanced path of Year 1 below:");
	    			System.out.println(Year1Suggest);
	    		}
	    		if (Year==1||Year==2&&Sem.equals("Spring")==false)
	    		{
	    			System.out.println("In Year 2 Spring, please choose "+(Credneed/SemtoGrad)+" Credits from Advanced path of Year 2 below:");
	    			System.out.println(Year2Suggest);
	    		}
	    		if (Year==1||Year==2)
	    		{
	    			System.out.println("In Year 3 fall, please choose "+(Credneed/SemtoGrad)+" Credits from Advanced path of Year 3 below:");
	    			System.out.println(Year3Suggest);
	    		}


	    			System.out.println("In Year 3 fall, please choose "+(Credneed/SemtoGrad)+" Credits from Advanced path of Year 3 below:");
	    			System.out.println(Year3Suggest);


	    	}
	    	static String approach;
	    	static String Year1 = "Select course code from database where recommended year = year1";
	    	static String Year2 = "Select course code from database where recommended year = year2";
	    	static String Year3 = "Select course code from database where recommended year = year3";
	    	static int Credneed = 90 - Credone;
	    	static int SemtoGrad;
	    	static boolean Defer;
	    	static String Year1Suggest;
	    	static String Year2Suggest;
	    	static String Year3Suggest;
	    }

*/
	    
	    
	    
	    
	    
	    
	    
	    
	}
	TextView textView1 ;
	Boolean Major1;
	Boolean Major2;
	Boolean Pure;
	Boolean Year1;
	Boolean Year2;
	Boolean Year3;
	Boolean Sem1;
	Boolean Sem2;
	String Credit;
	Boolean SA;
	Boolean S_T;
	Boolean A_H;
	Boolean Free;
	Boolean SBM;
	Boolean ENGG;
	Boolean FreeE;
	Boolean compx1;
	Boolean compx2;
	Boolean compx3;
	Boolean compx4;
	Boolean compx5;
	Boolean CEMx1;
	Boolean CEMx2;
	String Fail;
}
