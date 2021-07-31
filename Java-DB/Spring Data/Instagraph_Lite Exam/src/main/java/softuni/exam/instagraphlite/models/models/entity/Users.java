package softuni.exam.instagraphlite.models.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
public class Users extends BaseEntity{
    private String username;
    private String password;
    private Pictures profilePicture;
    private Set<Posts> posts;

    public Users() {
    }

    @Column(nullable = false, length = 18, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne
    public Pictures getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Pictures profilePicture) {
        this.profilePicture = profilePicture;
    }

    @OneToMany(mappedBy = "user")
    public Set<Posts> getPosts() {
        return posts;
    }

    public void setPosts(Set<Posts> posts) {
        this.posts = posts;
    }
}
