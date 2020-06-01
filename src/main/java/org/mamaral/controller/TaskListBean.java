package org.mamaral.controller;

import org.mamaral.model.User;
import org.mamaral.model.UserDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("userList")
@RequestScoped
public class TaskListBean implements UserList {

    private List<User> userList;

    @Inject
    private UserDao userDao;


    @Override
    public List<User> getAll() {
        if (this.userList == null) {
            this.userList = this.userDao.listUsers();
        }
        return this.userList;
    }

    @Override
    public void invalidate() {
        this.userList = null;
    }
}
