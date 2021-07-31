package softuni.exam.instagraphlite.models.models.xmldto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostsSeedRootDto {
    @XmlElement(name = "post")
    private List<PostsSeedDto> posts;

    public List<PostsSeedDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsSeedDto> posts) {
        this.posts = posts;
    }
}
