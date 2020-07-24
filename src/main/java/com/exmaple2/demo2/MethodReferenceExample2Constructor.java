package com.exmaple2.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.Function;

public class MethodReferenceExample2Constructor {
    public static void main(String[]  args){
        final Section section1 = new Section(1);

        final Function<Integer, Section> sectionFactoryWithLamda = i -> new Section(i);
        final Section section1WithLamda = sectionFactoryWithLamda.apply(1);

        final Function<Integer,Section> sectionFunctionWithMethodReference = Section::new;
        final Section section1WithMethodReference = sectionFunctionWithMethodReference.apply(1);

        System.out.println(section1);
        System.out.println(section1WithLamda);
        System.out.println(section1WithMethodReference);

        final OldProduct product = new OldProduct(1L, "A", new BigDecimal("100"));

        final OldProductCreator productCreator = OldProduct::new;
        System.out.println(
            productCreator.create(1L, "A", new BigDecimal("100"))
        );

        final ProdcutA a = createProdcut(1l, "A", new BigDecimal("123"), ProdcutA::new);
        final ProductB b = createProdcut(1l, "B", new BigDecimal("123"), ProductB::new);

        System.out.println(a);
        System.out.println(b);

    }

    private static  <T extends Product> T createProdcut(final Long id,
                                                final String name,
                                                final BigDecimal price,
                                                final ProductCreator<T> productCreator)  {
        if(id == null  || id < 1L) {
            throw new IllegalArgumentException("The id must be a postive Long");
        }
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("the name is not given");
        }
        if(price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("the price muust be greate then 0 ");
        }
        return productCreator.create(id, name,price);
    }
}

@FunctionalInterface
interface  ProductCreator<T extends  Product> {
    T create(Long id, String name, BigDecimal price);
}

@FunctionalInterface
interface OldProductCreator {
    OldProduct create(Long id, String name, BigDecimal price);
}


@AllArgsConstructor
@Data
class Section {
    private int number;
}


@AllArgsConstructor
@Data
abstract class Product{
    private Long id;
    private String name;
    private BigDecimal price;
}


@AllArgsConstructor
@Data
class OldProduct{
    private Long id;
    private String name;
    private BigDecimal price;
}
class ProdcutA extends Product {
    public ProdcutA(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "A = " + super.toString();
    }
}

class ProductB  extends  Product {
    public ProductB(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "B = " + super.toString();
    }
}