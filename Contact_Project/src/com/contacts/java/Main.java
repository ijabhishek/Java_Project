package com.contacts.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<Contact> contacts;
	private static Scanner scanner;
	private static int id = 0;

	public static void main(String[] args) {

		contacts = new ArrayList<>();

		System.out.println("Welcome to my world of programing");
		showIntialOptions();
	}

	private static void showIntialOptions() {
		System.out.println("Please select one: " + "\n\t1. Manage Contacts" + "\n\t2. Messages" + "\n\t3. Quit");

		scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			manageContacts();
			break;
		case 2:
			manageMessages();
			break;
		default:
			break;
		}

	}

	private static void manageContacts() {
		System.out.println("Please Select one" + "\n\t1. Show all contacts" + "\n\t2. Add a new contacts"
				+ "\n\t3. Search for a contact" + "\n\t4. Delete a contact" + "\n\t5. Go Back");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			showAllContacts();
			break;
		case 2:
			addNewContact();
			break;
		case 3:
			searchForContact();
			break;
		case 4:
			deleteContact();
			break;
		default:
			showIntialOptions();
			break;

		}

	}

	private static void deleteContact() {
		System.out.println("Enter the contact name you want to delete:");
		String name = scanner.next();

		if (name.equals("")) {
			System.out.println("Please Enter the contact name: ");
			deleteContact();
		} else {
			boolean doesExist = false;
			for (Contact c : contacts) {
				if (c.getName().equals(name)) {
					doesExist = true;
					contacts.remove(c);
				}
			}
			if (!doesExist) {
				System.out.println("Sorry name is not found in your contacts");
			}
		}
		showIntialOptions();
	}

	private static void searchForContact() {
		System.out.println("Enter the name you want to search:");
		String name = scanner.next();
		if (name.equals("")) {
			System.out.println("Please enter the contact name");
			searchForContact();
		} else {
			boolean doesExist = false;
			for (Contact c : contacts) {
				if (c.getName().equals(name)) {
					doesExist = true;
					c.getDetails();
				}
			}
			if (!doesExist) {
				System.out.println("Sorry name is not found in your contact!😢");
			}
		}
		showIntialOptions();
	}

	private static void addNewContact() {
		System.out.println("Please fill the details and it will add");
		System.out.println("Enter Your name: ");
		String name = scanner.next();
		System.out.println("Enter Your Number: ");
		String number = scanner.next();
		System.out.println("Enter Your Email id: ");
		String email = scanner.next();

		if (name.equals("") || number.equals("") || email.equals("")) {
			System.out.println("Please Enter the needed details");
			addNewContact();
		} else {
			boolean doesExist = false;
			for (Contact c : contacts) {
				if (c.getName().equals(name)) {
					doesExist = true;
				}
			}
			if (doesExist) {
				System.out.println("We have a contact named " + name + " Saved on this advice");
				Contact contact = new Contact(name, number, email);
				contacts.add(contact);
				System.out.println(name + " added successfully");
			}
			else{
				Contact contact = new Contact(name, number, email);
				contacts.add(contact);
				System.out.println(name + " added successfully");
			}

		}
		showIntialOptions();
	}

	private static void showAllContacts() {
		for (Contact c : contacts) {
			c.getDetails();
			System.out.println("*********");
		}

		showIntialOptions();

	}

	private static void manageMessages() {
		System.out.println(
				"Please Select one:" + "\n\t1. Show all messages" + "\n\t2. Send a new message" + "\n\t3. Go Back");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			showAllMessages();
			break;
		case 2:
			sendNewMessage();
			break;
		default:
			showIntialOptions();

		}

	}

	private static void sendNewMessage() {
		System.out.println("Whom You want to sent the message!");
		String name = scanner.next();

		if (name.equals("")) {
			System.out.println("Please Enter the name: ");
			sendNewMessage();
		} else {
			boolean doesExist = false;
			for (Contact c : contacts) {
				if (c.getName().equals(name)) {
					doesExist = true;

				}
			}
			if (doesExist) {
				System.out.println("What are you going to say ?🙃");
				String text = scanner.next();
				if (text.equals("")) {
					System.out.println("Please enter some message...");
					sendNewMessage();
				} else {
					id++;
					Message newMessage = new Message(text, name, id);
					for (Contact c : contacts) {
						if (c.getName().equals(name)) {
							ArrayList<Message> newMessages = c.getMessages();
							newMessages.add(newMessage);

							Contact currentContact = c;
							currentContact.setMessages(newMessages);
							contacts.remove(c);
							contacts.add(currentContact);

						}
					}
				}
			} else {
				System.out.println("There is no any contact name in your contact list !");
			}
		}
		showIntialOptions();
	}

	private static void showAllMessages() {

		ArrayList<Message> allMessages = new ArrayList<>();
		for (Contact c : contacts) {
			allMessages.addAll(c.getMessages());
		}

		if (allMessages.size() > 0) {
			for (Message m : allMessages) {
				m.getDetails();
				System.out.println("**********");
			}
		} else {
			System.out.println("You do not have any messages!");
		}
		showIntialOptions();
	}

}
