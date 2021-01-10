package pl.coderslab.charity.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.user_security.User;
import pl.coderslab.charity.service.EmailService;
import pl.coderslab.charity.service.security.UserService;

@Controller
public class LoginController {

    private final UserService userService;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;


    public LoginController(UserService userService, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/remind/password", method = RequestMethod.GET)
    public String getLostPasswordPage() {
        return "password_reminder";
    }

    @RequestMapping(value = "/remind/password{email}", method = RequestMethod.POST)
    public String sendEmailWithPasswordToUser(@RequestParam String email) {
        User user = userService.findByEmail(email);
        if (user.getEmail().equals(email)) {
            emailService.prepareAndSend(user.getEmail(), "Link do zmiany hasła : " +
                            "http://app-charity.herokuapp.com/change/password/" + user.getEmail() + "/" +
                            user.getHashCodeForSetAccountEnabled(),
                    "Zmiana hasła - Charity App");
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/change/password/{email}/{hashCode}", method = RequestMethod.GET)
    public String getChangePasswordForm(Model model, @PathVariable String email) {
        User userByEmail = userService.findByEmail(email);
        model.addAttribute("user", userByEmail);
        return "password_change";
    }

    @RequestMapping(value = "/change/password/{email}/{hashCode}", method = RequestMethod.POST)
    public String sendChangePasswordForm(Model model, @PathVariable String email, @PathVariable String hashCode,
                                         @RequestParam String password, @RequestParam String password2) {
        User userByEmail = userService.findByEmail(email);
        model.addAttribute("user", userByEmail);
        if (password.equals(password2)) {
            if(userByEmail.getHashCodeForSetAccountEnabled().equals(hashCode)) {
                userByEmail.setPassword(passwordEncoder.encode(password));
                userService.updateUser(userByEmail);
            }
        }
        return "redirect:/login";
    }
}