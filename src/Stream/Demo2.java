package Stream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo2 {

    private static final int String = 0;
	private static final int Set = 0;

	public static void main(String[] args) {
     	// TODO Auto-generated method stub
        List<Emp> eList = DataFromDB.getAllEmp();
        List<Dept> dList = DataFromDB.getAllDept();

//       1) wap to display the data of emps who is working in salesman 
        eList.stream().filter((e)->e.job.equals("salesman")).forEach(System.out::println);
        
//        2)wap to display the data of emps
//        if emp is working in dept 112
        System.out.println("-----------2----------");
        eList.stream().filter((e)->e.dno.equals(112)).forEach(System.out::println);
        
//        3) wap to display the data of emps
//        if the emp is not working as ceo
        System.out.println("-----------3----------");
        eList.stream().filter((e)->!e.dno.equals("ceo")).forEach(System.out::println);
        
//        4)wap to display the data of emps
//        if the emp is getting salary more than 45000
        System.out.println("-----------4----------");
        eList.stream().filter((e)->e.sal>45000).forEach(System.out::println);
        
//        5)wap to display ther deatils of emp if the employee name starts with s
        System.out.println("-----------5----------");
        eList.stream().filter((e)->e.fname.startsWith("S")).forEach(System.out::println);
        
//        6)wap to display the display the details of emp
//        if the emp job role starts with d
        System.out.println("-----------6----------");
        eList.stream().filter((e)->e.job.startsWith("D")).forEach(System.out::println);
        
//        7) wap to display the details of emp if the employee is working as salesman or manager
        System.out.println("-----------7----------");
        eList.stream()
             .filter((e)->e.job.equals("Salesman")||e.job.equals("Manager"))
             .forEach(System.out::println);
        
//        8)wap to dispaly the details of emp
//        if the is getting salary more than 40000
        System.out.println("-----------8----------");
        eList.stream().filter((e)->e.sal>40000&&e.sal<100000)
        .forEach(System.out::println);
        
//        9) wap to display the deatils of emp 
//        if the emp last name ends with or y
        System.out.println("-----------9----------");
        eList.stream().filter((e)->e.lname.endsWith("i") ||e.lname.endsWith("y"))
             .forEach(System.out::println);
        
//        10)wap  to display the details of emp
//        if emp is working as salesman or manager
//        in dept 110or111
        System.out.println("-----------10----------");
        eList.stream().filter((e)->e.job.equals("Salesman")||e.job.equals(110)||e.job.equals(111) ||e.job.equals("Manager"))
        .forEach(System.out::println);
        
//        11)wap to display if the employee is getting salary more than 35000
        System.out.println("-----------11----------");
        eList.stream().filter((e)->e.sal>35000).forEach(System.out::println);

//         12)waptd the names of employee if the employee name starts with S
        System.out.println("-----------12----------");
        eList.stream().filter((e)->e.fname.startsWith("S")).forEach((e)->System.out.println(e.fname));
        
//       eList.stream().filter((e)->e.fname.startsWith("S")).map(e->e.fname.toUpperCase()).forEach((e)->System.out.println(e.fname));

//        13)waptd the names and sal of emp
//       if the emp is getting salary more than 50000
        System.out.println("-----------13----------");
       eList.stream().filter((e)->e.sal>50000).map((e)->e.fname+" "+e.sal).forEach(System.out::println);
       
//       14)waptd the name,job and dept no
//       if the emp is working as developer or tester in
       System.out.println("-----------14----------");
        eList.stream()
            .filter((e)->e.job.equalsIgnoreCase("Developer")||e.job.equalsIgnoreCase("Tester"))
            .map((e)->e.fname+" -"+e.job+"-"+e.dno)
           	.forEach(System.out::println);       
       
//       16waptd the emps fullnamre in below for 
//       siddarth patil=> siddarth
       System.out.println("-----------16----------");
       eList.stream().map(e->e.fname+"."+e.lname.charAt(0)).forEach(System.out::println);
       
//       17)waptd the first half of the fname
       System.out.println("-----------17----------");
       eList.stream().map(e->e.fname.substring(0,e.fname.length()/2)).forEach(System.out::println);
//       18)waptd the fname and lname if 
//       the lenth of fname exceeds 4 character
       System.out.println("-----------18----------");
       eList.stream().filter((e)->e.fname.length()>5).map(e->e.fname+" "+e.lname).forEach(System.out::println);
       
//       19)wap to display all the job from emp data
       System.out.println("-----------19----------");
       eList.stream().map(e->e.job).distinct().forEach(System.out::println);
       
//       20)waptd the different dept available in emp data
       System.out.println("-----------20----------");
       eList.stream().map(e->e.dno).distinct().forEach(System.out::println);

        // 21)waptd the fname ,lname and salary if the employee is working as salesman or manager
        eList.stream()
             .filter(e -> e.job.equalsIgnoreCase("Salesman") || e.job.equalsIgnoreCase("Manager"))
             .map(e -> e.fname + " " + e.lname + " " + e.sal)
             .forEach(System.out::println);
        
//    		22)wap to display the first 5 employee from the employee
       System.out.println("-----------22----------");
       eList.stream().limit(5).forEach(System.out::println);
       
//       23)wap to display the first4 emp fname
       System.out.println("-----------23----------");
       eList.stream().limit(5).map(e->e.fname).forEach(System.out::println);
       
//       24)wap to display the emp data
       System.out.println("-----------24----------");
       eList.stream().skip(3).limit(1).forEach(System.out::println);
       
//       25)wap to display the first 10 emp data
       System.out.println("-----------25----------");
       eList.stream().limit(10).forEach(System.out::println);
       
//       26)wap to dispaly the 7th emp data
       System.out.println("-----------26----------");
       eList.stream().skip(6).limit(1).forEach(System.out::println);
//       27)wapto dispaly the 8th and 9th emp data
       System.out.println("-----------27----------");
       eList.stream().skip(7).limit(2).forEach(System.out::println);
       
//       28)wap to dispaly the first 3 emp data which has even id
       System.out.println("-----------28----------");
       eList.stream().filter(e->e.eid%2==0).limit(3).forEach(System.out::println);
       
       System.out.println("-----------29----------");
       eList.stream().sorted(Comparator.comparing(e->e.sal)).forEach(System.out::println);
       
//       wap to display the emp records based on sal from min to max
       System.out.println("-----------a----------");
       eList.stream().sorted(Comparator.comparing(e->e.fname)).forEach(System.out::println); 
       
//       30)wap to dispaly the emp 
       System.out.println("-----------30----------");
       eList.stream().sorted(Comparator.comparing(e->e.fname)).map(e->e.fname).forEach(System.out::println); 
       
//       31)waptd the emp salaries in desc order
       System.out.println("-----------31----------");

       eList.stream().sorted(Comparator.comparing((Emp e) -> e.sal).reversed()).forEach(System.out::println);

//       32)waptd the last 4 records from emp list
       System.out.println("-----------32----------");
       eList.stream().sorted(Comparator.comparing((Emp e) -> e.eid).reversed()).limit(4).forEach(System.out::println);
              
//       33)waptd the 2nd max salary from emp
       System.out.println("-----------33----------");
       eList.stream()
            .sorted(Comparator.comparing((Emp e) -> e.sal).reversed()).map(e->e.sal)
            .skip(1).limit(1).distinct()
            .forEach(System.out::println);

//       34)waptd the 3rd min salary from emp
       eList.stream()
            .sorted(Comparator.comparing((Emp e) -> e.sal)).map(e->e.sal)
            .skip(1).limit(1).distinct()
            .forEach(System.out::println);

          //35)WAPtd the number of salesman in the       
            System.out.println("-----------35----------");
            Long salesman_count =
                    eList.stream()
                         .filter(e -> e.job.equals("Salesman")).count();
            System.out.println(salesman_count);
            
            //36)waptd the number of emp whose fname starts with s or k
            System.out.println("-----------36----------");
            Long fname =
                    eList.stream()
                         .filter(e -> e.fname.startsWith("S")||e.fname.startsWith("K")).count();
            System.out.println(fname);
    
//            37)waptd the numbeer of different job roles available in emp count
            System.out.println("-----------37----------");
            Long diff_job=
                    eList.stream()                       
                         .map(e->e.job).distinct().count();
            System.out.println(diff_job);
               
//            38)waptd from in dept list
            System.out.println("-----------38----------");
            Long dept=
                    eList.stream().map(e->e.dno).distinct().count();
            System.out.println(dept);
            
//            39)wap to display to obtain the list of salesman result must be in a list
            System.out.println("-----------39----------");
          List<Emp> emp_List1=
        		  eList.stream().filter(e->e.job.equals("Salesman")).collect(Collectors.toList());
              System.out.println(emp_List1);
              
//              40)waptd the emp fname,lname,sal,deptno,if the emp is working as developer or dispatcher,display the data in the form of se
              System.out.println("-----------40----------");
              Set<String>emp_List2=
            	        eList.stream()
            	             .filter(e -> e.job.equals("Developer") || e.job.equals("Dispatcher"))
            	             .map(e -> e.fname + " " + e.lname + " " + e.sal + " " + e.dno)
            	             .collect(Collectors.toSet());
                          System.out.println(emp_List2);
              
//              41)waptd the emp data in map format if emp is working dept 113
              System.out.println("-----------41----------");
              Map<Integer,Emp>map1=
            		 eList.stream().filter(e->e.dno==113)
            		 .collect(Collectors.toMap(e->e.eid, e->e));
              System.out.println(map1);         
              
//              42)wap to display the dept dept data in map format
              System.out.println("-----------42----------");
              Map<Integer,Dept>map2=dList.stream()
              .collect(Collectors.toMap(d->d.dno,d->d));
              System.out.println(map2);
              
//      43)waptd emp data who is obtaining max salary from list
              System.out.println("-----------43----------");
              Optional<Emp> max_sal=eList.stream()
            		  .collect(Collectors.maxBy(Comparator.comparing(e->e.sal)));
              System.out.println(max_sal.orElse(null));
              
//        44)waptd emp data who is obtaining min salary from list
              System.out.println("-----------44----------");
              Optional<Emp> min_sal=eList.stream()
            		  .collect(Collectors.minBy(Comparator.comparing(e->e.sal)));
                   System.out.println(min_sal.orElse(null));
                   
//         45)waptd the max sal in each dept       
              System.out.println("-----------45----------");
              Map<Integer,Optional<Emp>> max_emp_dno=
            		  eList.stream()
            		       .collect(Collectors.groupingBy(e->e.dno,
            		    		   Collectors.maxBy(Comparator.comparing(e->e.sal)
            		    				   )));
              max_emp_dno.forEach((dno,o)->System.out.println(dno+" "+o.orElse(null)));
              
              
//            46)waptd the min sal in each dept       
                 System.out.println("-----------46----------");
                 Map<Integer,Optional<Emp>> min_emp_dno=
               		  eList.stream().collect(Collectors.groupingBy(e->e.dno,
               		    		   Collectors.minBy(Comparator.comparing(e->e.sal))));
                 min_emp_dno.forEach((dno,o)->System.out.println(dno+" "+o.orElse(null)));
                 
//                 47) wap to dispaly the number of emps in each dept
                 System.out.println("-----------47----------");
                 Map<Integer,Long> count_dept=
                 eList.stream().collect(Collectors.groupingBy(e->e.dno,Collectors.counting()));
                 count_dept.forEach((dno,count)->System.out.println(dno+":"+count));
                 
//                 48)wap to display the number of emp in each job
                 System.out.println("-----------48----------");
                 Map<String,Long> count_emp=
                 eList.stream().collect(Collectors.groupingBy(e->e.job,Collectors.counting()));
                 count_emp.forEach((job,count)->System.out.println(job+"="+count));
                 
//                 49)wap to display the max salary in each job  role
                 System.out.println("-----------49----------");
                 Map<String, Optional<Emp>> maxEmpByJob =
                		    eList.stream().collect(Collectors.groupingBy(e->e.job,
                		             Collectors.maxBy(Comparator.comparingDouble(e -> e.sal))));
                 maxEmpByJob.forEach((ejob,o)->System.out.println(ejob+" :"+o.orElse(null)));
                		        
                 
//                 50)wap to display the avg salary in each dept
                 System.out.println("-----------50----------");

                 Map<Integer, Double> avg_sal_dept =
                     eList.stream().collect(Collectors.groupingBy( e -> e.dno,Collectors.averagingDouble(e -> e.sal)));
            avg_sal_dept.forEach((dno, avgSal) ->System.out.println("Dept " + dept + " = " + avgSal));
                 
                 
//                 51) wap to display the total salry in each dept
            System.out.println("-----------51----------");
            Map<Integer, Double> map_total =
                    eList.stream().collect(Collectors.groupingBy( e -> e.dno,Collectors.summingDouble(e -> e.sal)));
           map_total.forEach((dno, avgSal) ->System.out.println("Dept " + dept + " = " + avgSal));
                
                
//                 52)wap to dispaly the first emp from each dept
           System.out.println("-----------52----------");
           Optional<Emp>emp=
           eList.stream().findFirst();
           System.out.println(emp.orElse(null));
           
//                 53) wap to check whether any emp belong to dept 114 or not
           System.out.println("-----------53----------");
           List<Integer> depts=
           eList.stream().map(e->e.dno).distinct().collect(Collectors.toList());
           for(Integer dep:depts) {
        	   Optional<Emp>o=eList.stream().filter(e->e.dno==dep).findFirst();
        			   System.out.println(dept+" -"+o.orElse(null));
           }
           
//           54wap to check whether any emp belong to dept 114 or not
           System.out.println("-----------54----------");
           Boolean res1=
           eList.stream().anyMatch(e->e.dno==114);
           System.out.println(res1);
           
//           55)wap to check whether any emp belong to dept 115
           System.out.println("-----------55----------");
           Boolean res2=
           eList.stream().noneMatch(e->e.dno==115);
           System.out.println(res2);
           
           System.out.println("-----------56----------");
           Boolean res3=
           eList.stream().filter(e->e.dno==113).allMatch(e->e.dno==113);
           System.out.println(res3);
           
//           topic are :1)filter,map,flatmap,distint,skip,limit,sorted
//           2)terminal:count,groupingby,maxby,minby,averagingdouble,ssummingdouble counting,findfirst,anymatch,nonematch,allmatch
           
           
                 


       

    				   
            
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