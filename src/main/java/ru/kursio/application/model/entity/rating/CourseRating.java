package ru.kursio.application.model.entity.rating;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.kursio.application.model.entity.course.Category;
import ru.kursio.application.model.entity.course.Review;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courseRating")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CourseRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseRatingId")
    private Long courseId;

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

    @Column(name = "course_image")
    private String course_image;

    @Lob
    @Column(name = "course_description")
    private String courseDescription;

    @Column(name = "course_price_before")
    private long coursePriceBefore;

    @Column(name = "price")
    private long price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Review> reviews;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public String getCourse_image() {
        return course_image;
    }

    public void setCourse_image(String course_image) {
        this.course_image = course_image;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
