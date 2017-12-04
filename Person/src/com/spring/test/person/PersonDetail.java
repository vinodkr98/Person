package com.spring.test.person;

public class PersonDetail {
	private int id;
	private String fname;
	private String lname;
	private String addressl1;
	private String addressl2;
	
	public PersonDetail(String lname){
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "personDetail [id=" + id + ", fname=" + fname + ", lname=" + lname + ", addressl1=" + addressl1 + ", addressl2=" + addressl2 + "]";
	}

	public PersonDetail() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
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

	
	
}
