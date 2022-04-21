package com.mvcjava.loginapp.repository;

import com.mvcjava.loginapp.product.Product;
import com.mvcjava.loginapp.roles.Users.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer>
{
    @Query("select p from Product p where p.name like concat('%',?1,'%')")
    public Optional<List<Product>> getProductByName(String name);
    
    List<Product> findAllByCategory(String category);
}
