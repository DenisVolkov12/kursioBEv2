package ru.kursio.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kursio.application.model.entity.User;
import ru.kursio.application.service.AuthService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static ru.kursio.application.constants.Constants.CHECK_USERNAME;
import static ru.kursio.application.constants.Constants.REGISTER_ROOT_PATH;

@RestController
@RequestMapping(REGISTER_ROOT_PATH)
public class RegisterController {

	@Autowired
	private AuthService authService;

	@PostMapping
	@CrossOrigin
	public ResponseEntity<Object> doLocalRegister(@RequestBody @Valid @NotNull User user) {
		return authService.doLocalRegister(user);
	}

	@PostMapping(CHECK_USERNAME)
	@CrossOrigin
	public ResponseEntity<Object> isUserNameAvailable(@RequestBody @NotEmpty User user ) {
		return authService.isUserNameAvailable(user.getUserName());
	}
}