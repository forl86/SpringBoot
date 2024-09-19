package org.example.springbootstart.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.springbootstart.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> allUsers() {
        Query query = entityManager.createQuery("from User");
        return (List<User>) query.getResultList();
    }

    @Override
    @Transactional
    public void add(User u) {
        entityManager.persist(u);
    }

    @Override
    @Transactional
    public void delete(User u) {
        entityManager.remove(u);
    }

    @Override
    @Transactional
    public void edit(User u) {
        entityManager.merge(u);
    }

    @Override
    @Transactional
    public User getById(int id) {
        org.hibernate.query.Query<User> query = (org.hibernate.query.Query<User>) entityManager.createQuery("from User u where u.id=:id", User.class);
        query.setParameter("id", id);
        return query.uniqueResult();
    }

}
