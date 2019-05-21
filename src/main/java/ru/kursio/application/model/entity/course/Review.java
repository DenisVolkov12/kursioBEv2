package ru.kursio.application.model.entity.course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.kursio.application.model.entity.course.Course;

import javax.persistence.*;

@Entity
@Table(name = "review")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Long reviewId;

    @Column(name = "given_score")
    private double givenScore;

    @Column(name = "out_of_score")
    private double score;

    @Column(name = "average_score")
    private double averageScore;

    @Column(name = "total_reviews")
    private int totalReviews;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public double getGivenScore() {
        return givenScore;
    }

    public void setGivenScore(double givenScore) {
        this.givenScore = givenScore;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
