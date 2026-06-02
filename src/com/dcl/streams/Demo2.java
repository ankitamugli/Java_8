package com.dcl.streams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo2 {

    public static void main(String[] args) {
     	// TODO Auto-generated method stub
        List<Emp> eList = DataFromDB.getAllEmp();
        List<Dept> dList = DataFromDB.getAllDept();
      
        
    }
    static class Emp {
        Integer eid;
        String fname;
        String lname;
        String job;
        double sal;
        Integer dno;

        public Emp(Integer eid, String fname, String lname,String job, double sal, Integer dno) {
            this.eid = eid;
            this.fname = fname;
            this.lname = lname;
            this.job = job;
            this.sal = sal;
            this.dno = dno;
        }

        @Override
        public String toString() {
            return "Emp [eid=" + eid +", fname=" + fname +", lname=" + lname +", job=" + job +", sal=" + sal +", dno=" + dno + "]";
        }
    }
    static class Dept {
        Integer dno;
        String dname;
        Integer lid;

        public Dept(Integer dno, String dname, Integer lid) {
            this.dno = dno;
            this.dname = dname;
            this.lid = lid;
        }

        @Override
        public String toString() {
            return "Dept [dno=" + dno +", dname=" + dname +", lid=" + lid + "]";
        }
    }

    static class DataFromDB {
    	public static Connection reqCon() {
            Connection con = null;try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Company_1","root","tiger");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return con;
        }

        public static List<Emp> getAllEmp() {
        	List<Emp> eList = new ArrayList<>();
            try {
                Connection con = reqCon();
                PreparedStatement ps =con.prepareStatement("select * from emp");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                	Emp e = new Emp(rs.getInt("eid"),rs.getString("fname"),rs.getString("lname"),rs.getString("job"),rs.getDouble("sal"),rs.getInt("dno"));
                	eList.add(e);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return eList;
        }

        public static List<Dept> getAllDept() {

            List<Dept> dList = new ArrayList<>();
            try {
                Connection con = reqCon();
                PreparedStatement ps =con.prepareStatement("select * from dept");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                	Dept d = new Dept(rs.getInt("dno"),rs.getString("dname"),rs.getInt("lid"));
                	dList.add(d);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return dList;
        }
    }
}