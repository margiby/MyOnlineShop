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
        Product smartphone1 = new Smartphone(1, "Apple", "iPhone 14 Pro", 699.0, 10, false);
        Product smartphone2 = new Smartphone(2, "Apple", "iPhone 15", 599.0, 5, true);
        Product smartphone3 = new Smartphone(3, "Samsung", "Galaxy S20", 799.0, 7, true);

        // Produkte hinzufügen
        productService.addProduct(smartphone1);
        productService.addProduct(smartphone2);
        productService.addProduct(smartphone3);

        // Produkte anzeigen
        ConsolePrinter.printProductList("PRODUKTLISTE", productService.getAllProducts());

        // Suche nach Produkten mit Teilbegriffen
        ConsolePrinter.printProductSearch("iPhone", productService.findProductsByName("iPhone"));

        // Suche nach nicht existierendem Produkt
        ConsolePrinter.printProductSearch("Pixel 6", productService.findProductsByName("Pixel 6"));

        // Kunden anlegen
        Customer kunde1 = new Customer(1, "Max Mustermann", "max.mustermann@gmail.com",
                "Musterstraße 12", "12345", "Berlin");
        Customer kunde2 = new Customer(2, "Anna Müller", "anna.mueller@gmail.com",
                "Bahnhofstraße 8", "54321", "München");

        // Kunden hinzufügen
        customerService.addCustomer(kunde1);
        customerService.addCustomer(kunde2);

        // Kundeninformationen anzeigen
        ConsolePrinter.printCustomerInfo("KUNDENINFORMATIONEN", customerService.getAllCustomers());


        // Kundendaten aktualisieren
        customerService.updateCustomerEmail(kunde1, "max.neuemustermann@gmail.com");
        customerService.updateCustomerAddress(kunde1,"Neue Musterstraße 34", "07896", "Berlin");
        customerService.updateCustomerName(kunde2, "Anna Schmidt");


        // Bestellung 1
        Order order1 = new Order(1, Arrays.asList(smartphone1, smartphone2), kunde1);
        orderService.addOrder(order1);

        // Bestellung 2
        Order order2 = new Order(2, List.of(smartphone3), kunde2);
        orderService.addOrder(order2);

        // Verwendung des Strategy Pattern für die Zahlungsstrategie
        PaymentContext paymentContext = new PaymentContext();

        // Setzen der Zahlungsstrategie und Zahlung per Kreditkarte
        paymentContext.setPaymentStrategy(new CreditCardPayment());
        ConsolePrinter.printPayment("Kreditkarte", order1.getTotalAmount());
        System.out.println("\nBestellung erfolgreich aufgegeben!");

        // Zahlung per PayPal
        paymentContext.setPaymentStrategy(new PayPalPayment());
        ConsolePrinter.printPayment("PayPal", order2.getTotalAmount());
        System.out.println("\nBestellung erfolgreich aufgegeben!");

        // Bestellungen anzeigen
        ConsolePrinter.printOrderList("ALLE BESTELLUNGEN", orderService.getAllOrders());

        // Ausgabe der aktualisierten Kundeninformationen
        ConsolePrinter.printCustomerInfo("AKTUALISIERTE KUNDENINFORMATIONEN", customerService.getAllCustomers());


        // Preise aktualisieren mit ProductService
        productService.updateProductPrice(smartphone1, 549.0);
        productService.updateProductPrice(smartphone2, 349.0);
        productService.updateProductPrice(smartphone3, 249.0);

        // Aktualisierte Preise anzeigen
        ConsolePrinter.printUpdatedPrices("AKTUALISIERTE PRODUKTPREISE", productService.getAllProducts());

        // Lagerbestand ändern mit ProductService
        productService.updateProductStock(smartphone1, 9);
        productService.updateProductStock(smartphone2, 4);
        productService.updateProductStock(smartphone3, 6);

        ConsolePrinter.printStockChanges(productService, "AKTUALISIERTER LAGERBESTAND");


        // Refurbished-Status aktualisieren
        productService.updateProductStatus(smartphone1, true);
        ConsolePrinter.printRefurbishedStatus(smartphone1);

        // Ausgabe der aktualisierten Produktinformationen
        ConsolePrinter.printUpdatedProductInfo("AKTUALISIERTE PRODUKTINFORMATIONEN", productService.getAllProducts());

        // Entfernen eines Produkts
        int productIdToRemove = 2;
        boolean removalSuccess = productService.removeProductById(productIdToRemove);
        ConsolePrinter.printProductRemoval(productIdToRemove, removalSuccess);

        // Aktualisierte Produktliste nach Entfernung
        ConsolePrinter.printProductList("AKTUALISIERTE PRODUKTLISTE NACH ENTFERNUNG", productService.getAllProducts());

    }
}


