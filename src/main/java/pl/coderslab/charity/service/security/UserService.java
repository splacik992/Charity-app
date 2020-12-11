package pl.coderslab.charity.service.security;

import pl.coderslab.charity.entity.user_security.User;

public interface UserService {
    void saveUser(User appUser);
    User findByEmail(String email);
}

