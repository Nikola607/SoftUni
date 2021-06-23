package DesignPatterns.CommandPattern;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void IncreasePrice(int amount){
        setPrice(this.price + amount);
    }

    public void DecreasePrice(int amount){
        setPrice(this.price - amount);
    }

    public String toString(){
        return String.format("Current price for the product %s is %d.\n", this.name, this.price);
    }
}
