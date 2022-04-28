package com.mvcjava.loginapp.product;

import com.mvcjava.loginapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ProductController
{
    @Autowired
    private ProductService productService;

    @GetMapping("/retailer")
    public String getretailerpage()
    {
        return "retailer_dashboard";
    }
    @GetMapping("/addproducts")
    public String getproductform(Model model)
    {
        System.out.println("********here");
        model.addAttribute("productRequest",new Product());
        return "add_prod";
    }

    @PostMapping("/addproducts")
    public String postaddproduct(@RequestParam("file")MultipartFile file,@RequestParam("name") String name,@RequestParam("category") String category,@RequestParam("description") String description,@RequestParam("price") Integer price)
    {
        productService.storeproduct(file,name,category,description,price);
        return "redirect:/retailer";
    }

    @GetMapping("/displayproducts")
    public String showproducts(Model model)
    {
        model.addAttribute("listproducts",productService.getAllproducts());
        return "products";
    }

    @GetMapping("/viewstationary")
    public String prod_stationary(@RequestParam("name") String name, Model model)
    {
        model.addAttribute("username",name);
        model.addAttribute("resultproducts",productService.getstationary());
        return "show_results";
    }

    @GetMapping("/viewsports")
    public String prod_sports(@RequestParam("name") String name, Model model)
    {
        model.addAttribute("username",name);
        model.addAttribute("resultproducts",productService.getsports());
        return "show_results";
    }
    @GetMapping("/viewappliances")
    public String prod_appliances(@RequestParam("name") String name, Model model)
    {
        model.addAttribute("username",name);
        model.addAttribute("resultproducts",productService.getapplicance());
        return "show_results";
    }

    @GetMapping("/viewgadgets")
    public String prod_gadgets(@RequestParam("name") String name,Model model)
    {
        model.addAttribute("username",name);
        model.addAttribute("resultproducts",productService.getgadgets());
        return "show_results";
    }

}
