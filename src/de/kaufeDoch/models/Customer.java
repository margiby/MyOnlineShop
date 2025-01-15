package de.kaufeDoch.models;

import java.util.ArrayList;
import java.util.List;
/*
// Die Customer Klasse repräsentiert einen Kunden mit Namen, E-Mail, Adresse und einer Liste von Bestellungen
 */
public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String streetAddress;
    private String postalCode;
    private String city;
    private List<Order> orders = new ArrayList<>(); // Initialisiert die leere Liste der Bestellungen

    // Konstruktor
    public Customer(int customerId, String name, String email, String streetAddress, String postalCode, String city) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
    }

    // Getter und Setter
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }


    // Fügt eine Bestellung zur Liste der Bestellungen hinzu
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Überschreibt die toString Methode
    @Override
    public String toString() {
        return "Kunde {" +
                "Kundennummer=" + customerId +
                ", Name='" + name + '\'' +
                ", Email='" + email + '\'' +
                ", Adresse='" + streetAddress + ", " + postalCode + " " + city + '\'' +
                ", Bestellungen=" + getOrdersSummary() +
                '}';
    }

    // Hilfsmethode, um eine kurze Zusammenfassung der Bestellungen zu erstellen
    private String getOrdersSummary() {
        StringBuilder summary = new StringBuilder("[");
        for (Order order : orders) {
            summary.append("Bestellung ID: ").append(order.getOrderId()).append(", ");
        }
        if (!orders.isEmpty()) {
            summary.setLength(summary.length() - 2); // Letztes Komma entfernen
        }
        summary.append("]");
        return summary.toString();
    }
}
