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
import ru.kursio.application.model.exception.*;
import ru.kursio.application.model.pojo.ErrorDetails;
import ru.kursio.application.model.pojo.facebook.FacebookUser;
import ru.kursio.application.util.ValidationUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static ru.kursio.application.constants.Constants.*;

@Service
public class RenatQuizService {

	private static Logger log = LoggerFactory.getLogger(RenatQuizService.class.getName());

	@Autowired
	private RenatQuizDao renatQuizDao;

	public ResponseEntity<Object> findAllColorQuizQuestions() {
		List<ColorQuizQuestion> questions = renatQuizDao.findAll();
		if(ValidationUtil.objectIsNotNull(questions))
			return new ResponseEntity<>(renatQuizDao.findAll(), HttpStatus.OK);
		return new ResponseEntity<>(new ErrorDetails(MSG_RENAT_QUESTIONARY_NOT_FOUND), HttpStatus.BAD_REQUEST);
	}

	private ColorQuizQuestion findById(Long id) throws InvalidParamException, NotFoundException {
		if(!ValidationUtil.objectIsNotNull(id))
			throw new InvalidParamException(MSG_INVALID_PARAM);
		Optional<ColorQuizQuestion> question = renatQuizDao.findById(id);
		return question.orElseThrow(NotFoundException::new);
	}

	public ResponseEntity<Object> saveQuestion(ColorQuizQuestion question){
		if(!ValidationUtil.objectIsNotNull(question))
			return new ResponseEntity<>(new ErrorDetails(MSG_INVALID_PARAM), HttpStatus.BAD_REQUEST);
		ColorQuizQuestion savedQuestion = renatQuizDao.save(question);
		if(ValidationUtil.objectIsNotNull(savedQuestion))
			return new ResponseEntity<>(savedQuestion, HttpStatus.OK);
		return new ResponseEntity<>(new ErrorDetails(MSG_RENAT_QUESTIONARY_NOT_FOUND), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> deleteQuestionById(Long id){
		try {
			this.findById(id);
		} catch (InvalidParamException e) {
			return new ResponseEntity<>(new ErrorDetails(MSG_INVALID_PARAM), HttpStatus.BAD_REQUEST);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(new ErrorDetails(MSG_QUESTION_NOT_FOUND), HttpStatus.BAD_REQUEST);
		}
		renatQuizDao.deleteById(id);
		return new ResponseEntity<>(true, HttpStatus.BAD_REQUEST);
	}
}

