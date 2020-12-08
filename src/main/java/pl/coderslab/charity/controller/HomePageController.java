package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.dto.OrganizationDto;
import pl.coderslab.charity.service.OrganizationService;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomePageController {

    private final OrganizationService organizationService;
    public HomePageController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public String getAllOrganizations(Model model) {
        List<OrganizationDto> organizationDtoList = organizationService.getAllOrganizations();
        model.addAttribute("organizations", organizationDtoList);
        return "index";
    }
}
