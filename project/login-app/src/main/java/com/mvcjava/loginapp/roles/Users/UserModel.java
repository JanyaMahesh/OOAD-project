package com.mvcjava.loginapp.roles.Users;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "users")
@Entity

public class UserModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String login;
    String password;
    String mailid;
    String role;

    @Transient
    @JsonProperty
    private boolean hascart = false;

    public boolean isHascart()
    {
        return hascart;
    }

    public void setHascart()
    {
        this.hascart = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
        System.out.println("set mailid = "+this.mailid);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
        System.out.println("set role = "+this.role);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", mailid='" + mailid + '\'' +
                ", role='" + role + '\'' +
                '}';
    }


        @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) && Objects.equals(login, userModel.login) && Objects.equals(password, userModel.password) && Objects.equals(mailid, userModel.mailid) && Objects.equals(role, userModel.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, mailid, role);
    }


}
