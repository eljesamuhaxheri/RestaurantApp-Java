package org.makermainds.jcoaching.resturantapp.model;


public class Client {

	//string- objekt
	
	private String name;
	private String phoneNumber;
	
//ALT + SHIFT + S  
	
	public Client(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
