package ru.kursio.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kursio.application.model.entity.customization.renat.ColorQuizQuestion;
import ru.kursio.application.service.RenatQuizService;

import javax.validation.Valid;

import static ru.kursio.application.constants.Constants.COLOR_QUIZ;
import static ru.kursio.application.constants.Constants.RENAT_ROOT_PATH;

@RestController
@RequestMapping(RENAT_ROOT_PATH)
public class RenatQuizController {

	@Autowired
	private RenatQuizService renatQuizService;

	@GetMapping(COLOR_QUIZ)
	@CrossOrigin
	public ResponseEntity<Object> findAllColorQuizQuestions() {
		return renatQuizService.findAll();
	}

	@PostMapping(COLOR_QUIZ)
	@CrossOrigin
	public ResponseEntity<Object> saveColorQuizQuestion(@RequestBody @Valid ColorQuizQuestion question) {
		return renatQuizService.save(question);
	}

	@DeleteMapping(COLOR_QUIZ)
	@CrossOrigin
	public ResponseEntity<Object> deleteColorQuizQuestionById(@RequestBody @Valid ColorQuizQuestion question) {
		return renatQuizService.deleteById(question.getColorQuestionId());
	}
}