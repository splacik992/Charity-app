package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.dto.CategoryDto;
import pl.coderslab.charity.entity.dto.DonationDto;
import pl.coderslab.charity.entity.dto.OrganizationDto;
import pl.coderslab.charity.entity.user_security.CurrentUser;
import pl.coderslab.charity.entity.user_security.User;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.OrganizationRepository;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.OrganizationService;
import pl.coderslab.charity.service.security.UserService;

import java.util.List;

@Controller
@RequestMapping("/form")
public class FormController {

    private final DonationService donationService;
    private final CategoryService categoryService;
    private final OrganizationService organizationService;
    private final UserService userService;

    public FormController(DonationService donationService, CategoryService categoryService, CategoryRepository categoryRepository, OrganizationService organizationService, DonationRepository donationRepository, CategoryRepository categoryRepository1, OrganizationRepository organizationRepository, UserService userService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.organizationService = organizationService;
        this.userService = userService;
    }

    @GetMapping
    public String getDonationForm(Model model) {
        List<CategoryDto> categories = categoryService.getCategoryListFromDB();
        List<OrganizationDto> organizations = organizationService.getAllOrganizations();
        model.addAttribute("organizations", organizations);
        model.addAttribute("categories", categories);
        model.addAttribute("donation", new Donation());

        return "form";
    }

    @PostMapping
    public String confirmDonationForm(DonationDto donation, @AuthenticationPrincipal CurrentUser currentUser){

        User userByEmail = userService.findByEmail(currentUser.getAppUser().getEmail());
        System.out.println(userByEmail.getEmail());
        donation.setUser(userByEmail);
        donationService.saveDonation(donation);
        return "form-confirmation";
    }


}
