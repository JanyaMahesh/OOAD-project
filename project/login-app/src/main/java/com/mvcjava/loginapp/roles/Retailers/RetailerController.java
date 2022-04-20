package com.mvcjava.loginapp.roles.Retailers;

import com.mvcjava.loginapp.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RetailerController
{
    @Autowired
    private RetailerService retailerService;


    @GetMapping("/displayretailers")
    public String displayretailers(Model model) {
        model.addAttribute("listretailers", retailerService.getAllRetailers());
        return "retailers";
    }

}
