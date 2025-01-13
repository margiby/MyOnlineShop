package de.kaufeDoch.models;
/*
Die Order Klasse repräsentiert eine Bestellung, die eine Liste von Produkten und einen Kunden enthält
 */

import java.util.List;

public class Order {

    private int orderId;
    private List<Product> products;
    private Customer customer;

// Konstruktor
    public Order(int orderId, List<Product> products, Customer customer) {
        this.orderId = orderId;
        this.products = products;
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

}
