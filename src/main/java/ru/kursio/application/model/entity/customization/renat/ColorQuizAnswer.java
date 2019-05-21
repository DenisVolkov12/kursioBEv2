package ru.kursio.application.model.entity.customization.renat;

import javax.persistence.*;

@Entity
@Table(name = "color_quiz_answer")
public class ColorQuizAnswer {
    @Id
    @Column(name = "color_quiz_answer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long colorQuizAnswerId;

    @Column(name = "answer", nullable = false)
    private String answer;

    public long getColorQuizAnswerId() {
        return colorQuizAnswerId;
    }

    public void setColorQuizAnswerId(long colorQuizAnswerId) {
        this.colorQuizAnswerId = colorQuizAnswerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}




