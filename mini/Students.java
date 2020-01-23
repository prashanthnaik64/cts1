package com.cts;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Students {

	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivam","root","welcome");
		
		String name;
		String a;
		String b;
		int id;
		boolean flag;
		Date date;
		String ssDate;
		
		Scanner scan = new Scanner(System.in);
	    ArrayList<Student> list = new ArrayList();
	    
	    for(int i=0;i<1;i++){
	    
	    	System.out.println("Enter the Name of the Student-");
	        name = scan.nextLine();
	       
	        System.out.println("Enter the ID of the Student-");
	        a = scan.nextLine();
	        id=Integer.parseInt(a);
	        
	        System.out.println("Enter the Flag Value of the Student-");
	        b = scan.nextLine();
	        flag = Boolean.parseBoolean(b);
	       
	        System.out.println("Enter the DOB of the Student in Format(yyy-mm-dd)");
	        ssDate = scan.nextLine();
	        SimpleDateFormat f = new SimpleDateFormat("yyy-mm-dd");
	       
	        java.util.Date date2 =  f.parse(ssDate);
	        
	        Student s12 = new Student(id, name, flag, date2);
	        list.add(s12);
	    }
	   
	    Iterator it = list.iterator();
	    while(it.hasNext()) {
	    	Student s = (Student) it.next();
	    	System.out.println(s);
	    } 
	    
	    String pst = "insert into Student1 values(?,?,?,?)";
	    PreparedStatement pstmt = con.prepareStatement(pst);
	    for (int i = 0; i < list.size(); i++) {
	    	Student ss = list.get(i);
	    	 pstmt.setString(1, ss.name);
	    	 pstmt.setInt(2, ss.id);
	    	 
	    	 java.util.Date dateA = ss.date2;
	    	 java.sql.Date  sqlDate = new java.sql.Date(dateA.getTime());
	    	 
	    	 pstmt.setDate(3, sqlDate);
	    	 pstmt.setBoolean(4, ss.flag);
	    	 
	    	 pstmt.executeUpdate();
		}

		con.close();
	    
	}

}
class Student{
	int id;
	String name;
	java.util.Date date2;
	boolean flag;

	public Student(int id, String name,boolean flag, java.util.Date date2) {
		this.id = id;
		this.name = name;
		this.date2 =  date2;
		this.flag = flag;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [id = " + id + ", name = " + name + ", date2 = " + date2 + ", flag = " + flag + "]";
	}
}
