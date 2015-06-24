package ficha2_LI41D_14_15;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Ruben Gomes on 23/06/2015.
 */
public class OrdersRepository {






    public static Stream<Order> getOrders() {

        // total 88.5 year = 2015
        final List<OrderLine> orderLineForRúben =
                Arrays.asList(
                        new OrderLine(new Product("Fortex",2.0),2),
                        new OrderLine(new Product("AJAX",4.0),2),
                        new OrderLine(new Product("FORTEX",3.0),4),
                        new OrderLine(new Product("BOLACHA OREO",2.0),4),
                        new OrderLine(new Product("BOLACHA MARIA",1.0),5),
                        new OrderLine(new Product("COCA-COLA",1.5),5),
                        new OrderLine(new Product("SUMOL",1.0),2),
                        new OrderLine(new Product("PEPSI",1.0),4),
                        new OrderLine(new Product("CERVEJA SAGRES",5.0),6),
                        new OrderLine(new Product("LICOR BEIRÃO",8.0),1)
                );

        // total = 24.0  year = 2013
        final List<OrderLine> orderLineForJohn=
                Arrays.asList(
                        new OrderLine(new Product("Fortex",2.0),2),
                        new OrderLine(new Product("AJAX",4.0),2),
                        new OrderLine(new Product("FORTEX",3.0),4)
                );

        // total = 38.0  year = 2013
        final List<OrderLine> orderLineForPatric =
                Arrays.asList(
                        new OrderLine(new Product("CERVEJA SAGRES",5.0),6),
                        new OrderLine(new Product("LICOR BEIRÃO",8.0),1)
                );

        // total = 40.5 year = 2015
        final List<OrderLine> orderLineForBob =
                Arrays.asList(
                        new OrderLine(new Product("AJAX",4.0),2),
                        new OrderLine(new Product("FORTEX",3.0),4),
                        new OrderLine(new Product("BOLACHA OREO",2.0),4),
                        new OrderLine(new Product("BOLACHA MARIA",1.0),5),
                        new OrderLine(new Product("COCA-COLA",1.5),5)

                );

        //total = 20.5  year = 2014
        final List<OrderLine> orderLineForPazzini  =
                Arrays.asList(
                        new OrderLine(new Product("BOLACHA OREO",2.0),4),
                        new OrderLine(new Product("BOLACHA MARIA",1.0),5),
                        new OrderLine(new Product("COCA-COLA",1.5),5)
                );

        //total = 13.5 year = 2011
         final List<OrderLine> orderLineForLourenzo =
                Arrays.asList(
                        new OrderLine(new Product("COCA-COLA",1.5),5),
                        new OrderLine(new Product("SUMOL",1.0),2),
                        new OrderLine(new Product("PEPSI",1.0),4)
                );

        return Arrays.asList(
                    new Order(new Customer("Rúben Gomes","Portugal"),orderLineForRúben,2015,88.5),
                    new Order(new Customer("John","England"),orderLineForJohn,2013,24.0),
                    new Order(new Customer("Patric","France"),orderLineForPatric,2013,38.0),
                    new Order(new Customer("Puyol","Spain"),orderLineForBob,2015,40.5),
                    new Order(new Customer("Pazzini","Italy"),orderLineForPazzini,2014,20.5),
                    new Order(new Customer("Lourenzo","Spain"),orderLineForLourenzo,2011,13.5)
                )
                .stream();
    }
}
