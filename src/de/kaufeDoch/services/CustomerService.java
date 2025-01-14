package de.kaufeDoch.services;

import de.kaufeDoch.models.Customer;
import de.kaufeDoch.models.Order;

import java.util.ArrayList;
import java.util.List;

// Der CustomerService verwaltet die Liste der Kunden im Shop

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    private OrderService orderService;

    public CustomerService(OrderService orderService) {
        this.orderService = orderService; // Verknüpfung mit OrderService
    }

    // Fügt einen Kunden zur Liste hinzu
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Gibt die Liste aller Kunden zurück
    public List<Customer> getAllCustomers() {
        return customers;
    }

    // Methode: Alle Bestellungen eines bestimmten Kunden zurückgeben
    public List<Order> getOrdersForCustomer(int customerId) {
        return orderService.getOrdersByCustomer(customerId);
    }


    // Aktualisiert die Adresse eines Kunden
    public void updateCustomer(Customer customer, String newName, String newAddress, String newPostalCode, String newCity) {
        customer.setName(newName);
        customer.setStreetAddress(newAddress);
        customer.setPostalCode(newPostalCode);
        customer.setCity(newCity);
    }


    // Sucht nach einem Kunden basierend auf der ID
    public Customer searchCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null; // Rückgabe null, falls kein Kunde gefunden wird
    }
}
