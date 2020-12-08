package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Organization;
import pl.coderslab.charity.entity.dto.CategoryDto;
import pl.coderslab.charity.entity.dto.OrganizationDto;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.OrganizationService;

import java.util.List;

@Controller
@RequestMapping("/form")
public class FormController {

    private final DonationService donationService;
    private final CategoryService categoryService;
    private final OrganizationService organizationService;

    public FormController(DonationService donationService, CategoryService categoryService, CategoryRepository categoryRepository, OrganizationService organizationService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.organizationService = organizationService;
    }

    @GetMapping
    public String getDonationForm(Model model) {
        List<CategoryDto> categories = categoryService.getCategoryListFromDB();
        List<OrganizationDto> organizations = organizationService.getAllOrganizations();

        model.addAttribute("organizations", organizations);
        model.addAttribute("categories", categories);
        model.addAttribute("organization",new Organization());
        model.addAttribute("donation", new Donation());
        model.addAttribute("category", new Category());

        return "form";
    }




}
