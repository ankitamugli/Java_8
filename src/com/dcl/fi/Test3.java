package com.dcl.fi;

import java.util.function.Predicate;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<Integer>p= (a)->a%2==0;
		if(p.test(21)) {
			System.out.println("even");
		}
		else {
			System.out.println("odd");
			
		}

		}


	}


