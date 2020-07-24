package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionIneterFaceExample {
    public static void main(String[] args) {
        final Product productA = new Product(1L, "A", new BigDecimal("10.00"));
        final Product productB = new Product(2L, "B", new BigDecimal("55.00"));
        final Product productC = new Product(3L, "C", new BigDecimal("17.45"));
        final Product productD = new Product(4L, "D", new BigDecimal("20.00"));
        final Product productE = new Product(5L, "E", new BigDecimal("110.99"));

        final List<Product> products = Arrays.asList(
                productA,
                productB,
                productC,
                productD,
                productE
        );
        /*
        final List<Product> result = new ArrayList<>();
        for(final Product product : products) {
            if (product.getPrice().compareTo(new BigDecimal("20")) >= 0) {
                result.add(product);
            }
        }

        System.out.println(result);
         */
        final BigDecimal twenty = new BigDecimal("20");
        System.out.println("product >= $20 " + filter(products, product -> product.getPrice().compareTo(twenty) >= 0));
        System.out.println("product <= $10 " + filter(products, product -> product.getPrice().compareTo(new BigDecimal("10")) <= 0));

        final List<Product> expensiveProducts = filter(products, product -> product.getPrice().compareTo(new BigDecimal("50")) > 0);
        /*
        final List<DiscountedProduct> discountedProducts = new ArrayList<>();
        for(final Product product : expensiveProducts){
            discountedProducts.add(new DiscountedProduct(product.getId(), product.getName(), product.getPrice()));
        }
        */
        final List<Product> discountedProducts =
                map(expensiveProducts, product -> new DiscountedProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));


        System.out.println(" Expendsive prodcuts " + expensiveProducts);
        System.out.println(" discount prodcuts " + discountedProducts);

        final Predicate<Product> lessthanOrEqulto30 = product -> product.getPrice().compareTo(new BigDecimal("30")) <= 0;
        System.out.println(" discount product ($<30) " +
                filter(discountedProducts, lessthanOrEqulto30)
        );

        System.out.println(" discount product ($<30) " +
                filter(products, lessthanOrEqulto30));
    /*
        final List<BigDecimal> prices = map(products, product -> product.getPrice());
        BigDecimal total = BigDecimal.ZERO;
        for(final BigDecimal price : prices){
            total = total.add(price);
        }
      */
        final BigDecimal total = total(products, product -> product.getPrice());
        System.out.println("total " + total);

        final BigDecimal discounttotal = total(discountedProducts, product -> product.getPrice());
        System.out.println("discounttotal " + discounttotal);


        Order order = new Order(1L, "on-1234", Arrays.asList(
                new OrderItem(1L, productA, 2),
                new OrderItem(2L, productC, 1),
                new OrderItem(2L, productD, 10)
        ));

        System.out.println("total : " + order.totalPrice());
    }

    private static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        final List<T> result = new ArrayList<>();
        for (final T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    private static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> mapper) {
        //final List<BigDecimal> result = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        for (final T t : list) {
            total = total.add(mapper.apply(t));
        }
        return total;
    }


    @AllArgsConstructor
    @Data
    static class Product {
        private Long id;
        private String name;
        private BigDecimal price;
    }

    @ToString(callSuper = true)
    static class DiscountedProduct extends Product {
        public DiscountedProduct(final Long id, final String name, final BigDecimal price) {
            super(id, name, price);
        }
    }

    @AllArgsConstructor
    @Data
    static class OrderItem {
        private Long id;
        private Product product;
        private int qnantity;

        public BigDecimal getItemTotal(){
            return product.getPrice().multiply(new BigDecimal(qnantity));
        }
    }

    @AllArgsConstructor
    @Data
    static class Order {
        private Long id;
        private String orderNumber;
        private List<OrderItem> items;

        public BigDecimal totalPrice() {
            return total(items, item -> item.getItemTotal());
        }
    }
}