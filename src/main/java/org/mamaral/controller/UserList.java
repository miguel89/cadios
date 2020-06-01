package org.mamaral.controller;

import org.mamaral.model.User;

import java.util.List;

public interface UserList {
    List<User> getAll();

    void invalidate();
}
