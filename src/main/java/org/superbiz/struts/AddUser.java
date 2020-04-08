package org.superbiz.struts;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

@Component
public class AddUser {

    private final UserService service;

    public AddUser(UserService service) {
        this.service = service;
    }

    private long id;
    private String firstName;
    private String lastName;
    private String errorMessage;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Transactional
    public String execute() {

        try {
            service.add(new User(id, firstName, lastName));
        } catch (Exception e) {
            this.errorMessage = e.getMessage();
            return "failure";
        }

        return "success";
    }
}
