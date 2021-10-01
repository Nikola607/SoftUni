package com.example.models.entity;

import com.example.models.entity.enums.Engine;
import com.example.models.entity.enums.Transmission;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "offers")
public class Offer extends BaseEntity{
    private String description;
    private Engine engine;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private Transmission transmission;
    private Integer year;
    private List<Model> models;
    private User seller;

    public Offer() {
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Column
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column
    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column
    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Column
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    @ManyToOne()
    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    //     id – uuid or number.
// description – some text.
//             engine – enumerated value (GASOLINE, DIESEL, ELECTRIC, HYBRID).
//             imageUrl – the url of image.
//             mileage – a number.
//             price – the price of the offer.
// transmission – enumerated value (MANUAL, AUTOMATIC).
//             year – the year of offered car.
// created – a date and time.
//             modified – a date and time.
//             model – the model of a car.
// seller – a user that sells the car.
}
