package de.kaufeDoch.strategies;

// Repräsentiert eine Zahlung per PayPal

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double totalAmount) {
        System.out.println("Bezahlung mit PayPal: " + totalAmount + "€.");
    }
}

