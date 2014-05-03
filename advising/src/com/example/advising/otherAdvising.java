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
		otherAdvising a = new otherAdvising();
		a.name = newName;
		a.telephone = newPhone;
		a.email = newEmail;
		a.address = newAddress;
		a.introduction = newIntro;
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