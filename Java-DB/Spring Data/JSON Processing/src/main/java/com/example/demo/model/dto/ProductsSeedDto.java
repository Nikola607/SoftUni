package com.example.demo.model.dto;

import com.example.demo.model.entity.User;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductsSeedDto {
    private String name;
    private BigDecimal price;

    public ProductsSeedDto() {
    }

    @Size(min = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
