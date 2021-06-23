package Polymorphism.Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        this.calculateArea();
        this.calculatePerimeter();
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(Math.PI * this.radius);
    }

    @Override
    protected void calculateArea() {
        setArea(Math.PI * this.radius * this.radius);
    }
}
