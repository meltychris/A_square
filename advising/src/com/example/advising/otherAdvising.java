package com.example.advising;

public class otherAdvising {
	public otherAdvising() {
		name = "ABC Psychological Team";
		telephone = 12345678;
		email = "what@what.com";
		address = "Room in HK";
		introduction = "A Psychological Team managed by ?!";
	}

	public otherAdvising(String newName, int newPhone, String newEmail,
			String newAddress, String newIntro) {
		name = newName;
		telephone = newPhone;
		email = newEmail;
		address = newAddress;
		introduction = newIntro;
	}

	// Name of the advising team
	private String name;
	// Telephone of the team
	private int telephone;
	// Email of the team
	private String email;
	// Address of the team
	private String address;
	// Short introduction of the team
	private String introduction;

	//Print function that lists all the information of a team
	public void print() {
		System.out.println("Name: " + name + "\n");
		System.out.println("Telephone: " + telephone + "\n");
		System.out.println("Email: " + email + "\n");
		System.out.println("Address: " + address + "\n");
		System.out.println("Introduction: " + introduction + "\n");

	}

	public static void main(String[] args) {
		System.out.println("Counselling Services outside HKUST");
		otherAdvising a = new otherAdvising();
		a.print();
		otherAdvising b = new otherAdvising("Team B", 34567890, "some_email",
				"Flat in HK", "What Team");
		b.print();
	}
}