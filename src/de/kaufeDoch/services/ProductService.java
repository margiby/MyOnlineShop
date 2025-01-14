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

    public List<Product> getAllProducts() {
        return products; // Alle Produkte anzeigen
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

