package Encapsulation.ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setHeight(double height) {
        if(height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    private void setWidth(double width) {
        if(width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setLength(double length) {
        if(length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public double calculateSurfaceArea(){
        return this.calculateLateralSurfaceArea () + 2 * this.length * this.width;
    }

    public double calculateLateralSurfaceArea(){
        return 2*(this.height * this.width + this.height * this.length);
    }

    public double calculateVolume(){
        return this.length * this.width * this.height;
    }

    @Override
    public String toString(){
        return String.format("Surface Area - %.2f\n" +
                "Lateral Surface Area - %.2f\n" +
                "Volume – %.2f", calculateSurfaceArea(), calculateLateralSurfaceArea(), calculateVolume());
    }

}
