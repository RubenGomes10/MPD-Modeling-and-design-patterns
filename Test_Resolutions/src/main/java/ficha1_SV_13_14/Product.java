package ficha1_SV_13_14;

/**
 * Created by Ruben Gomes on 25/06/2015.
 */
public class Product {

    public int unitsInStock;
    public String productName;
    public double price;
    public  int id;

    public Product(int id,String productName,double price,int unitsInStock){
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.unitsInStock = unitsInStock;
    }

    @Override
    public String toString(){
        return "Product { productId = "+id+", productName = "+productName+", price = " +price+", unitsInStock = "+unitsInStock+"}";
    }

}
