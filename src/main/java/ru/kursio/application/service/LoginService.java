package ru.kursio.application.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kursio.application.model.entity.Role;
import ru.kursio.application.model.entity.User;
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

    public Object doLogin(List<User> userList) {

        if (userList == null) {
            log.info("Failed in LoginService.doLogin(Customer customer)");
            throw new KursioException("There was invalid user or no user sent to perform a customer login check");
        }
        if(userList.size() > 1)
            throw new KursioException("You are sending more than one user to authenticate, please send only 1");

        User user = userList.get(0);
        User userFound = userService.getOneByUserName(user.getUserName());

        if(userFound != null){
            if (!encoder.matches(user.getPassword(), userFound.getPassword()))
                return new ErrorDetails("Incorrect Password", HttpStatus.NOT_FOUND);
            loggedCustomer.setLoggedCustomerName(user.getUserName());
            return userFound;
        }
        return new ErrorDetails("Incorrect Username", HttpStatus.NOT_FOUND);
    }
    
    public void doLogout() {
    	loggedCustomer.deleteLoggedCustomerName();
    }
}
