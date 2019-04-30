package ru.kursio.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kursio.application.model.entity.User;
import ru.kursio.application.service.LoginService;
import javax.validation.Valid;


import static ru.kursio.application.constants.Constants.LOGIN_ROOT_PATH;

@RestController
@RequestMapping(LOGIN_ROOT_PATH)
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping
	@CrossOrigin
	public ResponseEntity<Object> doLogin(@RequestBody @Valid User user) {
		return loginService.doLogin(user);
	}
}