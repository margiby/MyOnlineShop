package de.kaufeDoch.services;

import de.kaufeDoch.models.Customer;
import de.kaufeDoch.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    // Kundendaten aktualisieren
    public void updateCustomerAddress(Customer customer, String newAddress, String newPostalCode, String newCity) {
        customer.setStreetAddress(newAddress);
        customer.setPostalCode(newPostalCode);
        customer.setCity(newCity);
    }

    public void updateCustomerName(Customer customer, String newName) {
        customer.setName(newName);
    }

    public void updateCustomerEmail(Customer customer, String newEmail) {
        customer.setEmail(newEmail);

    }


    // Sucht nach einem Kunden basierend auf der ID

    public Optional<Customer> searchCustomerById(int customerId) {
        return customers.stream()
                .filter(customer -> customer.getCustomerId() == customerId)
                .findFirst();
    }


}
