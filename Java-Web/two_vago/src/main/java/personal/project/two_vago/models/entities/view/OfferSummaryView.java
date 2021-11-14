package personal.project.two_vago.models.entities.view;

import personal.project.two_vago.models.entities.Category;
import personal.project.two_vago.models.entities.City;
import personal.project.two_vago.models.entities.Review;
import personal.project.two_vago.models.entities.User;

import java.math.BigDecimal;
import java.util.Set;

public class OfferSummaryView {
    private Long id;
    private String offerName;
    private BigDecimal price;
    private String coordinates;
    private String photoUrl;
    private String description;
    private Category category;
    private City city;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
