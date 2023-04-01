package edu.iu.c322.trackingservice.repository;

import edu.iu.c322.trackingservice.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrackingRepository {

    //crud
    //create
    //update
    //delete

    private List<Invoice> invoices = new ArrayList<>();

    public Tracking findByOrder(int orderId, int itemId){
        Invoice x = getOrderById(orderId);
        String status = "";
        int count =0;
        if(x != null && itemId < 10){
            List<InvoiceItem> invoiceItems = x.getInvoiceItem();
            for (InvoiceItem m: invoiceItems){
                 status = m.getStatus();
                 count++;
            }
            Tracking track = new Tracking();
            track.setStatus(status);
            track.setDate("3/28/2023");

            return track;
        }else{
            throw new IllegalStateException("order item with this id does not exist in the system");
        }

    }

    public int create(Invoice invoice){
        int id = invoices.size() + 1;
        invoice.setOrderId(id);
        List<InvoiceItem> invoiceItems = invoice.getInvoiceItem();
        double orderTotal = 0;
        int itemCounter = 0;
        for (InvoiceItem x: invoiceItems){
            List<Item> items = x.getItems();
            for (Item p: items){
                double quantity = p.getQuantity();
                double price = p.getPrice();
                double total = quantity * price;
                orderTotal += total;

                itemCounter++;
                p.setItemId(itemCounter);
            }
            x.setAddress(x.getAddress());
        }



        invoice.setTotal(orderTotal);


        Payment pay = invoice.getPayment();
        BillingAddress billingAddress = pay.getBillingAddress();
        pay.setBillingAddress(billingAddress);

        invoices.add(invoice);
        return id;
    }



    public void update(StatusUpdate stats, int orderId){

        String status = stats.getStatus();
        int itemId = stats.getItemId();
        Invoice x = getOrderById(orderId);

        if(x != null){
            List<InvoiceItem> itemss = x.getInvoiceItem();
            for (InvoiceItem m: itemss){
                m.setStatus(status);
            }
        }else{
            throw new IllegalStateException("order id is not valid.");
        }


    }



    private Invoice getOrderById(int id){
        return invoices.stream().filter(x -> x.getOrderId() == id).findAny().orElse(null);
    }

}