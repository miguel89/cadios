package org.mamaral.controller;

import org.mamaral.model.Phone;
import org.mamaral.model.PhoneType;
import org.mamaral.model.User;
import org.mamaral.model.UserDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class CreateUserController {

    @Inject
    private UserDao userDao;

    private User user;

    public void createUser(String name, String email, String password, String mobileAC,
                           String mobile, String landlineAC, String landline) {
        User user = new User();

        user.setFullName(name);
        user.setEmail(email);
        user.setPassword(password.toCharArray());

        if (mobile != null && !mobile.isEmpty()) {
            Phone phone = new Phone();

            phone.setAreaCode(mobileAC);
            phone.setNumber(mobile);
            phone.setType(PhoneType.MOBILE);

            user.getPhones().add(phone);
        }

        if (landline != null && !landline.isEmpty()) {
            Phone phone = new Phone();

            phone.setAreaCode(landlineAC);
            phone.setNumber(landline);
            phone.setType(PhoneType.LANDLINE);

            user.getPhones().add(phone);
        }

        this.userDao.save(user);
    }

    public User getUser() {
        if (this.user == null) {
            this.user = new User();
        }
        return user;
    }
}
