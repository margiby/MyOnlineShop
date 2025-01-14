package de.kaufeDoch.services;

import de.kaufeDoch.models.Order;
import de.kaufeDoch.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {

    // Zentrale Verwaltung der Bestellungen
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order); // Bestellung zur zentralen Liste hinzufügen
        // Bestellung dem Kunden zuordnen
        order.getCustomer().addOrder(order);
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    //Die Bestellung automatisch dem entsprechenden Kunden zugewiesen wird.
    public List<Order> getOrdersByCustomer(int customerId) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomer().getCustomerId() == customerId) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    // Aktualisierung
    public void updateOrder(int orderId, List<Product> products) {
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Die aktualisierte Produktliste darf nicht leer sein.");
        }
        searchOrderById(orderId)
                .ifPresent(order -> {
                    order.setProducts(products);  // Aktualisiere nur die Produkte
                    // Für Zukunft: Hier könnten weitere Aktualisierungen erfolgen
                });
    }


    // Sucht nach einer Bestellung basierend auf der Bestell-ID und gibt ein Optional zurück
    public Optional<Order> searchOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return Optional.of(order); // Wrappe die gefundene Bestellung in ein Optional
            }
        }
        return Optional.empty(); // Gibt ein leeres Optional zurück, wenn keine Bestellung gefunden wird
    }
}




