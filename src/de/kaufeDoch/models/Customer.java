package de.kaufeDoch.models;

import java.util.ArrayList;
import java.util.List;


/*
// Die Customer Klasse repräsentiert einen Kunden mit Namen, E-Mail und einer Liste von Bestellungen
 */
public class Customer {
    private int id;
    private String name;
    private String email;
    private List<Order> orders;

    // Konstruktor
    public Customer(int id, String name, String email, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Fügt eine Bestellung zur Liste der Bestellungen hinzu
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Überschreibt die toString Methode
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders +
                '}';
    }
}
