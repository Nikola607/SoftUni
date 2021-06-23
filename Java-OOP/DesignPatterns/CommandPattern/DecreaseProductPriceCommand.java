package DesignPatterns.CommandPattern;

public class DecreaseProductPriceCommand implements Command{
    private final Product product;
    private final int amount;

    public DecreaseProductPriceCommand(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String executeCommand() {
        this.product.DecreasePrice(this.amount);
        return String.format("The price for the product %s has been decreased by %d.\n", this.product.getName(), this.amount);
    }
}
