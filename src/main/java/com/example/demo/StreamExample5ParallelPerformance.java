package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;
/*
public class StreamExample5ParallelPerformance {
    private static final String[] priceStrings = {"1.0","100.99","35.75","21.30","88.0"};
    private static final Random random = new Random(123);

    private static final List<Product> products;

    static {
        final int length = 8_000_000;
        final List<Product> list = new ArrayList<>();

        for(int i = 0; i< length; i++){
            list.add(new Product((long) i, "Product" + i, new BigDecimal(priceStrings[random.nextInt(5)]) ));

        }
        products = Collections.unmodifiableList(list);
    }

    private static  BigDecimal imperativeSum(List<Product> products, Predicate<Product> predicate) {
        BigDecimal sum = BigDecimal.ZERO;
        for(final Product product : products) {
            if(predicate.test(product)) {
                sum = sum.add(product.getPrice());
            }
        }

        return sum;
    }

    private static BigDecimal streamSum(final Stream<Product> stream, final Predicate<Product> predicate){
        return stream.filter(predicate).map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static void imperativeTest(BigDecimal targetPrice){
        System.out.println("-------------imprative sum  ----------");
        System.out.println("sum :  "+
                imperativeSum(products, product -> product.getPrice().compareTo(targetPrice) >= 0)
        );
    }

    private static void streamTest(BigDecimal targetPrice){
        System.out.println("-------------Stream sum  ----------");
        System.out.println("sum :  "+
                streamSum(products.stream(), product -> product.getPrice().compareTo(targetPrice) >= 0)
        );
    }

    private static void parallelStreamTest(BigDecimal targetPrice){
        System.out.println("-------------PrallelStream sum  ----------");
        System.out.println("sum :  "+
                streamSum(products.parallelStream(), product -> product.getPrice().compareTo(targetPrice) >= 0)
        );
    }


    public static void main(String[] args){
        final BigDecimal targetPrice = new BigDecimal("40");
        imperativeTest(targetPrice);
        streamTest(targetPrice);
        parallelStreamTest(targetPrice);
    }
}


@AllArgsConstructor
@Data
class Product{
    private Long id;
    private String name;
    private BigDecimal price;
}

 */