package ru.kursio.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kursio.application.model.entity.auth.User;
import ru.kursio.application.model.exception.*;
import ru.kursio.application.model.pojo.ErrorDetails;
import ru.kursio.application.model.pojo.LocalLoginUser;
import ru.kursio.application.model.pojo.facebook.FacebookUser;
import ru.kursio.application.util.ValidationUtil;

import static ru.kursio.application.constants.Constants.*;

@Service
public class AuthService {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder encoder;

    private static Logger log = LoggerFactory.getLogger(AuthService.class.getName());

    public ResponseEntity<Object> doLocalLogin(LocalLoginUser creds) {

        if (!ValidationUtil.objectIsNotNull(creds))
            return new ResponseEntity<>(new ErrorDetails(MSG_BAD_OR_EMPTY_JSON), HttpStatus.BAD_REQUEST);

        try {
            User userFound = userService.getOneByUserName(creds.getUserName());
            if (!encoder.matches(creds.getPassword(), userFound.getPassword()))
                return new ResponseEntity<>(new ErrorDetails(MSG_INCORRECT_PASSWORD), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(userFound, HttpStatus.OK);

        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(new ErrorDetails(MSG_USER_NOT_FOUND), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> doLocalRegister(User user) {
        if (!ValidationUtil.objectIsNotNull(user))
            return new ResponseEntity<>( new ErrorDetails(MSG_BAD_OR_EMPTY_JSON), HttpStatus.BAD_REQUEST );
        try {
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.ACCEPTED);
        } catch (UserNameAlreadyExistsException e) {
            return new ResponseEntity<>(new ErrorDetails(MSG_USERNAME_ALREADY_EXISTS), HttpStatus.BAD_REQUEST);
        } catch (InvalidParamException e) {
            return new ResponseEntity<>(new ErrorDetails(MSG_INVALID_PARAM), HttpStatus.BAD_REQUEST);
        } catch (EmailAlreadyExistsException e) {
            return new ResponseEntity<>(new ErrorDetails(MSG_EMAIL_ALREADY_EXISTS), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> isUserNameAvailable(String username) {
        try {
            return new ResponseEntity<>(!userService.isUserNameExists(username), HttpStatus.OK);
        } catch (InvalidParamException e) {
            return new ResponseEntity<>(new ErrorDetails(MSG_EMPTY_USERNAME), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> isEmailAvailable(String email) {
        try {
            return new ResponseEntity<>(!userService.isEmailExists(email), HttpStatus.OK);
        } catch (InvalidParamException e) {
            return new ResponseEntity<>(new ErrorDetails(MSG_EMPTY_USERNAME), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> doFacebookLogin(FacebookUser facebookUser){
        return new ResponseEntity<>(userService.doFacebookLogin(facebookUser), HttpStatus.OK);
    }
}
