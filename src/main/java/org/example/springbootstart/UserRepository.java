package org.example.springbootstart;

import jakarta.persistence.EntityManager;
import org.example.springbootstart.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Repository
//public class UserRepository {
//    @Autowired
//    private EntityManager entityManager;
//
//    @Transactional
//    public void save(User user) {
//        entityManager.persist(user);
//    }
// }
