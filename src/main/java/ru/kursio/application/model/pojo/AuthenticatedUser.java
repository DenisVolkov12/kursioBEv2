package ru.kursio.application.model.pojo;

import ru.kursio.application.model.entity.User;

public class AuthenticatedUser {

    private User user;

    public AuthenticatedUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
