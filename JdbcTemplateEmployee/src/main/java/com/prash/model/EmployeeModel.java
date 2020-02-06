package com.prash.model;

public class EmployeeModel {
	int eid;
	String fname;
	String lname;
	int age;
	int did;
	int salary;

	public EmployeeModel(int eid, String fname, String lname, int age, int did, int salary) {
		super();
		this.eid = eid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.did = did;
		this.salary = salary;
	}

	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeModel [eid=" + eid + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", did=" + did
				+ ", salary=" + salary + "]";
	}
	

	
	
}
