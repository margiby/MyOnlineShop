package de.kaufeDoch.models;

import java.util.ArrayList;
import java.util.List;


/*
// Die Customer Klasse repräsentiert einen Kunden mit Namen, E-Mail, Adresse und einer Liste von Bestellungen
 */
public class Customer {
    private int id;
    private String name;
    private String email;
    private String address;
    private List<Order> orders;

    // Konstruktor
    public Customer(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.orders = new ArrayList<>(); // Initialisiert die leere Liste der Bestellungen
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
    public String getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Setter-Methode, um die Adresse des Kunden zu aktualisieren
    public void setAddress(String address) {
        this.address = address;
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
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}
