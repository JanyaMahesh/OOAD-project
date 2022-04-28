package com.mvcjava.loginapp.Bill;


import javax.persistence.*;

@Table(name = "users")
@Entity
public class Bill
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer orderID;
    String username;
    Long time;
    Integer total;

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
