package com.example.demo;

public class ClosureExample {

    private int number = 999;

    public static void main(String[] args) {
        new ClosureExample().test1();
    }

    public static <T> String toString(T value){
        return "the value is " + String.valueOf(value) + ".";
    }

    public String toString(){
        return new StringBuffer("CloseExaple{")
                .append("numbe =" )
                .append(number)
                .append("}")
                .toString();
    }

    private void test1(){
        final int number = 100;

        testClosure("Anonymous Class",  new Runnable() {
            @Override
            public void run() {
                System.out.println(this.toString());
                System.out.println("ClouseExaple.this.toString() : " + ClosureExample.this.toString("Test"));
            }
        });


        testClosure("Lambda Expression", () -> System.out.println(this.toString("Test")));

    }

    private static void testClosure(final String name, Runnable runable){
        System.out.println("===================");
        runable.run();
        System.out.println("===================");
    }
}
