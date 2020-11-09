package Classes;

import java.io.Serializable;

public class Additem implements Serializable {

    public String name;
    public String category;
    public int price;
    public int qty;
    public int threshold;

    public Additem(String name, String category, int price, int qty, int threshold) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.qty = qty;
        this.threshold = threshold;
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

    public int getThreshold() {
        return threshold;
    }
}
