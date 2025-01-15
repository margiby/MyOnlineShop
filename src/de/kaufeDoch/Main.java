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
        System.out.println("\n=================================================");
        System.out.println("           PRODUKTSUCHE: 'iPhone'");
        System.out.println("=================================================");
        productService.findProductsByName("iPhone").forEach(product ->
                System.out.println("Gefunden: " + product.getName() + " - Preis: " + product.getPrice() + "€"));

        // Suche nach nicht existierendem Produkt
        System.out.println("\n=================================================");
        System.out.println("   PRODUKTSUCHE: 'Pixel 6' (nicht vorhanden)");
        System.out.println("=================================================");
        productService.findProductsByName("Pixel 6").forEach(product ->
                System.out.println("Gefunden: " + product.getName() + " - Preis: " + product.getPrice() + "€"));


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

        // Lagerbestand vor Bestellung


        // Bestellung 1
        Order order1 = new Order(1, Arrays.asList(smartphone1, smartphone2), kunde1);
        orderService.addOrder(order1);

        // Bestellung 2
        Order order2 = new Order(2, List.of(smartphone3), kunde2);
        orderService.addOrder(order2);

        // Verwendung des Strategy Pattern für die Zahlungsstrategie
        PaymentContext paymentContext = new PaymentContext();

        // Setzen der Zahlungsstrategie und Zahlung per Kreditkarte
        System.out.println("\n=================================================");
        System.out.println("           BESTELLUNG UND ZAHLUNGEN");
        System.out.println("=================================================");
        paymentContext.setPaymentStrategy(new CreditCardPayment());
        System.out.println("--> Zahlung per Kreditkarte für Bestellung 1:");
        paymentContext.pay(order1.getTotalAmount());

        // Zahlung per PayPal
        paymentContext.setPaymentStrategy(new PayPalPayment());
        System.out.println("--> Zahlung per PayPal für Bestellung 2:");
        paymentContext.pay(order2.getTotalAmount());

        System.out.println("\nBestellung erfolgreich aufgegeben!");

        // Bestellungen anzeigen
        ConsolePrinter.printOrderList("ALLE BESTELLUNGEN", orderService.getAllOrders());

        // Ausgabe der aktualisierten Kundeninformationen
        System.out.println("\n=================================================");
        System.out.println("           AKTUALISIERTE KUNDENINFORMATIONEN");
        System.out.println("=================================================");
        customerService.getAllCustomers().forEach(System.out::println);


        // Preise aktualisieren mit ProductService
        productService.updateProductPrice(smartphone1, 549.0);
        productService.updateProductPrice(smartphone2, 349.0);
        productService.updateProductPrice(smartphone3, 249.0);

        System.out.println("\n=================================================");
        System.out.println("           AKTUALISIERTE PRODUKTPREISE");
        System.out.println("=================================================");
        productService.getAllProducts().forEach(product ->
                System.out.println(product.getName() + " - Neuer Preis: " + product.getPrice() + "€"));

        // Lagerbestand ändern mit ProductService
        productService.updateProductStock(smartphone1, 9);
        productService.updateProductStock(smartphone2, 4);
        productService.updateProductStock(smartphone3, 6);

        ConsolePrinter.printStockChanges(productService, "AKTUALISIERTER LAGERBESTAND");

        /*System.out.println("\n=================================================");
        System.out.println("       AKTUALISIERTER LAGERBESTAND");
        System.out.println("=================================================");
        List<Product> allProducts = productService.getAllProducts();
        for (Product product : allProducts) {
            System.out.println(product.getName() + " - Lagerbestand: " + product.getStock() + " Stück");
        }*/

        // Refurbished-Status aktualisieren
        productService.updateProductStatus(smartphone1, true);
        System.out.println("\n=================================================");
        System.out.println("      REFURBISHED-STATUS AKTUALISIEREN");
        System.out.println("=================================================");
        System.out.println(smartphone1.getName() + " - Refurbished: " + ((Smartphone) smartphone1).isRefurbished());


        // Ausgabe der aktualisierten Produktinformationen
        System.out.println("\n=================================================");
        System.out.println("         AKTUALISIERTE PRODUKTINFORMATIONEN");
        System.out.println("=================================================");
        System.out.println(smartphone1);
        System.out.println(smartphone2);
        System.out.println(smartphone3);


        // Entfernen eines Produkts

        System.out.println("\n=================================================");
        System.out.println("                 ENTFERNUNG EINES PRODUKTS");
        System.out.println("=================================================");
        int productIdToRemove = 2;
        if (productService.removeProductById(productIdToRemove)) {
            System.out.println("\nProdukt mit ID " + productIdToRemove + " wurde erfolgreich entfernt.");
        } else {
            System.out.println("\nProdukt mit ID " + productIdToRemove + " wurde nicht gefunden und konnte nicht entfernt werden.");
        }

        // Produktliste nach Entfernung anzeigen
        System.out.println("\n=================================================");
        System.out.println("    AKTUALISIERTE PRODUKTLISTE NACH ENTFERNUNG");
        System.out.println("=================================================");
        productService.getAllProducts().forEach(System.out::println);


    }
}


