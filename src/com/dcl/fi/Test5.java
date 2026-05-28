package com.dcl.fi;

import java.util.function.Predicate;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str= {"ankita","bhavni","gooday","pragati","ram"};
		
		Predicate<String> p=(a)->a.length()>=7;
		for(String s:str) {
			if(p.test(s)) {
				System.out.println("s");
				
			}
			
		}
		
	}

}
