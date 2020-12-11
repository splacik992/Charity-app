package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.user_security.User;
import pl.coderslab.charity.service.security.UserService;

import javax.validation.Valid;

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
    public String confirgmRegisterForm(@Valid User user,BindingResult result,Model model,
                                       @RequestParam("password") String password,
                                       @RequestParam("password2") String password2){

        if(result.hasErrors()){
            return "register";
        }
        if(!password.equals(password2)){
            String error = "Hasło musi być takie same!";
            model.addAttribute("messagePassword");
            return "register";
        }

        User user1 = userService.findByEmail(user.getEmail());
        if(user1==null){
            userService.saveUser(user);
        }else {
            String error = "Użytkownik już istnieje!";
            model.addAttribute("message",error);
            return "register";
        }
        return "redirect:/login";
    }
}
