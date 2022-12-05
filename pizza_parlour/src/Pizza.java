import java.util.*;

class Pizza {
    private String pizzaname;
    private String size;
    private double price;
    public Pizza( String pizzaname, String size, double price) {
        this.pizzaname = pizzaname;
        this.size = size;
        this.price = price;

    }

    public Pizza() {

    }


    public String getPizzaname() {
        return pizzaname;
    }

    public void setPizzaname(String pizzaname) {
        this.pizzaname = pizzaname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaname='" + pizzaname + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}
