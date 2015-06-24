package ficha2_LI41D_14_15;

import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.*;

/**
 * Created by Ruben Gomes on 23/06/2015.
 */
public class Implementations {


    //
    //2.1
    //
    public static double getPricesWithReduce() {
        return OrdersRepository.getOrders()
                .map(Order::getTotal)
                .reduce(0.0, (price1, price2) -> price1 + price2);
    }


    public static double getPricesWithCollect() {
        return OrdersRepository.getOrders()
                .collect(summingDouble(Order::getTotal));
    }


    public static double getPriceWithDoubleStream(){
        return OrdersRepository.getOrders()
                .mapToDouble(Order::getTotal)
                .sum();
    }


    //
    //2.2
    //

    public static List<Order> getOrders2012To2015SortedDec() {
        return OrdersRepository.getOrders()
                .filter((order) -> order.getYear() >= 2012 && order.getTotal() <= 2015)
                .sorted(comparing(Order::getTotal).reversed())
                .collect(toList());
    }

    //
    //2.3
    //


    public static List<String> getCountryNames() {
        return OrdersRepository.getOrders()
                .map(Order::getCustomer)
                .map(Customer::getCountry)
                .distinct()
                .collect(toList());
    }



    //
    //2.4
    //

    public static void printSoldProduct(){
         OrdersRepository.getOrders()
                .forEach(
                        (order) -> {
                            System.out.printf(
                                    "----Order Total price : %s € requested by %s for  orderLines above----- \n",
                                    order.getTotal(),
                                    order.getCustomer().getName()
                                    );
                            order.getOrderLines()
                                    .forEach((orderLine) -> {
                                                System.out.printf(
                                                        "Product : %s , Quantity : %d ;\n",
                                                        orderLine.getProduct().getName(),
                                                        orderLine.getQuantity()
                                                );
                                            }
                                    );

                        }
                );
    }




    //
    //2.5 - 4 versions of getMaxOrderPrice
    //


    public static double getMaxOrderPriceWithCollect(){
        return OrdersRepository.getOrders()
                .collect(maxBy(comparing(Order::getTotal)))
                .get()
                .getTotal();
    }

    public static double getMaxOrderPrice(){
        return OrdersRepository.getOrders()
                .mapToDouble(Order::getTotal)
                .max()
                .getAsDouble();
    }

    public static double getMaxOrderPriceWithReducingOneParam(){
        return OrdersRepository.getOrders()
                .collect(
                        reducing((p1,p2)-> p1.getTotal() >= p2.getTotal()? p1 : p2)
                )
                .get()
                .getTotal();
    }

    public static double getMaxOrderPriceWithReducingThreeParams(){
        return OrdersRepository.getOrders()
                .collect(reducing(
                                0.0,
                                Order::getTotal,
                                (p1,p2)-> p1>=p2 ? p1 : p2
                        )
                ).doubleValue();
    }

    //
    //2.6 - Average
    //

    public static double getAverageInSpain(){
        return OrdersRepository.getOrders()
                .filter((order)-> order.getCustomer().getCountry().equals("Spain"))
                .mapToDouble(Order::getTotal)
                .average()
                .getAsDouble();

    }


    public static double getAverageInSpainWithCollect(){
        return OrdersRepository.getOrders()
                .filter((order)-> order.getCustomer().getCountry().equals("Spain"))
                .collect(averagingDouble(Order::getTotal));
    }

    //
    //2.7 Print 5 customer who spend more
    //


    public static void printFiveCustomerWhoSpendMore(){
        Map<Customer,Double> customerSpends =
                OrdersRepository.getOrders()
                        .collect(groupingBy(Order::getCustomer, summingDouble(Order::getTotal)));

        customerSpends.entrySet().stream()
                .sorted(comparingDouble((Map.Entry<Customer,Double> d)->d.getValue()).reversed())
                .limit(5)
                .forEach(
                        (customer) ->
                                System.out.printf("Name = %s , Country = %s spend : %s €\n",
                                        customer.getKey().getName(),
                                        customer.getKey().getCountry(),
                                        customer.getValue()
                                )
                );
    }


}

