package ExamPreparation.easterRaces.entities.cars;

import static ExamPreparation.easterRaces.common.ExceptionMessages.*;

public abstract class BaseCar implements Car {
    private String model;
    private int horsePower;
    private double cubicCentimetres;

    protected BaseCar(String model, int horsePower, double cubicCentimetres) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setCubicCentimetres(cubicCentimetres);
    }

    public void setModel(String model) {
        if (model == null || model.length() < 4 ||
                model.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setCubicCentimetres(double cubicCentimetres) {
        this.cubicCentimetres = cubicCentimetres;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimetres;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.cubicCentimetres / horsePower * laps;
    }
}
