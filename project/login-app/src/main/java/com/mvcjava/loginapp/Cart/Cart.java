package com.mvcjava.loginapp.Cart;

import com.mvcjava.loginapp.product.LineItem;
import com.mvcjava.loginapp.product.Product;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class Cart
{
//    private HashMap<LineItem,Integer> basket;
    private List<LineItem> basket;

    public Cart()
    {
        this.basket = new ArrayList<>();
    }

    public List<LineItem> getBasket()
    {
        if(basket == null)
        {
            System.out.println("basket is null");
        }
        return basket;
    }
}
