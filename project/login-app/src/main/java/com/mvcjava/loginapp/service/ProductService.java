package com.mvcjava.loginapp.service;

import com.mvcjava.loginapp.product.Product;
import com.mvcjava.loginapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static org.springframework.util.StringUtils.*;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;

//    public Product storeproduct(String name, String category, String description, Integer price)
//    {
//        System.out.println("name "+ name+" cat "+category+" desc "+description+"  price "+price);
//        if (name == null || category == null || description == null || price == null)
//        {
//            System.out.println("something is null!!!!");
//            return null;
//        }
//        else
//        {
//            Product product = new Product();
//            product.setName(name);
//            product.setCategory(category);
//            product.setDescription(description);
//            product.setPrice(price);
//            return productRepository.save(product);
//        }
//    }
//
    public List<Product> getAllproducts()
    {
        return productRepository.findAll();
    }

    public void storeproduct(MultipartFile file,String name,String category,String description,Integer price)
    {
        Product product = new Product();
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if(filename.contains(".."))
        {
            System.out.println("not valid file");
        }
        try
        {
            product.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        product.setName(name);
        product.setCategory(category);
        product.setDescription(description);
        product.setPrice(price);

        productRepository.save(product);

    }

    public List<Product> getgadgets()
    {
        return productRepository.findAllByCategory("gadgets");
    }
}
