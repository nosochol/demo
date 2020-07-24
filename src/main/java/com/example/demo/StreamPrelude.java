package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamPrelude {
    public static void main(String[] args){
        final int abs1 = Math.abs(-1);
        final int abs2 = Math.abs(1);

        System.out.println("abs = abs2 :: " + (abs1 == abs2));

        final List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        System.out.println( "old map ::  "  + oldmap(numbers,i-> i*2 ) );
        //System.out.println( "old map ::  "  + oldmap(numbers,null) );
        System.out.println( "map ::  "  + map(numbers,i-> i*2 ) );
        System.out.println( "map ::  "  + map(numbers, i->i) );
        System.out.println( "map2 ::  "  + map(numbers, Function.identity()) );
    }

    private static <T,R> List<R> oldmap(final List<T> list, final Function<T,R> mapper){
        final List<R> result = new ArrayList<>();
        for(final T t : list) {
            result.add(mapper.apply(t));
        }

        return result;
    }

    private static <T,R> List<R> map(final List<T> list, final Function<T,R> mapper){
        final List<R> result = new ArrayList<>();
        for(final T t : list){
            result.add(mapper.apply(t));
        }

        return result;
    }
}
