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



/*        // Aktualisiert die Details eines Produkts
        public void updateProduct(int productId, String name, double price) {
            for (Product product : products) {
                if (product.getId() == productId) {
                    if (product instanceof Smartphone) {
                        ((Smartphone) product).setName(name);
                        ((Smartphone) product).setPrice(price);
                    }
                    // Weitere Produktarten können hier hinzugefügt werden
                }
            }
        }

        // Sucht nach einem Produkt basierend auf dem Namen
        public List<Product> searchProductsByName(String name) {
            List<Product> result = new ArrayList<>();
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(name)) {
                    result.add(product);
                }
            }
            return result;
        }
    }

*/
}