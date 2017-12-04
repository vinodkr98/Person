package com.spring.test.person;

public class Person {
	private int id;
	private String fname;
	private String lname;
	private String addressl1;
	private String addressl2;
	
	
	
	public Person(int id, String fname, String lname, String addressl1, String addressl2) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.addressl1 = addressl1;
		this.addressl2 = addressl2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return fname;
	}
	public void setFirstName(String fname) {
		this.fname = fname;
	}
	public String getLastName() {
		return lname;
	}
	public void setLastName(String lname) {
		this.lname = lname;
	}
	public String getAddressl1() {
		return addressl1;
	}
	public void setAddressl1(String addressl1) {
		this.addressl1 = addressl1;
	}
	public String getAddressl2() {
		return addressl2;
	}
	public void setAddressl2(String addressl2) {
		this.addressl2 = addressl2;
	}
	public String toString(){
		  return " Id " + id + " fname " + fname; 
	  }
	
	
}
