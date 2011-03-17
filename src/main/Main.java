package main;

import main.domain.Person;
import main.persistence.PersonRepository;

public class Main {
	public static void main(String[] argv) {
		// Get the repository
		PersonRepository pr = new PersonRepository();
		
		// The entity we're persisting
		Person p1 = new Person("Test1", "Test2");
		
		// Insert to DB
		pr.insert(p1);
		
		// Testing select statement
		Person p2 = pr.getById(p1.getId());
		
		// Print the data retrieved from DB (should be Test1 and Test2)
		System.out.println("First name: " + p2.getFirstName());
		System.out.println("Last name: " + p2.lastName());
	}
}
