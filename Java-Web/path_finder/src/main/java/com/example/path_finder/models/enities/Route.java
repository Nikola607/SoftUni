package com.example.path_finder.models.enities;

import com.example.path_finder.models.enities.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "routes")
public class Route extends BaseEntity{
    private String coordinates;
    private LevelEnum level;
    private String name;
    private User author;
    private String url;
    private Set<Categories> categories;

    public Route() {
    }

    @Column(nullable = false, columnDefinition = "Text")
    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToMany
    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }
}
