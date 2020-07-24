package com.book.demo;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class AppleHeavyWeightPredicate implements ApplePredicate{
    public boolean test(Apple apple){
        return apple.getWeight() > 150;
    }
}

class AppleGreenColorPredicate implements  ApplePredicate {
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor());
    }
}
public class FilteringApples {

   public static void main(String...args) {
       List<Apple> inventory = Arrays.asList(
               new Apple(80, Color.GREEN),
               new Apple(155, Color.GREEN),
               new Apple(120, Color.RED)
       );


       //List<Apple> heavyApp = filterApples(inventory, new AppleHeavyWeightPredicate());
       List<Apple> heavyApp = filterApples(inventory, (Apple apple) -> apple.getWeight() > 150 );
       //List<Apple> greenApp = filterApples(inventory, new AppleGreenColorPredicate());
       List<Apple> greenApp = filterApples(inventory,(Apple apple) -> Color.RED.equals(apple.getColor()));

       //Comparator<Apple> byWeight =  (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight() );

       System.out.println(heavyApp);
       System.out.println(greenApp);

   }
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
       List<Apple> result = new ArrayList<>();
       for(Apple apple : inventory) {
           if(p.test(apple)) {
               result.add(apple);
           }
       }
       return result;
    }


}

interface ApplePredicate {

    boolean test (Apple apple);
}

@AllArgsConstructor
@Data
class Apple{

    private int weight;
    private Color color;
}


