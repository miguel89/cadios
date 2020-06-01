package org.mamaral.model;

import java.util.List;

public interface UserDao {
    User get(Long id);
    List<User> listUsers();
    void save(User user);
    void edit(User user);
    void delete(User user);
}
