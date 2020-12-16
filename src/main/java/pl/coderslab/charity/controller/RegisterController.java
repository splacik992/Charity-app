package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.user_security.User;
import pl.coderslab.charity.service.EmailService;
import pl.coderslab.charity.service.security.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;
    private final EmailService emailService;

    public RegisterController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
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
            model.addAttribute("messagePassword",error);
            return "register";
        }

        User user1 = userService.findByEmail(user.getEmail());
        if(user1==null){
            userService.saveUser(user);
            emailService.prepareAndSend(user.getEmail(),"Aby potwierdzić rejestracje kliknij w link poniżej: \n " ,"Charity - Potwierdzenie rejestracji");
        }else {
            String error = "Użytkownik już istnieje!";
            model.addAttribute("message",error);
            return "register";
        }
        return "redirect:/login";
    }
}
