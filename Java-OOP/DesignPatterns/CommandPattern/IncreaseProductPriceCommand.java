package DesignPatterns.CommandPattern;

public class IncreaseProductPriceCommand implements Command{
    private final Product product;
    private final int amount;

    public IncreaseProductPriceCommand(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String executeCommand() {
        this.product.IncreasePrice(this.amount);
        return String.format("The price for the product %s has been decreased by %d.\n", this.product.getName(), this.amount);
    }
}