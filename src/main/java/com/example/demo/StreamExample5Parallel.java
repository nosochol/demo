package com.example.demo;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamExample5Parallel {
    public static void main(String[] args){
        final int[] sum = {0};
        IntStream.range(0,100)
                .forEach(i -> sum[0] += i);

        System.out.println("sum : " + sum[0]);
        System.out.println("================================");
        final int[] sum2 = {0};
        IntStream.range(0,100)
                .parallel()
                .forEach(i -> sum2[0] += i);

        System.out.println("parall sum(side-effect) : " + sum[0]);

        System.out.println("================================");
        System.out.println( " stream sum  " +
        IntStream.range(0,100)
                .sum()
        );

        System.out.println("================================");
        System.out.println( " stream parallel sum  " +
                IntStream.range(0,100)
                        .parallel()
                        .sum()
        );
        System.out.println("================================");
       //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
        final long start = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i-> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start);
    }
}
