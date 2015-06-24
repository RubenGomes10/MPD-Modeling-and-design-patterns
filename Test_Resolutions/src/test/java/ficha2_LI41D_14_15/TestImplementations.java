package ficha2_LI41D_14_15;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Ruben Gomes on 24/06/2015.
 */
public class TestImplementations {



    //
    //Total expected = 225
    //
    //2.1
    @Test
    public void test_get_prices_with_reduce(){

        double sumPrices = Implementations.getPricesWithReduce();
        System.out.printf("Sum Prices -> %s \n",sumPrices);
        assertEquals(225.0, sumPrices, 0);

    }

    @Test
    public void test_get_prices_with_collect(){

        double sumPrices = Implementations.getPricesWithCollect();
        System.out.printf("Sum Prices -> %s \n",sumPrices);
        assertEquals(225.0,sumPrices,0);
    }

    @Test
    public void test_get_prices_with_doubleStream(){
        double sumPrices = Implementations.getPriceWithDoubleStream();
        System.out.printf("Sum Prices -> %s \n",sumPrices);
        assertEquals(225.0,sumPrices,0);
    }

    //2.2
    @Test
    public void test_get_orders_2012_To_2015_sorted_dec(){
        List<Order> orders = Implementations.getOrders2012To2015SortedDec();

        orders.stream().forEach(System.out::println);

    }

    //2.3
    @Test
    public void test_get_countries_names(){
        List<String> names = Implementations.getCountryNames();
        names.forEach(System.out::println);
    }

    //2.4
    @Test
    public void test_get_print_Product_sold(){

        Implementations.printSoldProduct();
    }

    //2.5

    @Test
    public void get_max_order_price_with_collect(){

        double maxPrice = Implementations.getMaxOrderPriceWithCollect();

        //List<Double> prices = OrdersRepository.getOrders().collect(mapping(Order::getTotal, toList()));
        //prices.stream().forEach(System.out::println);

        Map<Customer,Double> prices = OrdersRepository.getOrders().collect(groupingBy(Order::getCustomer,summingDouble(Order::getTotal)));
        prices.entrySet().stream()
                .forEach(
                        (entry) -> System.out.printf(
                                "Order requested by %s have total price : %s € \n",
                                entry.getKey().getName(),
                                entry.getValue()
                        )
                );

        System.out.printf("max = %s",maxPrice);
        assertEquals(88.5, maxPrice, 0);

    }

    @Test
    public void get_max_order_price(){

        double maxPrice = Implementations.getMaxOrderPrice();
        List<Double> prices = OrdersRepository.getOrders().collect(mapping(Order::getTotal, toList()));
        prices.stream().forEach(System.out::println);

        System.out.printf("max = %s",maxPrice);
        assertEquals(88.5,maxPrice,0);
    }

    @Test
    public void get_max_order_price_with_reducing_one_param(){

        double maxPrice = Implementations.getMaxOrderPriceWithReducingOneParam();
        List<Double> prices = OrdersRepository.getOrders().collect(mapping(Order::getTotal, toList()));
        prices.stream().forEach(System.out::println);

        System.out.printf("max = %s",maxPrice);
        assertEquals(88.5,maxPrice,0);


    }


    @Test
    public void get_max_order_price_with_reducing_three_params(){

        double maxPrice = Implementations.getMaxOrderPriceWithReducingThreeParams();
        List<Double> prices = OrdersRepository.getOrders().collect(mapping(Order::getTotal, toList()));
        prices.stream().forEach(System.out::println);

        System.out.printf("max = %s",maxPrice);
        assertEquals(88.5,maxPrice,0);


    }

    //2.6

    @Test
    public void get_average_in_spain(){

        double average = Implementations.getAverageInSpain();

        Map<Customer,Double> priceByCustomer = OrdersRepository.getOrders()
                .collect(groupingBy(Order::getCustomer, summingDouble(Order::getTotal)));

        // filter to the spain
        System.out.println("--Customer`s living in Spain--");
        priceByCustomer.entrySet().stream()
                .filter((customer)-> customer.getKey().getCountry().equals("Spain"))
                .forEach((customer)->
                    System.out.printf(
                            " Order requested by %s with total cost : %s € \n",
                            customer.getKey().getName(),
                            customer.getValue()
                    )
                );

        System.out.printf("average = %s",average);

        assertEquals(27.0,average,0);
    }


    @Test
    public void get_average_in_spain_with_collect(){

        double average = Implementations.getAverageInSpainWithCollect();

        Map<Customer,Double> priceByCustomer = OrdersRepository.getOrders()
                .collect(groupingBy(Order::getCustomer, summingDouble(Order::getTotal)));

        // filter to the spain
        System.out.println("--Customer`s living in Spain--");
        priceByCustomer.entrySet().stream()
                .filter((customer)-> customer.getKey().getCountry().equals("Spain"))
                .forEach((customer)->
                                System.out.printf(
                                        " Order requested by %s with total cost : %s € \n",
                                        customer.getKey().getName(),
                                        customer.getValue()
                                )
                );

        System.out.printf("average = %s",average);

        assertEquals(27.0,average,0);
    }

    //2.7
    @Test
    public void test_print_five_Customer_who_spend_more(){

        Map<Customer,Double> prices = OrdersRepository.getOrders().collect(groupingBy(Order::getCustomer,summingDouble(Order::getTotal)));
        prices.entrySet().stream()
                .forEach(
                        (entry) -> System.out.printf(
                                "Order requested by %s have total price : %s € \n",
                                entry.getKey().getName(),
                                entry.getValue()
                        )
                );
        Implementations.printFiveCustomerWhoSpendMore();


    }
}
