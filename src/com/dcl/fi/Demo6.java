package com.dcl.fi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Emp> empData = DataFromDb.getAllEmps();
//		wap to display the names of emp fname starts with s
		

		Predicate<Emp> p1 = e -> e.fname.startsWith("S");
		for(Emp e:empData) {
			if(p1.test(e)) {
				System.out.println(e.fname);
			}
			
		}
		
//		wap to display the names of emp if empsal more than 40000
		System.out.println("--------------2------------");
		Predicate<Emp>p2 =(e)->e.sal>40000;
		for (Emp e:empData) {
			if(p2.test(e)) {
				System.out.println(e.fname);
			}
		}
		
//		3
		System.out.println("--------------3------------");
		Predicate<Emp>p3 =(e)->e.dno  ==  113;
		for (Emp e:empData) {
			if(p3.test(e)) {
				System.out.println(e.dno+" "+ e.fname+" "+e.lname);
			}
		}
//		4
		System.out.println("--------------4------------");
		Predicate<Emp>p4 =(e)->e.dno  ==  113;
		for (Emp e:empData) {
			if(p4.test(e)) {
				System.out.println(e.dno+" "+ e.fname+" "+e.lname);
			}
		}
		
		

	}

}

 class Emp{
	Integer eid;
	String fname;
	String lname;
	String job;
	Double sal;
	Integer dno;
	
	public  Emp(Integer eid,String fname,String lname,String job,Double sal,Integer dno) {
	this.eid=eid;
	this.fname=fname;
	this.lname=lname;
	this.job=job;
	this.sal=sal;
	this.dno=dno;
}
 }
class DataFromDb{
	public static List<Emp> getAllEmps(){
		List<Emp>eList=new ArrayList<Emp>();
		Emp e=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("driver loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company_1","root","tiger");
			PreparedStatement ps =con.prepareStatement("select * from emp");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				e=new Emp(rs.getInt("eid"),rs.getString("fname"),rs.getString("lname"),rs.getString("job"),rs.getDouble("sal"),rs.getInt("dno"));
				eList.add(e);
			}
			
		}catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return eList;
	
	}
} 