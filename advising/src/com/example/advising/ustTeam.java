package com.example.advising;

public class ustTeam {
	public ustTeam() {
		name = "HKUST Psychological Team";
		telephone = 23580842;
		email = "sao@ust.hk";
		address = "Room 5015 via Lift 3 (next to Bookstore)";
		introduction = "A Psychological Team managed by SAO, HKUST";
	}

	//Name of the advising team
	private String name;
	//Telephone of the team
	private int telephone;
	//Email of the team
	private String email;
	//Address of the team
	private String address;
	//Short introduction of the team
	private String introduction;

	
	//A print function that lists all the information of a team
	public void print() {
		System.out.println("Name: " + name + "\n");
		System.out.println("Telephone: " + telephone + "\n");
		System.out.println("Email: " + email + "\n");
		System.out.println("Address: " + address + "\n");
		System.out.println("Introduction " + introduction + "\n");
		
	}

	public static void main(String[] args) {
		ustTeam a = new ustTeam();
		System.out.println("Welcome to HKUST Psychological Team");
		a.print();
	}

}