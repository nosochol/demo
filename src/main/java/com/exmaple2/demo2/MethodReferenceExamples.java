package com.exmaple2.demo2;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class MethodReferenceExamples {
    public static void main(String[] args){
        Arrays.asList(1,2,3,4,5)
                .forEach(System.out::println);
              //.forEach(i -> System.out.println(i));
        System.out.println(
        Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
                .stream()
                //.sorted((bd1, bd2) -> bd1.compareTo(bd2))
                //.sorted(BigDecimalUtil::compare)
                .sorted(BigDecimal::compareTo)
                .collect(toList())
        );

        final String targetString ="c";
        System.out.println(
        Arrays.asList("a","b","c","d")
                .stream()
                //.anyMatch(x -> x.equals("c"))
                .anyMatch(targetString::equals)
        );
        System.out.println("=========================");
        methodReference03();
        System.out.println("=========================");
    }
    private static void methodReference03() {
        /* first class Function */
        System.out.println(
        testFirstClassFunction(3,i->String.valueOf(i*2))
        );
        System.out.println(
            testFirstClassFunction(3,MethodReferenceExamples::doubleThenToString)
        );


    }

    private static String doubleThenToString(int i){
        return String.valueOf(i*2);
    }

    private static  String testFirstClassFunction(int n, Function<Integer,String> f){
        return  "the result is " + f.apply(n);
    }
}

class BigDecimalUtil {
    public static int compare(BigDecimal bd1, BigDecimal bd2){
        return bd1.compareTo(bd2);
    }
}