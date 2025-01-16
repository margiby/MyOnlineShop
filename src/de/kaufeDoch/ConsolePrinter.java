package de.kaufeDoch;

import de.kaufeDoch.models.Customer;
import de.kaufeDoch.models.Order;
import de.kaufeDoch.models.Product;
import de.kaufeDoch.models.Smartphone;
import de.kaufeDoch.services.ProductService;

import java.util.List;

public class ConsolePrinter {



    // Produkte ausgeben
    public static void printProductList(String title, List<Product> products) {
        System.out.println("\n=================================================");
        System.out.println(title);
        System.out.println("=================================================");
        products.forEach(product -> System.out.printf("ID: %d | Name: %s | Preis: %.2f€ | Lagerbestand: %d Stück%s\n",
                product.getProductId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product instanceof Smartphone && ((Smartphone) product).isRefurbished() ? " (Refurbished)" : ""));
    }

    // Kundenliste ausgeben
    public static void printCustomerInfo(String title, List<Customer> customers) {
        System.out.println("\n=================================================");
        System.out.println(title);
        System.out.println("=================================================");
        customers.forEach(customer -> System.out.printf("ID: %d | Name: %s | E-Mail: %s | Adresse: %s, %s %s\n",
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail(),
                customer.getStreetAddress(),
                customer.getPostalCode(),
                customer.getCity()));
    }

    // Zahlung anzeigen
    public static void printPayment(String paymentMethod, double amount) {
        System.out.println("\n=================================================");
        System.out.printf("           ZAHLUNG (%s)%n", paymentMethod);
        System.out.println("=================================================");
        System.out.printf("Betrag: %.2f€ wurde erfolgreich bezahlt.%n", amount);
    }


    // Bestellungen ausgeben
    public static void printOrderList(String title, List<Order> orders) {
        System.out.println("\n=================================================");
        System.out.println(title);
        System.out.println("=================================================");
        orders.forEach(order -> {
            System.out.printf("Bestell-ID: %d | Kunde: %s | Gesamtbetrag: %.2f€\n", 
                order.getOrderId(),
                order.getCustomer().getName(), 
                order.getTotalAmount());
            System.out.println("Bestellte Produkte:");
            order.getProducts().forEach(product ->
                System.out.printf("\t- %s (ID: %d, Preis: %.2f€)\n",
                    product.getName(),
                    product.getProductId(),
                    product.getPrice()));
            System.out.println("--------------------------------------------");
        });
    }

    // Lagerbestand ausgeben
    public static void printStockChanges(ProductService productService, String title) {
        System.out.println("\n=================================================");
        System.out.println(title);
        System.out.println("=================================================");
        productService.getAllProducts().forEach(product ->
                System.out.printf("%s - Lagerbestand: %d Stück\n",
                        product.getName(),
                        product.getStock()));
    }
        //War ein Versuch um Fehler zu finden
      /*  System.out.println("DEBUG: Aufruf von printStockChanges gestartet.");
        productService.getAllProducts().forEach(product ->
                System.out.printf("%s - Lagerbestand: %d Stück\n",
                        product.getName(),
                        product.getStock()));
        System.out.println("DEBUG: Aufruf von printStockChanges beendet.");*/


// Produktsuche anzeigen
public static void printProductSearch(String searchTerm, List<Product> products) {
    System.out.println("\n=================================================");
    System.out.printf("           PRODUKTSUCHE: '%s'%n", searchTerm);
    System.out.println("=================================================");
    if (products.isEmpty()) {
        System.out.println("Keine Produkte gefunden.");
    } else {
        products.forEach(product ->
                System.out.printf("Gefunden: %s - Preis: %.2f€%n", product.getName(), product.getPrice()));
    }
}
// Produktpreise aktualisieren
    public static void printUpdatedPrices (String title, List < Product > products){
        System.out.println("\n=================================================");
        System.out.println(title);
        System.out.println("=================================================");
        products.forEach(product ->
                System.out.printf("%s - Neuer Preis: %.2f€%n", product.getName(), product.getPrice()));
    }


// Produktentfernung anzeigen
    public static void printProductRemoval (int productId, boolean success){
        System.out.println("\n=================================================");
        System.out.println("                 ENTFERNUNG EINES PRODUKTS");
        System.out.println("=================================================");
        if (success) {
            System.out.printf("Produkt mit ID %d wurde erfolgreich entfernt.%n", productId);
        } else {
            System.out.printf("Produkt mit ID %d wurde nicht gefunden und konnte nicht entfernt werden.%n", productId);
        }
    }

    // Refurbished-Status anzeigen
    public static void printRefurbishedStatus(Product product) {
        System.out.println("\n=================================================");
        System.out.println("      REFURBISHED-STATUS AKTUALISIEREN");
        System.out.println("=================================================");
        System.out.printf("ID: %d - Refurbished: %s%n", product.getProductId(),
                product instanceof Smartphone && ((Smartphone) product).isRefurbished() ? "Ja" : "Nein");
    }

    // Aktualisierte Produktinformationen anzeigen
    public static void printUpdatedProductInfo(String title, List<Product> products) {
        System.out.println("\n=================================================");
        System.out.println(title);
        System.out.println("=================================================");
        products.forEach(System.out::println);
    }



}