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


//    public String postaddproduct(@ModelAttribute Product product)
//    {
//        System.out.println("product request: "+product);
//        Product newproduct = productService.storeproduct(product.getName(),product.getCategory(),product.getDescription(),product.getPrice());
//        return newproduct == null?"error":"redirect:/retailer";
//    }
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

    @GetMapping("/viewgadgets")
    public String prod_gadgets(Model model)
    {
        model.addAttribute("resultproducts",productService.getgadgets());
        return "show_results";
    }

}
