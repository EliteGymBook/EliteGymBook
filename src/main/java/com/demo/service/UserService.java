package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.beans.User;

public interface UserService {

	List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
}
