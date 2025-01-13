package de.kaufeDoch.services;

import de.kaufeDoch.models.Product;

import java.util.ArrayList;
import java.util.List;

/*
    Der ProductService Klasse verwaltet die Liste der Produkte im Shop.
 */

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);   // Fügt ein Produkt zur Liste hinzu
    }
    public void removeProduct(Product product) {
        products.remove(product);  // Entfernt ein Produkt aus der Liste
    }
    public List<Product> getAllProducts() {
        return products; // Gibt die Liste aller Produkte zurück
    }
}
