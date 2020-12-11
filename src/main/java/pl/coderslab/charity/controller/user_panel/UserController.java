package pl.coderslab.charity.controller.user_panel;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.user_security.CurrentUser;
import pl.coderslab.charity.entity.user_security.User;
import pl.coderslab.charity.repository.security.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/dashboard")
    public String getUserDashboard() {
        return "panel/user/dashboard";
    }

    @GetMapping("/details")
    public String getUserDetails(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        User appUser = currentUser.getAppUser();
        model.addAttribute("user", appUser);
        return "panel/user/details";
    }

    @GetMapping("/edit")
    public String editUserDetailsForm(Model model, @AuthenticationPrincipal CurrentUser currentUser) {

        User appUser = currentUser.getAppUser();
        model.addAttribute("user", appUser);
        return "panel/user/edit";
    }

    @PostMapping("/edit")
    public String confirmEditUserDetailsForm(@AuthenticationPrincipal CurrentUser currentUser,
                                             @RequestParam String email,
                                             @RequestParam String firstName,
                                             @RequestParam String lastName) {
        User user1 = currentUser.getAppUser();
        user1.setFirstName(firstName);
        user1.setLastName(lastName);
        user1.setEmail(email);
        userRepository.save(user1);
        return "redirect:/user/details";
    }


    @GetMapping("/edit/password")
    public String editPasswordForm(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        User appUser = currentUser.getAppUser();
        model.addAttribute("user", appUser);
        return "panel/user/editPassword";
    }

    @PostMapping("/edit/password")
    public String confirmChangePasswordForm(@AuthenticationPrincipal CurrentUser currentUser,
                                            @RequestParam String password,
                                            @RequestParam String matchingPassword) {
        User appUser = currentUser.getAppUser();
        if (password.equals(matchingPassword)) {
            appUser.setPassword(passwordEncoder.encode(password));
        }
        userRepository.save(appUser);
        return "redirect:/user/details";
    }


}
