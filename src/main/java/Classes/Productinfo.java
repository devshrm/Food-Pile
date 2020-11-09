package Classes;

import java.io.Serializable;

public class Productinfo implements Serializable {

    public String name;
    public String category;
    public int price;
    public int qty;

    public Productinfo(String name, String category, int price, int qty) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return qty;
    }
}
