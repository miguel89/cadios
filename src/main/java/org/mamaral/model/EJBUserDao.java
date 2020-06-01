package org.mamaral.model;

import javax.ejb.Stateful;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateful
@Default
public class EJBUserDao implements UserDao {

    @Inject
    private EntityManager entityManager;

    @Override
    public User get(Long id) {
        try {
            Query query = entityManager.createQuery("select u from User u where u.id = :id");
            query.setParameter("id", id);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<User> listUsers() {
        try {
            Query query = entityManager.createQuery("select u from User u");
            return (List<User>) query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        if (!entityManager.contains(user)) {
            user = entityManager.merge(user);
        }
        entityManager.remove(user);
    }
}
