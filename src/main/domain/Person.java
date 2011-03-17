package main.domain;

/*
 * This is the entity we are persisting.
 * Notice that this is POJO (and no extra persistance annotations)
 */
public class Person {
	private long id;
	private String firstName;
	private String lastName;
	
	public Person(){} 		// MyBatis needs this, do not remove it
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {	// JavaBean style getter
		return firstName;
	}
	
	public String lastName() {		// non-JavaBean style getters also work
		return lastName;
	}
	
	public void setFirstName(String fName) {
		firstName = fName;
	}
	
//	public void setLastName (String lName) {	// Setters are not mandatory
//		lastName = lName;
//	}
}
