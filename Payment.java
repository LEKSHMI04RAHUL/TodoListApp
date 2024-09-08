package com.ust.ecomerce;

public abstract class Payment {
    public abstract void processPayment(double amount) throws InvalidPaymentException;
}

class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) throws InvalidPaymentException {
        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new InvalidPaymentException("Invalid credit card information.");
        }
        System.out.println("Processing credit card payment for $" + amount);
    }
}

class PayPalPayment extends Payment {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) throws InvalidPaymentException {
        if (email == null || email.isEmpty()) {
            throw new InvalidPaymentException("Invalid PayPal email.");
        }
        System.out.println("Processing PayPal payment for $" + amount);
    }
}
