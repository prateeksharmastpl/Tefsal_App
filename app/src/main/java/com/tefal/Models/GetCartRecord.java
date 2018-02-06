package com.tefal.Models;

import java.io.Serializable;

/**
 * Created by Hp on 01-11-2017.
 */

public class GetCartRecord implements Serializable {

    private boolean isDelete;

    private String total_amount;

    private String cart_item_id;

    private String product_id;

    private String item_quantity;

    private String store_image;

    private String dishdasha_pattern;

    private String brand_name;

    private String dishdasha_feel;

    private String brand_image;

    private String price;

    private String pattern_image;

    private String item_id;

    private String color_image;

    private String dishdasha_material;

    private String store_name;

    private String item_type;

    private String product_name;

    private String image;



    private boolean isChecked;



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getTotal_amount ()
    {
        return total_amount;
    }

    public void setTotal_amount (String total_amount)
    {
        this.total_amount = total_amount;
    }

    public String getCart_item_id ()
    {
        return cart_item_id;
    }

    public void setCart_item_id (String cart_item_id)
    {
        this.cart_item_id = cart_item_id;
    }

    public String getProduct_id ()
    {
        return product_id;
    }

    public void setProduct_id (String product_id)
    {
        this.product_id = product_id;
    }

    public String getItem_quantity ()
    {
        return item_quantity;
    }

    public void setItem_quantity (String item_quantity)
    {
        this.item_quantity = item_quantity;
    }

    public String getStore_image ()
    {
        return store_image;
    }

    public void setStore_image (String store_image)
    {
        this.store_image = store_image;
    }

    public String getDishdasha_pattern ()
    {
        return dishdasha_pattern;
    }

    public void setDishdasha_pattern (String dishdasha_pattern)
    {
        this.dishdasha_pattern = dishdasha_pattern;
    }

    public String getBrand_name ()
    {
        return brand_name;
    }

    public void setBrand_name (String brand_name)
    {
        this.brand_name = brand_name;
    }

    public String getDishdasha_feel ()
    {
        return dishdasha_feel;
    }

    public void setDishdasha_feel (String dishdasha_feel)
    {
        this.dishdasha_feel = dishdasha_feel;
    }

    public String getBrand_image ()
    {
        return brand_image;
    }

    public void setBrand_image (String brand_image)
    {
        this.brand_image = brand_image;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getPattern_image ()
    {
        return pattern_image;
    }

    public void setPattern_image (String pattern_image)
    {
        this.pattern_image = pattern_image;
    }

    public String getItem_id ()
    {
        return item_id;
    }

    public void setItem_id (String item_id)
    {
        this.item_id = item_id;
    }

    public String getColor_image ()
    {
        return color_image;
    }

    public void setColor_image (String color_image)
    {
        this.color_image = color_image;
    }

    public String getDishdasha_material ()
    {
        return dishdasha_material;
    }

    public void setDishdasha_material (String dishdasha_material)
    {
        this.dishdasha_material = dishdasha_material;
    }

    public String getStore_name ()
    {
        return store_name;
    }

    public void setStore_name (String store_name)
    {
        this.store_name = store_name;
    }

    public String getItem_type ()
    {
        return item_type;
    }

    public void setItem_type (String item_type)
    {
        this.item_type = item_type;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
    @Override
    public String toString()
    {
        return "ClassPojo [isDelete"+isDelete+"total_amount = "+total_amount+", cart_item_id = "+cart_item_id+", product_id = "+product_id+", item_quantity = "+item_quantity+", store_image = "+store_image+", dishdasha_pattern = "+dishdasha_pattern+", brand_name = "+brand_name+", dishdasha_feel = "+dishdasha_feel+", brand_image = "+brand_image+", price = "+price+", pattern_image = "+pattern_image+", item_id = "+item_id+", color_image = "+color_image+", dishdasha_material = "+dishdasha_material+", store_name = "+store_name+", item_type = "+item_type+",product_name = "+product_name+", image = "+image+",isChecked="+isChecked+"]";
    }
}

