package ru.kursio.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kursio.application.dao.RoleDao;
import ru.kursio.application.dao.UserDao;
import ru.kursio.application.model.entity.Role;
import ru.kursio.application.model.entity.User;
import ru.kursio.application.model.exception.EmailAlreadyExistsException;
import ru.kursio.application.model.exception.InvalidParamException;
import ru.kursio.application.model.exception.UserNameAlreadyExistsException;
import ru.kursio.application.model.exception.UserNotFoundException;
import ru.kursio.application.util.ValidationUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ru.kursio.application.constants.Constants.*;

@Service
public class UserService {

	private static Logger log = LoggerFactory.getLogger(UserService.class.getName());

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;

	public List<User> list() {
		return userDao.findAll();
	}

	public User saveUser(User user) throws UserNameAlreadyExistsException, InvalidParamException, EmailAlreadyExistsException {
		try{

			if(isEmailExists(user.getEmail())) {
				throw new EmailAlreadyExistsException(MSG_EMAIL_ALREADY_EXISTS);
			}
			if(!isUserNameExists(user.getUserName()) ) {
				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
				user.setActive(true);
				//Set by default role Student
				Role role = new Role();
				Set<Role> hRoles = new HashSet<>();
				role.setRoleType("STUDENT");
				hRoles.add(role);
				user.setRoles(hRoles);
				return userDao.save(user);
			}
			throw new UserNameAlreadyExistsException(MSG_USERNAME_ALREADY_EXISTS);
		}catch (InvalidParamException ipe){
			throw new InvalidParamException(MSG_INVALID_PARAM);
		}
	}

	public User getOneByUserName(String userName) throws UserNotFoundException {
			User userFound = userDao.findByUserName(userName);
			if(userFound == null)
				throw new UserNotFoundException(MSG_USER_NOT_FOUND);
			return userFound;
	}

	public boolean isUserNameExists(String userName) throws InvalidParamException  {

		if (userName == null || !ValidationUtil.stringIsNotEmpty(userName)) {
			throw new InvalidParamException(MSG_EMPTY_USERNAME);
		}

		User found = userDao.findByUserName(userName);

		//Does not need validation since a false is expected to run username check
		return found != null;
	}

	public boolean isEmailExists(String email) throws InvalidParamException  {

		if (email == null || !ValidationUtil.stringIsNotEmpty(email)) {
			throw new InvalidParamException(MSG_EMPTY_EMAIL);
		}

		User found = userDao.findByEmail(email);

		//Does not need validation since a false is expected to run email check
		return found != null;
	}
}

