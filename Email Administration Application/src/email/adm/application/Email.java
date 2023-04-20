package email.adm.application;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength =8;
	private String department;
	private int mailboxCapacity;
	private String alternateEmail;
	private String email;
	
	//Constructor to receive the first name and last name
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;	
		
		//Call a method asking for the department - return department
		this.department = setDepartment();
		
		//Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);

		
		//Call a method that genreate Email
		this.email = uniqueEmail();
		
		
		
		
	}
	
	// call a method asking for the department - return the department
	private String setDepartment() {
		System.out.print("Enter the department Code:\n1 for Sales\n2 for Accounting \n3 Development");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {
			return "Sales";
		}else if(depChoice == 2){
			return "Accounting";
		}else if(depChoice == 3) {
			return "Development";
		}else {
			return "Not choosed any department";
		}	
	
	}

	// Generate a random password
	private String randomPassword(int length){
		String passwordSet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int)(Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
			
		}
		return new String(password);
	}
	//Generate a email
	private String uniqueEmail() {
		String email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"."+department.toLowerCase()+"@company.com";
		return email;
	}
	// Set the mailbox Capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;	
	}
	public void setAlternateEmail(String altEmail) {
		this.email = altEmail;
	}
	public void changePassword(String password) {
		this.password = password;
		
	}
	public String getPassword() {
		return password;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getEmail() {
		return email;
	}
	
	public String showInfo() {
		return "First name: "+firstName+" "+lastName+
				"\nDepartment Name: "+department+
				"\nCompany Email: "+email+
				"\nMailbox Capacity:" +mailboxCapacity;
				
	}
}

