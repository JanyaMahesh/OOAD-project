package com.mvcjava.loginapp.product;

import javax.persistence.Column;
import javax.persistence.Lob;

public class LineItem
{
    String itemname;
    Integer qty;
    Integer price;
    Integer cost = 0;

    @Lob
    @Column(columnDefinition = "BIGINT")
    private String image;

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
