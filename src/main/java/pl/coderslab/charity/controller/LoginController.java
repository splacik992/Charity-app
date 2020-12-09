package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {



    @GetMapping("/login")
    public String getLoginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String confirmLogin(){
        return "redirect:/";
    }
}
