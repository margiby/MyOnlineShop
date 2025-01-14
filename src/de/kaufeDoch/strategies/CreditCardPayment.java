package de.kaufeDoch.strategies;

// Implementiert die PaymentStrategy und repräsentiert eine Zahlung per Kreditkarte

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double totalAmount)  {
        System.out.println("Bezahlung per Kreditkarte: " + totalAmount+ "€.");
    }
}
