package com.dcl.fi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
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
		
//		3)wap to display the names,dno of the emp if the emp is working in dept
		System.out.println("--------------3------------");
		Predicate<Emp>p3 =(e)->e.dno  ==  113;
		for (Emp e:empData) {
			if(p3.test(e)) {
				System.out.println(e.dno+" "+ e.fname+" "+e.lname);
			}
		}
//		4)wap to the emp fname and lname if the emp fname length exceeds 4 
		System.out.println("--------------4------------");
		Predicate<Emp>p4 =(e)->e.fname.length() >4;
		for (Emp e:empData) {
			if(p4.test(e)) {
				System.out.println( e.fname+" "+e.lname);
			}
		}
		
		//5)wap to display the deatails (entire emp obj) if the emp is not working as ceo
		System.out.println("--------------5------------");
		Predicate<Emp>p5 =(e)->e.job !="ceo";
		for (Emp e:empData) {
			if(p5.test(e)) {
				System.out.println( e.fname+" "+e.lname);
			}
		}
		
		Consumer<Emp> c=(e)-> System.out.println(e);
		c.accept(new Emp(1,"Raju","patidar","developer", 2000.0,13));
		Consumer <String> c1=(a)-> System.out.println(a.length());
		c1.accept("vijay");
		
		Supplier<Emp> s=()->empData.get(0);
		Emp emp_first_data=s.get();
		System.out.println(emp_first_data);
		
		Supplier<String>s1=()->"mityraju has huge fan following";
		System.out.println(s1.get());
		
		Function<String,Integer> f=(name)->name.length();
		Integer leng=f.apply("ankita");
		System.out.println(leng);
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

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", fname=" + fname + ", lname=" + lname + ", job=" + job + ", sal=" + sal + ", dno="
				+ dno + "]";
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