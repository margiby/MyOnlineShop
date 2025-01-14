package de.kaufeDoch;

import de.kaufeDoch.models.*;
import de.kaufeDoch.services.*;
import de.kaufeDoch.strategies.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Services erstellen
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        CustomerService customerService = new CustomerService(orderService);

        // Produkte erstellen
        Product smartphone1 = new Smartphone(1, "Apple", "iPhone 12", 699.0, 10, false);
        Product smartphone2 = new Smartphone(2, "Apple", "iPhone 12 Refurbished", 599.0, 5, true);
        Product smartphone3 = new Smartphone(3, "Samsung", "Galaxy S20", 799.0, 7, true);

        // Produkte hinzufügen
        productService.addProduct(smartphone1);
        productService.addProduct(smartphone2);
        productService.addProduct(smartphone3);

        // Kunden anlegen
        Customer kunde1 = new Customer(1, "Max Mustermann", "max.mustermann@gmail.com",
                "Musterstraße 12", "12345", "Berlin");
        Customer kunde2 = new Customer(2, "Anna Müller", "anna.mueller@gmail.com",
                "Bahnhofstraße 8", "54321", "München");

        // Kunden hinzufügen
        customerService.addCustomer(kunde1);
        customerService.addCustomer(kunde2);

        // Aufgeben einer Bestellung
        Order order1 = new Order(1, Arrays.asList(smartphone1, smartphone2), kunde1);
        orderService.addOrder(order1);
        Order order2 = new Order(2, List.of(smartphone3), kunde2);
        orderService.addOrder(order2);

        // Verwendung des Strategy Pattern für die Zahlungsstrategie
        PaymentContext paymentContext = new PaymentContext();

        // Setzen der Zahlungsstrategie auf Kreditkarte
        paymentContext.setPaymentStrategy(new CreditCardPayment());
        paymentContext.pay(order1.getTotalAmount());

        // Setzen der Zahlungsstrategie auf PayPal
        paymentContext.setPaymentStrategy(new PayPalPayment());
        paymentContext.pay(order2.getTotalAmount());

        System.out.println("\nBestellung erfolgreich aufgegeben!\n");


        // Suche nach Produkten mit Teilbegriffen
        System.out.println("\nProdukte mit 'iPhone' im Namen:");
        productService.findProductsByName("iPhone").forEach(product ->
                System.out.println("\nGefundenes Produkt: " + product.getName() + " - Preis: " + product.getPrice() + "€"));

        // Suche nach einem nicht existierenden Produkt
        System.out.println("\nProdukte mit dem Namen 'Pixel 6':");
        productService.findProductsByName("Pixel 6").forEach(product ->
                System.out.println("\nGefundenes Produkt: " + product.getName() + " - Preis: " + product.getPrice() + "€"));

    }
}


