package edu.iu.c322.trackingservice.model;

import jakarta.validation.constraints.NotEmpty;

public class Item {

    private int itemId;
    @NotEmpty(message = "name cannot be empty.")
    private String item;
    private int quantity, price;


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String name) {
        this.item = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}