package com.example.gpa_calculator;

//import android.os.Bundle;
//import android.app.Activity;
//import android.view.Menu;

import java.io.*;

public class cgaCalculator {

	public static void main(String[] args) throws IOException {

		Student user = new Student();

		// System.out.println("user.TGA[0][0]= " + user.TGA[0][0]);
		// System.out.println("user.TGA[0][1]= " + user.TGA[0][1]);
		// System.out.println("user.TGA[0][2]= " + user.TGA[0][2]);

		// System.out.println(user.GradeToNum("A"));

		// System.out.println(user.courseRecord[0][0][0][0]);
		// System.out.println(user.courseRecord[0][0][0][1]);
		// System.out.println(user.courseRecord[0][0][0][2]);

		user.studentInput();

		// System.out.println(user.courseRecord[0][0][0][0]);
		// System.out.println(user.courseRecord[0][0][0][1]);
		// System.out.println(user.courseRecord[0][0][0][2]);

		// System.out.println("user.TGA[0][0]= " + user.TGA[0][0]);
		// System.out.println("user.TGA[0][1]= " + user.TGA[0][1]);
		// System.out.println("user.TGA[0][2]= " + user.TGA[0][2]);

		// int year = 0;
		// int sem = 0;
		user.printTGA();

		user.printCGA();
		user.printGGA();

	}

}
