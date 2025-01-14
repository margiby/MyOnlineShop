package de.kaufeDoch.services;

import de.kaufeDoch.models.Order;

import java.util.ArrayList;
import java.util.List;

// Der OrderService verwaltet die Liste der Bestellungen im Shop

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order); // Fügt eine Bestellung zur Liste hinzu
    }

    public List<Order> getAllOrders() {
        return orders;  // Gibt die Liste aller Bestellungen zurück
    }


/*        // Aktualisiert die Details einer Bestellung
        public void updateOrder(int orderId, List<Product> products) {
            for (Order order : orders) {
                if (order.getOrderId() == orderId) {
                    order.setProducts(products); // Setzt neue Produkte für die Bestellung

                }
            }
        }

        // Sucht nach einer Bestellung basierend auf der Bestell-ID
        public Order searchOrderById(int orderId) {
            for (Order order : orders) {
                if (order.getOrderId() == orderId) {
                    return order;
                }
            }
            return null; // Rückgabe null, falls keine Bestellung gefunden wird
        }
    }*/



}
