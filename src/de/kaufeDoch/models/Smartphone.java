
package de.kaufeDoch.models;

// Die Smartphone Klasse implementiert das Product Interface und repräsentiert ein wiederaufbereitetes Smartphone
public class Smartphone implements Product {
    private int productId;
    private String name;
    private String brand; // Marke des Smartphones
    private String model; // Modell des Smartphones
    private double price;
    private int stock; // Lagerbestand
    private boolean isRefurbished; // Refurbished-Flag

    // Konstruktor, um ein Smartphone mit allen Attributen zu erstellen
    public Smartphone(int productId, String brand, String model, double price, int stock, boolean isRefurbished) {
        if (brand == null || model == null) {
            throw new IllegalArgumentException("Brand and model cannot be null");
        }
        this.productId = productId;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
        this.name = brand + " " + model;
        this.isRefurbished = isRefurbished;
    }

    // Getter-Methoden
    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getStock() {
        return stock;
    }

    public boolean isRefurbished() {
        return isRefurbished;
    }


    // Setter-Methoden
    @Override
    public void setStock(int stock) { // Lagerbestand ändern
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.stock = stock;
    }

    public void setPrice(double price) {   // Preis ändern
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setRefurbished(boolean isRefurbished) {
        this.isRefurbished = isRefurbished; // Refurbished-Status ändern
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "Produkt-ID: " + productId +
                " | Marke: " + brand +
                " | Modell: " + model +
                " | Preis: " + price + "€" +
                " | Lagerbestand: " + stock +
                " | Refurbished: " + (isRefurbished ? "Ja" : "Nein") +
                '}';
    }
}



