package Polymorphism.Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        this.calculateArea();
        this.calculatePerimeter();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(this.width * this.width * this.height + this.height);
    }

    @Override
    protected void calculateArea() {
        setArea(this.width * this.height);
    }
}
