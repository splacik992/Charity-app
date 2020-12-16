package pl.coderslab.charity.service.security;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.user_security.Role;
import pl.coderslab.charity.entity.user_security.User;
import pl.coderslab.charity.repository.security.RoleRepository;
import pl.coderslab.charity.repository.security.UserRepository;

import java.util.Collections;
import java.util.HashSet;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void updateUser(User appUser) {
        userRepository.save(appUser);
    }

    @Override
    public void saveUser(User appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        appUser.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        appUser.setHashCodeForSetAccountEnabled(
                givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect());
        userRepository.save(appUser);
    }


    public String givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect() {
        return RandomStringUtils.randomAlphanumeric(100);
    }
}
