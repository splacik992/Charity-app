package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.EmailService;
import pl.coderslab.charity.service.OrganizationService;

@Controller
@RequestMapping("/")
public class HomePageController {

    private final OrganizationService organizationService;
    private final DonationService donationService;
    private final EmailService emailService;

    public HomePageController(OrganizationService organizationService, DonationService donationService, EmailService emailService) {
        this.organizationService = organizationService;
        this.donationService = donationService;
        this.emailService = emailService;
    }

    @GetMapping
    public String getAllOrganizations(Model model) {

        model.addAttribute("bag", donationService.getCountOfBags());
        model.addAttribute("gift", donationService.getSumOfGifts());
        model.addAttribute("organizations", organizationService.getAllOrganizations());
        return "index";
    }

    @PostMapping("/sendEmail")
    public String sendEmailToCharityAppByUser(@RequestParam String email, @RequestParam String firstName,
                                              @RequestParam String lastName, @RequestParam String message) {

        String sb = "Email: " + email + "\n" +
                "Imie: " + firstName + "\n" +
                "Nazwisko: " + lastName + "\n" +
                "Wiadomość: " + message;
        emailService.prepareAndSend("r.paliwoda992@gmail.com", sb, "Wiadomość od użytkownika");
        return "redirect:/";
    }


}
