package ficha2_LI41D_14_15;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Ruben Gomes on 23/06/2015.
 */
public class Order {

    private double total;
    private Customer customer;
    private List<OrderLine> orderLines;
    private int year;

    public Order(Customer customer,List<OrderLine> orderLines,int year, double total){
        this.customer = customer;
        this.orderLines = orderLines;
        this.year = year;
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Stream<OrderLine> getOrderLines() {
        return orderLines.stream();
    }


    public double getTotal() {
        return total;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString(){
        return "Order requested by " + getCustomer().getName() +" in " + getYear() + " with total price of " + getTotal() +" € ";
    }
}



