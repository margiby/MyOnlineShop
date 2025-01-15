package de.kaufeDoch.models;

/* Das Product Interface repräsentiert ein generisches Produkt, das in meinem Online-Shop existieren kann.
 */
public interface Product {
    int getProductId();

    String getName();

    double getPrice();

    int getStock();

    void setStock(int stock);

    void setPrice(double newPrice);

}
