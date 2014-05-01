package com.example.advising;

import java.io.*;

public class ustTeam {
	public ustTeam() {
		name = "HKUST Psychological Team";
		telephone = 23580842;
		email = "sao@ust.hk";
		address = "Room 5015 via Lift 3 (next to Bookstore)";
		introduction = "A Psychological Team managed by SAO, HKUST";
	}

	private String name;
	private int telephone;
	private String email;
	private String address;
	private String introduction;

	public void print() {
		System.out.println("Name: " + name + "\n");
		System.out.println("Telephone: " + telephone + "\n");
		System.out.println("Email: " + email + "\n");
		System.out.println("Address: " + address + "\n");
		System.out.println("Introduction " + introduction + "\n");
		
	}

	public static void main(String[] args) {
		ustTeam a = new ustTeam();
		System.out.println("HKUST Psychological Team");
		a.print();
	}

}