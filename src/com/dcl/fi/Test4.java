package com.dcl.fi;

import java.util.function.Predicate;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<String> p=(s)->s.startsWith("a");
		if(p.test("abc")) {
			System.out.println("yes");
			
		}
		else {
			System.out.println("no");
			
		}

	}


	}


