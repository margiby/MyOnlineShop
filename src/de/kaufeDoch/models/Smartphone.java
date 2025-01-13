package de.kaufeDoch.models;
/*
  Die Smartphoneklasse implementiert das Product Interface und repräsentiert ein wiederaufbereitetes Smartphone
 */

public class Smartphone implements Product {
    private int id;
    private String name;
    private double price;
    private String brand;
    private String model;
    private int storage;
    private boolean isRefurbished;

    //Konstruktor

    public Smartphone(int id, String name, double price, String brand, String model, int storage, boolean isRefurbished) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.storage = storage;
        this.isRefurbished = isRefurbished;
    }


    // Getter
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getStorage() {
        return storage;
    }

    public boolean isRefurbished() {
        return isRefurbished;
    }


    // // Überschreibt die toString Methode, um eine String-Darstellung des Smartphones zu geben
    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", storage=" + storage +
                ", isRefurbished=" + isRefurbished +
                '}';
    }
}


