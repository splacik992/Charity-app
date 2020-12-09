package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.user_security.User;
import pl.coderslab.charity.service.security.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterForm(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping
    public String confirgmRegisterForm(User user,@RequestParam("password") String password,
                                       @RequestParam("password2") String password2){
        if(!password.equals(password2)){
            userService.saveUser(user);
        }else {
            return "register";
        }

        return "redirect:/";
    }
}
