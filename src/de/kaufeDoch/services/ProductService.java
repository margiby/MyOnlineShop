package de.kaufeDoch.services;

import de.kaufeDoch.models.Product;
import de.kaufeDoch.models.Smartphone;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    Der ProductService Klasse verwaltet die Liste der Produkte im Shop.
 */

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);   // Fügt ein Produkt zur Liste hinzu
    }

    // Logik zum Entfernen des Produkts aus der Liste
    public void removeProduct(Product product) {
    }

    public List<Product> getAllProducts() {
        return products; // Alle Produkte anzeigen
    }

    // Methode zum Ändern des Preises eines Produkts
    public void updateProductPrice(Product product, double newPrice) {
        product.setPrice(newPrice);
    }

    //Lagerbestand aktualisieren
    public void updateProductStock(Product product, int newStock) {
        product.setStock(newStock);
    }

    // Produkt nach ID suchen
    public Optional<Product> findProductById(int productId) {
        return products.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst();
    }

    // Produkt nach Namen suchen (teilweise Übereinstimmung)
    public List<Product> findProductsByName(String keyword) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

}

