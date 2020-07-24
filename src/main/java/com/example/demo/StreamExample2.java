package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExample2 {
    public static void main(String[] args){

        System.out.println("Collect (toList() " +
                Stream.of(1,3,3,5,5)
                .filter(i -> i > 2)
                .map(i -> i*2)
                .map(i -> "#" + i)
                .collect(toList())
        );

        System.out.println( "Collect (toSet() " +
                Stream.of(1,3,3,5,5)
                        .filter(i -> i > 2)
                        .map(i -> i*2)
                        .map(i -> "#" + i)
                        .collect(toSet())
        );

        System.out.println( "Collect (joining() " +
                Stream.of(1,3,3,5,5)
                        .filter(i -> i > 2)
                        .map(i -> i*2)
                        .map(i -> "#" + i)
                        .collect(joining())
        );

        System.out.println( "Collect (joining() " +
                Stream.of(1,3,3,5,5)
                        .filter(i -> i > 2)
                        .map(i -> i*2)
                        .map(i -> "#" + i)
                        .collect(joining(","))
        );
        System.out.println( "Collect (joining() " +
                Stream.of(1,3,3,5,5)
                        .filter(i -> i > 2)
                        .map(i -> i*2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(joining(",","[","]"))
        );

        final Integer int3 = 3;
        System.out.println(
                Stream.of(1,2,3,4,5)
                        .filter(i -> i == int3)
                    .findFirst()
        );

        System.out.println(
                Stream.of(1,2,3,4,5,128)
                        .filter(i -> i.equals(128))
                        .findFirst()
        );

        System.out.println(
                Stream.of(1,2,3,4,5,128)
                        .filter(i -> i > int3)
                        .count()
        );

        final List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        for(Integer i : numbers){
            System.out.println("i = " + i);
        }

        Stream.of(1,2,3,4,5,128)
                .forEach(i -> System.out.println("i = " + i));





    }
}
