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

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "direction", nullable = false)
    private String direction;

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
}




