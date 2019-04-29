package ru.kursio.application.model.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedCustomer {
    private String loggedCustomerName;

    public String getLoggedCustomerName() {
        return loggedCustomerName;
    }

    public void setLoggedCustomerName(String loggedCustomerName) {
        this.loggedCustomerName = loggedCustomerName;
    }
    
    public void deleteLoggedCustomerName() {
        this.loggedCustomerName = null;
    }
}
