package ru.kursio.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kursio.application.dao.RenatQuizDao;
import ru.kursio.application.dao.RoleDao;
import ru.kursio.application.dao.UserDao;
import ru.kursio.application.model.entity.auth.Role;
import ru.kursio.application.model.entity.auth.User;
import ru.kursio.application.model.entity.customization.renat.ColorQuizQuestion;
import ru.kursio.application.model.exception.EmailAlreadyExistsException;
import ru.kursio.application.model.exception.InvalidParamException;
import ru.kursio.application.model.exception.UserNameAlreadyExistsException;
import ru.kursio.application.model.exception.UserNotFoundException;
import ru.kursio.application.model.pojo.ErrorDetails;
import ru.kursio.application.model.pojo.facebook.FacebookUser;
import ru.kursio.application.util.ValidationUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ru.kursio.application.constants.Constants.*;

@Service
public class RenatQuizService {

	private static Logger log = LoggerFactory.getLogger(RenatQuizService.class.getName());

	@Autowired
	private RenatQuizDao renatQuizDao;

	public ResponseEntity<Object> list() {
		if(ValidationUtil.objectIsNotNull(renatQuizDao.findAll()))
			return new ResponseEntity<>(renatQuizDao.findAll(), HttpStatus.OK);
		return new ResponseEntity<>(new ErrorDetails(MSG_RENAT_QUESTIONARY_NOT_FOUND), HttpStatus.BAD_REQUEST);
	}
}

