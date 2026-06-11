package Dateandtimeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate ld=LocalDate.now();
		System.out.println(ld.getYear());
		
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(ldt.getDayOfWeek());
		
		LocalTime lt=LocalTime.now();
		System.out.println(lt);
		
//		small mm represnts minute and capital MM represent month
		String date="13-07-2026";
		DateTimeFormatter f=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate convertedDate=LocalDate.parse(date,f);
		System.out.println(convertedDate);
		
//	    to obtaibn the difference between dates and time
		Period p=Period.between(ld,convertedDate);
		         //11-june-13-june
		Integer days=p.getDays();
		System.out.println(days);
		


	}

}
