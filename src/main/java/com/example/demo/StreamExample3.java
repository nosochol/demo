package com.example.demo;

import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


public class StreamExample3 {
    public static void main(String[] args){
        Stream.of(1,2,3,4,5)
                .collect(toList());
        Stream.of(1,2,3,4,5)
                .collect(toSet());
        Stream.of(1,2,3,4,5)
                .map(i -> String.valueOf(i))
                .collect(joining());
    }
}
