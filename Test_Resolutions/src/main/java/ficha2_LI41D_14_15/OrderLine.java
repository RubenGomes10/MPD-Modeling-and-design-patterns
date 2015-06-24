package ficha2_LI41D_14_15;

/**
 * Created by Ruben Gomes on 24/06/2015.
 */
public class OrderLine {

    private Product product;
    private int quantity;

    public OrderLine( Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
