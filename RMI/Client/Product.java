import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private double retailPrice;
    private double storePrice;

    public Product(String name, String description, int quantity, double retailPrice, double storePrice){
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.retailPrice = retailPrice;
        this.storePrice = storePrice;
    }

    /* getters */
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public int getQuantiy(){
        return this.quantity;
    }

    public double getRetailPrice(){
        return this.retailPrice;
    }

    public double getStorePrice(){
        return this.storePrice;
    }
    
}