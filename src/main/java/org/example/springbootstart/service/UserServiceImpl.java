package org.example.springbootstart.service;

import org.example.springbootstart.dao.UserDao;
import org.example.springbootstart.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    public void add(User u) {
        userDao.add(u);
    }

    @Override
    public void delete(User u) {
        userDao.delete(u);
    }

    @Override
    public void edit(User u) {
        userDao.edit(u);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }
}
