package com.daadestroyer.SpringBootCRUDAPP.service.Impl;

import com.daadestroyer.SpringBootCRUDAPP.entity.User;
import com.daadestroyer.SpringBootCRUDAPP.exceptionhandling.ResourceAlreadyExistedException;
import com.daadestroyer.SpringBootCRUDAPP.exceptionhandling.ResourceNotFoundException;
import com.daadestroyer.SpringBootCRUDAPP.repository.UserRepo;
import com.daadestroyer.SpringBootCRUDAPP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;


import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        Optional<User> savedUser = this.userRepo.findById(user.getUserId());
        if (savedUser.isPresent()) {
            throw new ResourceAlreadyExistedException("user", user.getUserId());
        }
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> listOfUser = this.userRepo.findAll();
        if (listOfUser.size() == 0) {
            throw new ResourceNotFoundException("User List");
        }
        return listOfUser;
    }

    @Override
    public User getUser(Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", userId));
        return user;
    }

    @Override
    public User updateUser(User user) {
        User savedUser = this.userRepo.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User", user.getUserId()));
        return this.userRepo.save(user);
    }

    @Override
    public String deleteUser(Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", userId));
        this.userRepo.delete(user);
        return "User with id " + userId + " deleted";
    }

}
