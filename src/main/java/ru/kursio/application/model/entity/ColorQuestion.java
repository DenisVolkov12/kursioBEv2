package ru.kursio.application.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "colorQuestion")
public class ColorQuestion {
    @Id
    @Column(name = "color_question_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long colorQuestionId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;
}




