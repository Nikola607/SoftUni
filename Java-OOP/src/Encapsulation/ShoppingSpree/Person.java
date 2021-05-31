package Encapsulation.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName ());
        } else {
            this.money -= product.getCost();

            products.add(product);
            System.out.println(this.name + " bought " + product.getName());
        }
    }

    public String getName() {
        return name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    private void setName(String name) {
        if (name == null || name.trim ().isEmpty ()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(this.name + " - ");
        if(this.products.isEmpty()){
            sb.append("Nothing bought");
        }else{
            for(int i = 0; i<products.size(); i++){
                if (i < products.size() - 1){
                    sb.append(products.get(i).getName()).append(", ");
                }else{
                    sb.append(products.get(i).getName());
                }
            }
        }
        return sb.toString();
    }
}
