package softuni.exam.instagraphlite.models.models.xmldto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostsSeedDto {
    @XmlElement(name = "caption")
    private String caption;
    @XmlElement(name = "user")
    private UsersDto user;
    @XmlElement(name = "picture")
    private PicturesDto picture;

    @NotBlank
    @Size(min = 21)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @NotNull
    public UsersDto getUser() {
        return user;
    }

    public void setUser(UsersDto user) {
        this.user = user;
    }

    @NotNull
    public PicturesDto getPicture() {
        return picture;
    }

    public void setPicture(PicturesDto picture) {
        this.picture = picture;
    }
}
