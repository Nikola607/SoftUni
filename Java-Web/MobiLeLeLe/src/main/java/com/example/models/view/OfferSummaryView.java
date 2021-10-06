package com.example.models.view;

import com.example.models.entity.enums.Engine;
import com.example.models.entity.enums.Transmission;

public class OfferSummaryView {
    private long id;
    private String description;
    private Engine engine;
    private String imageUrl;
    private int mileage;
    private int price;
    private Transmission transmission;
    private int year;
    private String model;

    public long getId() {
        return id;
    }

    public OfferSummaryView setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferSummaryView setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public OfferSummaryView setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferSummaryView setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OfferSummaryView setPrice(int price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferSummaryView setTransmission(
            Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferSummaryView setYear(int year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferSummaryView setModel(String model) {
        this.model = model;
        return this;
    }
}
