package ru.kursio.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kursio.application.model.entity.User;
import ru.kursio.application.model.pojo.LoginObject;
import ru.kursio.application.service.AuthService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import static ru.kursio.application.constants.Constants.LOGIN_ROOT_PATH;

@RestController
@RequestMapping(LOGIN_ROOT_PATH)
public class LoginController {

	@Autowired
	private AuthService authService;

	@PostMapping
	@CrossOrigin
	public ResponseEntity<Object> doLocalLogin(@RequestBody @Valid @NotNull LoginObject creds) {
		return authService.doLocalLogin(creds);
	}
}