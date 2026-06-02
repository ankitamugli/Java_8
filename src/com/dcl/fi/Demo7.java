package com.dcl.fi;
interface dcl{
	 public void add (int a,int b);
}
 class Imp implements dcl{

	@Override
	public void add(int a, int b) {
		// TODO Auto-generated method stub
		int c=a+b;
		System.out.println("sum is"+c);
	}
 }


public class Demo7 {
	public Demo7(){
		System.out.println("zero paramerter construstor");
		
	}
	
	public Demo7(int a,int b) {
		System.out.println("parametrized constructor");
		
	}
	
	void Multiply(int a,int b) {
		System.out.println("product is"+(a*b));
	}
	
	void substarct(int a,int b) {
		System.out.println("substarct is"+(a-b));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("---------1---------");
		dcl d1=new Imp();
		d1.add(10,20);
		
		
		System.out.println("---------2----------");
		dcl d2=(a,b)->{	
			int c=a+b;
			System.out.println("output is"+c);			
		};
		d2.add(10,20);
	
		
		System.out.println("---------3----------");
		Demo7 t7=new Demo7();
		t7.Multiply(10,12);
	
		
		System.out.println("---------4----------");
		dcl d4=new Imp();
		d4.add(12,12);
				
		System.out.println("---------5----------");
		dcl d5=(a,b)->t7.Multiply(a,b);
		d5.add(10,13);
		
//		interface_name ref_name=Class_ref_name::inst_method
		System.out.println("---------6----------");
		dcl d6=t7::multiply;
		d6.add(10,30);
		
		System.out.println("---------7----------");

		
		System.out.println("---------8----------");
		dcl d7=(a,b)->Demo7
		d6.add(10,30);
		
		System.out.println("---------9----------");


		
		public void Multiply
		(int a,int b) {
			System.out.println("product is "+(a*b));
		}
		
		public void substract(int a,int b) {
			System.out.println("difference "+a-b);
		}


		
		
		

	}

}
