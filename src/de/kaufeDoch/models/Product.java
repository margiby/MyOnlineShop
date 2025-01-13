package de.kaufeDoch.models;

/* Das Product Interface repräsentiert ein generisches Produkt, das in meinem Online-Shop existieren kann.
     Das Interface ist absichtlich minimalistisch gehalten, damit es für verschiedene Arten von Produkten flexibel bleibt.
 */
public interface Product {
    int getId();
    String getName();
    double getPrice();

}