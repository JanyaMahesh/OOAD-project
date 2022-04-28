package com.mvcjava.loginapp.service;

import com.mvcjava.loginapp.Bill.Bill;
import com.mvcjava.loginapp.Cart.Cart;
import com.mvcjava.loginapp.product.LineItem;
import com.mvcjava.loginapp.product.Product;
import com.mvcjava.loginapp.repository.BillRepository;
import com.mvcjava.loginapp.repository.ProductRepository;
import com.mvcjava.loginapp.roles.Users.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService
{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    BillRepository billRepository;

     public LineItem check_item(String item, List<LineItem> basket)
     {
         for (int i = 0; i < basket.size(); i++)
         {
             if(basket.get(i).getItemname().toLowerCase().equals(item))
             {
                 return basket.get(i);
             }
         }
         return null;
     }

     @Transactional
    public void add_prod_basket(String customer,String itemname,int quantity,Cart cart)
    {
        Product product = productRepository.findByName(itemname);
        LineItem lineItem = check_item(itemname,cart.getBasket());
        List<LineItem> basket = cart.getBasket();
        if(lineItem != null)
        {
            int oldqty = lineItem.getQty();
            lineItem.setQty(oldqty+quantity);
            lineItem.setCost(lineItem.getCost()+lineItem.getPrice()*quantity);
        }
        else
        {
            LineItem newitem = new LineItem();
            newitem.setItemname(itemname);
            newitem.setQty(quantity);
            newitem.setPrice(product.getPrice());
            newitem.setCost(product.getPrice()*quantity);
            newitem.setImage(product.getImage());
            basket.add(newitem);
        }

        for (int i = 0;i<basket.size();i++)
        {
            System.out.println("--> "+basket.get(i).getItemname()+" "+basket.get(i).getQty());
        }

    }

    public void remove_prod_basket(String item,List<LineItem> basket)
    {
        for (int i = 0; i < basket.size(); i++)
        {
            if(basket.get(i).getItemname().toLowerCase().equals(item))
            {
                basket.remove(basket.get(i));
            }
        }
    }

    public Integer gettotal(Cart cart)
    {
            Integer total= 0;
            List<LineItem> basket = cart.getBasket();

            for (int i = 0; i < basket.size(); i++)
            {
                total += basket.get(i).getPrice()*basket.get(i).getQty();
            }
            System.out.println("the total is = "+total);
            return total;
    }

    public Bill savebill(String username, Long date_time, Integer total)
    {
        if (username == null || date_time == null || total == null)
        {
            System.out.println("something is null in BILL!!!!");
            return null;
        }
        else
        {
            Bill bill = new Bill();
            bill.setTime(date_time);
            bill.setUsername(username);
            bill.setTotal(total);
            return billRepository.save(bill);

        }
    }
}
