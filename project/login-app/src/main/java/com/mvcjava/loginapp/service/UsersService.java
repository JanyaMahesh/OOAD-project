package com.mvcjava.loginapp.service;

import com.mvcjava.loginapp.roles.Users.UserModel;
import com.mvcjava.loginapp.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService
{

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository)
    {
        this.usersRepository = usersRepository;
    }

    public UserModel registerUser(String login,String password,String email,String role)
    {
        System.out.println("setting values "+login+" "+password+" "+email+" "+role);
        if (login == null || password == null)
        {
            System.out.println("something is null!!!!");
            System.out.println("login = "+login+"password = "+password);
            return null;
        }
        else
        {
            UserModel userModel = new UserModel();
            userModel.setLogin(login);
            userModel.setPassword(password);
            userModel.setMailid(email);
            userModel.setRole(role);
            return usersRepository.save(userModel);
        }
    }
    public UserModel authentication(String login,String password)
    {
        return usersRepository.findByLoginAndPassword(login,password).orElse(null);
    }
}
