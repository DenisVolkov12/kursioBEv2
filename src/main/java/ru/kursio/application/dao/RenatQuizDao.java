package ru.kursio.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kursio.application.model.entity.customization.renat.ColorQuizQuestion;

@Repository
public interface RenatQuizDao extends JpaRepository<ColorQuizQuestion, Long> {
}
