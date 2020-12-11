package pl.coderslab.charity.controller.user_panel;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.user_security.CurrentUser;
import pl.coderslab.charity.entity.user_security.User;
import pl.coderslab.charity.service.security.UserService;

@Controller
@RequestMapping("/user")
public class UserController {


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

}
