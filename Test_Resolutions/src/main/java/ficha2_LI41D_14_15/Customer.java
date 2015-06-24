package ficha2_LI41D_14_15;

/**
 * Created by Ruben Gomes on 23/06/2015.
 */
public class Customer {

    private String name;
    private String country;


    public Customer(String name,String country){

        this.name = name;
        this.country = country;
    }

    public String getCountry(){
     return this.country;
    }

    public String getName(){

        return this.name;
    }

}
