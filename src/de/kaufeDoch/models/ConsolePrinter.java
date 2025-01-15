package de.kaufeDoch.models;

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
                System.out.printf("\t- %s (ID: %d, Preis: %.2f€, Lagerbestand: %d Stück)\n",
                    product.getName(),
                    product.getProductId(),
                    product.getPrice(),
                    product.getStock()));
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
}