package ru.kursio.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kursio.application.dao.RoleDao;
import ru.kursio.application.dao.UserDao;
import ru.kursio.application.model.entity.User;
import ru.kursio.application.model.exception.InvalidParamException;
import ru.kursio.application.model.exception.UserNameAlreadyExistsException;
import ru.kursio.application.model.exception.UserNotFoundException;
import ru.kursio.application.util.ValidationUtil;

import java.util.List;

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

	public User saveUser(User user) throws UserNameAlreadyExistsException, InvalidParamException{
		try{
		if(!isUserNameExists(user.getUserName())) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setActive(true);
			return userDao.save(user);

		}
		throw new UserNameAlreadyExistsException(MSG_USERNAME_ALREADY_EXISTS);
		}catch (InvalidParamException ipe){
			throw new InvalidParamException(MSG_INVALID_PARAM);
		}
	}

	public User getOneByUserName(String userName) throws InvalidParamException, UserNotFoundException {

			if (userName == null || userName.isEmpty()) {
				throw new InvalidParamException(MSG_INVALID_PARAM);
			}
			User userFound = userDao.findByUserName(userName);
			if(userFound == null)
				throw new UserNotFoundException(MSG_USER_NOT_FOUND);
			return userFound;
	}

	public boolean isUserNameExists(String userName) throws InvalidParamException  {

		if (userName == null || userName.isEmpty()) {
			throw new InvalidParamException(MSG_INVALID_PARAM);
		}

		User found = userDao.findByUserName(userName);

		//Does not need validation since a false is expected to run username check
		return found != null;

	}
}