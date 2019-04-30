package ru.kursio.application.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kursio.application.model.entity.Role;
import ru.kursio.application.model.entity.User;
import ru.kursio.application.model.exception.InvalidUsernameException;
import ru.kursio.application.model.exception.KursioException;
import ru.kursio.application.model.pojo.AuthenticatedUser;
import ru.kursio.application.model.pojo.ErrorDetails;
import ru.kursio.application.model.session.LoggedCustomer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LoginService {
	
	@Autowired
	private LoggedCustomer loggedCustomer;

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder encoder;

    private static Logger log = LoggerFactory.getLogger(LoginService.class.getName());

    public ResponseEntity<Object> doLogin(User user) {

        if (user == null) {
            throw new KursioException("There was invalid user or no user sent to perform a customer login check");
        }

        try{
        User userFound = userService.getOneByUserName(user.getUserName());
            if (!encoder.matches(user.getPassword(), userFound.getPassword()))
                return new ResponseEntity<>( new ErrorDetails(2, "Incorrect Password"), HttpStatus.BAD_REQUEST);
            loggedCustomer.setLoggedCustomerName(user.getUserName());
            return new ResponseEntity<>(userFound, HttpStatus.OK);
        }catch (InvalidUsernameException iue){
            return new ResponseEntity<>( new ErrorDetails(1, "Incorrect Username"), HttpStatus.BAD_REQUEST);
        }
    }
    
    public void doLogout() {
    	loggedCustomer.deleteLoggedCustomerName();
    }
}
