package softuni.exam.instagraphlite.models.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "pictures")
public class Pictures extends BaseEntity{
    private String path;
    private double size;

    public Pictures() {
    }

    @Column(nullable = false, unique = true)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(nullable = false, length = 60000)
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
