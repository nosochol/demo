package com.book.demo;

import java.util.ArrayList;
import java.util.List;

public class IntefacePredicateSample {
    public static void main(String...args){

    }
    @FunctionalInterface
    public interface Predicate<T> {
        boolean test(T t);
    }

    public <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T t : list){
            if(p.test(t)){
                results.add(t);
            }
        }

        return results;
    }

    Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
    List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
}
