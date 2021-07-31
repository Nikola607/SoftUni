package softuni.exam.instagraphlite.models.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "posts")
public class Posts extends BaseEntity{
    private String caption;
    private Users user;
    private Pictures picture;

    public Posts() {
    }

    @Column(nullable = false)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @ManyToOne(optional = false)
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @ManyToOne(optional = false)
    public Pictures getPicture() {
        return picture;
    }

    public void setPicture(Pictures picture) {
        this.picture = picture;
    }
}
