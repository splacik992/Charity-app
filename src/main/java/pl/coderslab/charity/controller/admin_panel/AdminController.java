package pl.coderslab.charity.controller.admin_panel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @GetMapping("/dashboard")
    public String getAdminDashboard(){
        return "panel/admin/dashboard";
    }

}
