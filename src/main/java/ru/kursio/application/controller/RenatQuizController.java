package ru.kursio.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kursio.application.model.entity.auth.User;
import ru.kursio.application.service.AuthService;
import ru.kursio.application.service.RenatQuizService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static ru.kursio.application.constants.Constants.*;

@RestController
@RequestMapping(RENAT_ROOT_PATH)
public class RenatQuizController {

	@Autowired
	private RenatQuizService renatQuizService;

	@GetMapping(COLOR_QUIZ)
	@CrossOrigin
	public ResponseEntity<Object> getColorQuiz() {
		return renatQuizService.list();
	}
}