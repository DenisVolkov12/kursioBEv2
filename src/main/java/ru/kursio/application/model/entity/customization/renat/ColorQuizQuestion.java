package ru.kursio.application.model.entity.customization.renat;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "color_quiz_question")
public class ColorQuizQuestion {
    @Id
    @Column(name = "color_quiz_question_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long colorQuestionId;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "direction", nullable = false)
    private String direction;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "color_quiz_question_color_quiz_answer", joinColumns = @JoinColumn(name = "color_quiz_question_id"), inverseJoinColumns = @JoinColumn(name = "color_quiz_answer_id"))
    private Set<ColorQuizAnswer> answers;

    public long getColorQuestionId() {
        return colorQuestionId;
    }

    public void setColorQuestionId(long colorQuestionId) {
        this.colorQuestionId = colorQuestionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Set<ColorQuizAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<ColorQuizAnswer> answers) {
        this.answers = answers;
    }
}




