package com.example.gpa_calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.io.*;
import java.util.ArrayList;

public class cgaCalculator {
	public static void input_data(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		while (true) {
			System.out.println("Please enter the number of subjects");
			short input;
			input = (short) reader.read();

			if (input > 0) {
				ArrayList<courseRecord> records = new ArrayList<courseRecord>(
						input);
				break;
			} else {
				System.out
						.println("Valid number of subjects should be greater zero!");
			}
		}
		while (true) {
			System.out.println("Please enter in the form of \"Year/Credits/Grade\"");
			String temp;
			temp = reader.readLine();
			int year;
			int credits;
			char grade;
			int stringLocation = 0;

			year = temp.charAt(stringLocation);
			stringLocation++;
			if (temp.charAt(stringLocation) != '\\') {
				break;
			} else {
				stringLocation++;
			}
			credits = temp.charAt(stringLocation);
			stringLocation++;
			if (temp.charAt(stringLocation) != '\\') {
				break;
			} else {
				stringLocation++;
			}
			grade = temp.charAt(stringLocation);

		}
	}
}