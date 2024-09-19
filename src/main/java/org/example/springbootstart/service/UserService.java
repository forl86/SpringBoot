package org.example.springbootstart.service;

import org.example.springbootstart.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void add(User u);
    void delete(User u);
    void edit(User u);
    User getById(int id);
}
