package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.User;

import java.util.List;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User appUser);
    List<User> findAll();
}

