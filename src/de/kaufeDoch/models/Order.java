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

        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Die Produktliste darf nicht leer sein.");
        }
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

    // Setzt die Liste der Produkte in der Bestellung
    public void setProducts(List<Product> products) {
        this.products = products;
    }


    /* Berechnen und geben den Gesamtbetrag der Bestellung zurück

    return products.stream() // Wandelt die Liste der Produkte in einen Stream um
          .mapToDouble(Product::getPrice) // Wendet die Methode getPrice auf jedes Produkt an, um einen Stream von Preisen zu erhalten
            .sum(); // Summiert alle Preise und gibt die Gesamtsumme zurück
     */
    public double getTotalAmount() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    // Überschreibt die toString Methode, um eine String-Darstellung der Bestellung zu geben
    @Override

    public String toString() {
        return "Order{" +
                "orderId=" + orderId + ", " +
                "products=" + products + ", " +
                "customer=" + (customer != null ? customer.getName() : "Unknown") + ", " +
                "totalAmount=" + getTotalAmount() +
                '}';
    }

}

