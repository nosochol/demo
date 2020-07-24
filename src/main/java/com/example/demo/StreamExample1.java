package com.example.demo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample1 {
    public static void main(String[] args){
        //IntStream.rangeClosed(1, 10).forEach(i -> System.out.print(i + " "));
        //IntStream.iterate(1,i->i+1).forEach(i -> System.out.print(i + " "));
        //Stream.iterate(BigInteger.ONE, i-> i.add(BigInteger.ONE)).forEach(i->System.out.println(i + ""));
        Stream.of(1,2,3,4,5)
                .forEach(i -> System.out.println(i + ""));

        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
         Integer result = null;
        for(final Integer number : numbers) {
            if(number > 3 && number < 9) {
                final Integer  newNumber = number*2;
                if(newNumber > 10) {
                    result = newNumber;
                    break;
                }
            }
        }

        System.out.println("Im result " + result);

        System.out.println("Function Result : " +
        numbers.stream()
                .filter(number -> {
                    System.out.println("number > 3");
                    return number > 3;
                })
                .filter(number -> number < 9)
                .map(number -> number * 2)
                .filter(number -> number > 10)
                .findFirst()
        );

        final List<Integer> greaterThan3 = filter(numbers, i -> i > 3);
        final List<Integer> lessThan9 = filter(greaterThan3, i -> i < 9);
        final List<Integer> doubleds = map(lessThan9, i -> i * 2 );
        final List<Integer> greaterThan10 = filter(doubleds, i -> i > 10);

        System.out.println("greateThan10 " + greaterThan10.get(0));

    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        final  List<T> result = new ArrayList<>();
        for(final T t : list ){
            if(predicate.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    private static <T, R> List<R> map(List<T> list, Function<T,R> mapper){
        final List<R> result = new ArrayList<>();
        for(final T t: list) {
            result.add(mapper.apply(t));
        }
        return result;
    }
}
