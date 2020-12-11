package pl.coderslab.charity.controller.user_panel;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.user_security.CurrentUser;
import pl.coderslab.charity.entity.user_security.User;
import pl.coderslab.charity.repository.security.UserRepository;
import pl.coderslab.charity.service.security.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String getUserDashboard() {
        return "panel/user/dashboard";
    }

    @GetMapping("/details")
    public String getUserDetails(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        User appUser = currentUser.getAppUser();
        model.addAttribute("user",appUser);
        return "panel/user/details";
    }

    @GetMapping("/edit")
    public String editUserDetailsForm(Model model, @AuthenticationPrincipal CurrentUser currentUser){

        User appUser = currentUser.getAppUser();
        model.addAttribute("user",appUser);
        return "panel/user/edit";
    }

    @PostMapping("/edit")
    public String confirmEditUserDetailsForm(@AuthenticationPrincipal CurrentUser currentUser,
                                             @RequestParam String email,
                                             @RequestParam String firstName,
                                             @RequestParam String lastName){
        User user1 = currentUser.getAppUser();
        user1.setFirstName(firstName);
        user1.setLastName(lastName);
        user1.setEmail(email);
        userRepository.save(user1);
        return "redirect:/user/details";
    }

}
