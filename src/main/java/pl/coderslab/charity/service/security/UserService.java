package pl.coderslab.charity.service.security;

import pl.coderslab.charity.entity.user_security.User;

import java.util.List;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User appUser);
    List<User> findAll();
}

