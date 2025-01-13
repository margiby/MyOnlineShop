package de.kaufeDoch;



import de.kaufeDoch.models.Customer;
import de.kaufeDoch.models.Order;
import de.kaufeDoch.models.Product;
import de.kaufeDoch.models.Smartphone;
import de.kaufeDoch.services.OrderService;
import de.kaufeDoch.services.ProductService;
import de.kaufeDoch.strategies.CreditCardPayment;
import de.kaufeDoch.strategies.PaymentStrategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Erstellen der Services
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        // Erstellen und Hinzufügen von Produkten
        Product smartphone1 = new Smartphone(1, "iPhone 12", 599.99, "Apple", "12", 64, true);
        Product smartphone2 = new Smartphone(2, "Samsung Galaxy S21", 499.99, "Samsung", "S21", 128, true);
        productService.addProduct(smartphone1);
        productService.addProduct(smartphone2);

        // Erstellen eines Kunden mit Adresse
        Customer customer = new Customer(1, "John Doe", "john.doe@example.com", "Musterstraße 123, 12345 Musterstadt");

        // Aufgeben einer Bestellung
        Order order = new Order(1, Arrays.asList(smartphone1, smartphone2), customer);
        orderService.addOrder(order);

        // Auswählen und Verwenden einer Zahlungsstrategie
        PaymentStrategy paymentStrategy = new CreditCardPayment();
        paymentStrategy.pay(order.getTotalAmount());

        System.out.println("Bestellung erfolgreich aufgegeben!");
    }
}

