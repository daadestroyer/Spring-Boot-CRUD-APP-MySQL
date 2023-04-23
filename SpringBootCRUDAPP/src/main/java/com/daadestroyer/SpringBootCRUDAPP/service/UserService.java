package com.daadestroyer.SpringBootCRUDAPP.service;

import com.daadestroyer.SpringBootCRUDAPP.entity.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);

    public List<User> getAllUser();

    public User getUser(Long userId);

    public User updateUser(User user);

    public String deleteUser(Long userId);
}
