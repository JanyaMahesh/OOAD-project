package com.mvcjava.loginapp.repository;

import com.mvcjava.loginapp.product.Product;
import com.mvcjava.loginapp.roles.Users.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer>
{
    List<Product> findAllByCategory(String category);
}
