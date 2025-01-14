package de.kaufeDoch.strategies;

// Kontextklasse, die die Auswahl und Nutzung einer Zahlungsstrategie kapselt
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Wir setzen die aktuelle Zahlungsstrategie
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Führt die Zahlung mit der festgelegten Strategie aus
    public void pay(double totalAmount) {
        if (paymentStrategy != null) {
        paymentStrategy.pay(totalAmount);
        } else {
        System.out.println("Bitte wählen Sie eine Zahlungsstrategie aus.");
        }

    }

}