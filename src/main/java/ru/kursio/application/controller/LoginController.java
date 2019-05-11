package ru.kursio.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kursio.application.model.pojo.LocalLoginUser;
import ru.kursio.application.model.pojo.facebook.FacebookUser;
import ru.kursio.application.service.AuthService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static ru.kursio.application.constants.Constants.LOGIN_FACEBOOK;
import static ru.kursio.application.constants.Constants.LOGIN_ROOT_PATH;

@RestController
@RequestMapping(LOGIN_ROOT_PATH)
public class LoginController {

	@Autowired
	private AuthService authService;

	@PostMapping
	@CrossOrigin
	public ResponseEntity<Object> doLocalLogin(@RequestBody @Valid @NotNull LocalLoginUser localCreds) {
		return authService.doLocalLogin(localCreds);
	}

	@PostMapping(LOGIN_FACEBOOK)
	@CrossOrigin
	public ResponseEntity<Object> doFacebookLogin(@RequestBody @Valid @NotNull FacebookUser fUser) {
		return authService.doFacebookLogin(fUser);
	}
}