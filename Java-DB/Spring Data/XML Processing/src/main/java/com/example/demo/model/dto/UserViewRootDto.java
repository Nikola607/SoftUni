package com.example.demo.model.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewRootDto {

    @XmlElement(name = "user")
    List<UserWithSoldProductDto> products;

    public List<UserWithSoldProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<UserWithSoldProductDto> products) {
        this.products = products;
    }
}
