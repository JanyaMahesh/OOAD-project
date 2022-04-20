package com.mvcjava.loginapp.repository;

import com.mvcjava.loginapp.roles.Users.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RetailerRepository extends JpaRepository<UserModel,Integer>
{
    List<UserModel> findAllByRole(String role);
}
