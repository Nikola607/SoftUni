package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {

    private double averageGrade;

    private int attendance;

    private Set<Course> courses;

    public Student() {
    }

    @Column(name = "average_grades")
    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Column(name = "attendances")
    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    @ManyToMany
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
