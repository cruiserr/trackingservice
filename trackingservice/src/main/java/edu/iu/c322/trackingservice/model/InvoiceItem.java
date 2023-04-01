package edu.iu.c322.trackingservice.model;

import java.util.List;

public class InvoiceItem {
    private String status;
    private List<Item> items;
    private String on;
    private Shipping address;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getOn() {
        return on;
    }

    public void setOn(String on) {
        this.on = on;
    }

    public Shipping getAddress() {
        return address;
    }

    public void setAddress(Shipping address) {
        this.address = address;
    }
}
