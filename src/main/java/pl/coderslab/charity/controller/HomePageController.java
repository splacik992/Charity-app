package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.OrganizationService;

@Controller
@RequestMapping("/")
public class HomePageController {

    private final OrganizationService organizationService;
    private final DonationService donationService;


    public HomePageController(OrganizationService organizationService, DonationService donationService) {
        this.organizationService = organizationService;
        this.donationService = donationService;
    }

    @GetMapping
    public String getAllOrganizations(Model model) {

        model.addAttribute("bag", donationService.getCountOfBags());
        model.addAttribute("gift", donationService.getSumOfGifts());
        model.addAttribute("organizations", organizationService.getAllOrganizations());
        return "index";
    }
}
