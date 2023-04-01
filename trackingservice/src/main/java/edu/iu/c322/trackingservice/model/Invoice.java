package edu.iu.c322.trackingservice.model;

import java.util.List;
import java.util.Objects;

public class Invoice {
    private String orderPlaced;
    private int orderId;
    private double total;
    private List<InvoiceItem> invoiceItem;
    private Payment payment;



    public String getOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(String orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<InvoiceItem> getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(List<InvoiceItem> invoiceItem) {
        this.invoiceItem = invoiceItem;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(invoice.total, total) == 0 && orderPlaced.equals(invoice.orderPlaced) && invoiceItem.equals(invoice.invoiceItem) && payment.equals(invoice.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderPlaced, total, invoiceItem, payment);
    }
}