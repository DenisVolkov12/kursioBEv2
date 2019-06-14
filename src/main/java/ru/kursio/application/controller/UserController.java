package ru.kursio.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kursio.application.model.entity.auth.User;
import ru.kursio.application.service.AuthService;
import ru.kursio.application.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static ru.kursio.application.constants.Constants.*;

@RestController
@RequestMapping(USER_ROOT_PATH)
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(GET_ONE_USER_BY_ID)
	@CrossOrigin
	public ResponseEntity<Object> getOneUserById(@RequestBody User user) {
		return userService.findUserById(user.getUserId());
	}

}