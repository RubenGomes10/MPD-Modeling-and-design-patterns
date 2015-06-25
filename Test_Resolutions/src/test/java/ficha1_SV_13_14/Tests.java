package ficha1_SV_13_14;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ruben Gomes on 25/06/2015.
 */
public class Tests {

    static Iterable<Product> prodsIter;
    static List<Product> prodsList;

    @BeforeClass
    public static void setUp() {
        List<Product> prods =
                Arrays.asList(
                        new Product(1, "Atum", 5.2, 100),
                        new Product(2, "Sardinha ", 15.2, 10),
                        new Product(3, "Olivas", 11.2, 100),
                        new Product(4, "Batatas", 13.7, 75),
                        new Product(5, "Eliecticos", 9.45, 100)
                );

        prodsIter = prods;
        prodsList =  prods;
    }

    @Test
    public void testReflectedPredicate(){
            prodsList.stream()
                .filter(new ReflectPredicate<>("unitsInStock", 100))
                .filter(new ReflectPredicate<>("productName", "Olivas"))
                .forEach(System.out::println);

    }

    @Test
    public void testReflectEager(){
        ReflectIterable<Product> products = ReflectIterableEager.reflectEager(prodsIter);
        System.out.println("-----Test Eager-----");
        products.filter("unitsInStock",100)
                .filter("productName", "Olivas")
                .forEach(System.out::println);
    }

    @Test
    public void testReflectLazy(){
        ReflectIterable<Product> products = ReflectIterableFilterLazy.reflectLazy(prodsIter);
        System.out.println("---------Test Lazy-----------");

        products.filter("unitsInStock",100)
                .filter("productName", "Olivas")
                .forEach(System.out::println);

    }


}
