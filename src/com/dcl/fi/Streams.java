package com.dcl.fi;

import java.util.Arrays;
import java.util.List;


public class Streams {

    public static void main(String[] args) {

        List<String> str = Arrays.asList("ankita", "sherya", "bhavi");

        Streams<Integer> s = Streams.of(1, 4, 6, 7, 9, 3, 13);

        s.forEach(System.out::println);

        str.stream().forEach(System.out::println);
    }
}