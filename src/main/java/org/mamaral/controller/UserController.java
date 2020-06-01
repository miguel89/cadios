package org.mamaral.controller;

import org.mamaral.model.User;
import org.mamaral.model.UserDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class UserController {

    @Inject
    private UserDao userDao;

    @Inject
    private UserList userList;

    public void deleteUser(User user) {
        this.userList.invalidate();
        this.userDao.delete(user);
    }
}
