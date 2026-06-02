package com.dcl.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1st way of creating stream
		Stream<Integer>s1=Stream.of(2,4,6,8,9,12,35);
		s1.forEach(System.out::println);
		
		//2nd way of creating stream
		List<String> slist=Arrays.asList("ankita","arpita","ram");
		slist.stream().forEach(System.out::println);

	}

}
