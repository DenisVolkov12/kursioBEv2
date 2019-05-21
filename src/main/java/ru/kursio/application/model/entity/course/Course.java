package ru.kursio.application.model.entity.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.kursio.application.model.entity.auth.User;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private Long courseId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "course_title")
    private String courseTitle;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_category", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @Column(name = "enrolled_students_amount")
    private int enrolledStudentsAmount;

    @Column(name = "duration")
    private String duration;

    @Column(name = "level")
    private String level;

    @Column(name = "course_header_image")
    private String course_header_image;

    @Lob
    @Column(name = "course_description")
    private String courseDescription;

    @Column(name = "course_price_before")
    private long coursePriceBefore;

    @Column(name = "course_price_after")
    private long coursePriceAfter;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Review> reviews;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public int getEnrolledStudentsAmount() {
        return enrolledStudentsAmount;
    }

    public void setEnrolledStudentsAmount(int enrolledStudentsAmount) {
        this.enrolledStudentsAmount = enrolledStudentsAmount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCourse_header_image() {
        return course_header_image;
    }

    public void setCourse_header_image(String course_header_image) {
        this.course_header_image = course_header_image;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public long getCoursePriceBefore() {
        return coursePriceBefore;
    }

    public void setCoursePriceBefore(long coursePriceBefore) {
        this.coursePriceBefore = coursePriceBefore;
    }

    public long getCoursePriceAfter() {
        return coursePriceAfter;
    }

    public void setCoursePriceAfter(long coursePriceAfter) {
        this.coursePriceAfter = coursePriceAfter;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
