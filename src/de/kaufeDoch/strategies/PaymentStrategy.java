package de.kaufeDoch.strategies;

// Das PaymentStrategy Interface definiert die Methode, die alle Zahlungsstrategien implementieren müssen
public interface PaymentStrategy {
    void pay(double totalAmount);
}

