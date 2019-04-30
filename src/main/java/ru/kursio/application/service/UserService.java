package ru.kursio.application.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kursio.application.dao.RoleDao;
import ru.kursio.application.dao.UserDao;
import ru.kursio.application.model.entity.Role;
import ru.kursio.application.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kursio.application.model.exception.InvalidUsernameException;
import ru.kursio.application.model.exception.KursioException;
import ru.kursio.application.model.pojo.ErrorDetails;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

	// The Logger for User Service
	private static Logger log = LoggerFactory.getLogger(UserService.class.getName());

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;

	public List<User> list() {
		return userDao.findAll();
	}

	public void saveUser(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role customerRole = roleDao.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(customerRole)));
		userDao.save(user);
	}

	public User getOneByUserName(String userName) throws InvalidUsernameException {

			if (userName == null || userName.isEmpty()) {
				log.error("Failed in CustomerService.getOneByUserName(String userName)");
				throw new KursioException("Param ( String ) userName to find one customer came null or empty!");
			}
			Long foundUserId = userDao.findUserIdByUserName(userName);
			if (foundUserId != null) {
				User found = getOneUserById(foundUserId);
				if (found != null)
					return found;
			}
		//User not found
		throw new InvalidUsernameException("User with username "+userName+" was not found");

	}

	private User getOneUserById(Long userId) {
		if(userId != null){
			return userDao.getOne(userId);
		}
		throw new KursioException("User not Found!");
	}
}