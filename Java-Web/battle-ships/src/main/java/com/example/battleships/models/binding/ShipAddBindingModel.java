package com.example.battleships.models.binding;

import com.example.battleships.models.entities.enums.CategoryNamesEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ShipAddBindingModel {
    private String name;
    private Integer health;
    private Integer power;
    private LocalDate created;
    private CategoryNamesEnum category;

    public ShipAddBindingModel() {
    }

    @Size(min = 2, max = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Positive
    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    @Positive
    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @NotNull
    public CategoryNamesEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNamesEnum category) {
        this.category = category;
    }
}
