package ru.kursio.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kursio.application.model.entity.User;
import ru.kursio.application.model.pojo.ErrorDetails;
import ru.kursio.application.model.session.LoggedCustomer;
import ru.kursio.application.service.UserService;

import javax.validation.Valid;
import java.util.List;

import static ru.kursio.application.constants.Constants.USER_ROOT_PATH;


@RestController
@RequestMapping(USER_ROOT_PATH)
public class CustomerController {
	// The Logger for User Service
	private static Logger log = LoggerFactory.getLogger(CustomerController.class.getName());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoggedCustomer loggedCustomer;

	@GetMapping
	public List<User> list() {
		return userService.list();
	}
	@PostMapping
	@CrossOrigin
	public Object getUser(@RequestBody @Valid List<User> userNameList) {
		if(loggedCustomer.getLoggedCustomerName() != null && !loggedCustomer.getLoggedCustomerName().isEmpty()) {
			log.info("User: ".concat(loggedCustomer.getLoggedCustomerName()));
			return userService.getOneByUserName(userNameList.get(0).getUserName());
		}
		return new ErrorDetails("You are not loggued", HttpStatus.NOT_FOUND);
	}
}
