package com.example.advising;

import java.io.*;

public class otherAdvising{
	public otherAdvising() {
		name = "ABC Psychological Team";
		telephone = 12345678;
		email = "what@what.com";
		address = "Room in HK";
		introduction = "A Psychological Team managed by ?!";
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
		System.out.println("Counselling Services outside HKUST");
		otherAdvising a = new otherAdvising();
		a.print();
		otherAdvising b = new otherAdvising();
		b.print();
	}
}