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

    @Column(name = "question")
    private String question;

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

    public Set<ColorQuizAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<ColorQuizAnswer> answers) {
        this.answers = answers;
    }
}




