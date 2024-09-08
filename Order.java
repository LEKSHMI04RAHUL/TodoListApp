package com.ust.ecomerce;

public class Order {
    private Customer customer;
    private Cart cart;
    private Payment paymentMethod;

    public Order(Customer customer, Payment paymentMethod) {
        this.customer = customer;
        this.cart = customer.getCart();
        this.paymentMethod = paymentMethod;
    }

    public void placeOrder() {
        System.out.println("Placing order for " + customer.getName());
        System.out.println("Products: ");
        for (Product p : cart.getProducts()) {
            System.out.println(p);
        }
        System.out.println("Total price: $" + cart.getTotalPrice());
        paymentMethod.processPayment(cart.getTotalPrice());
        System.out.println("Order placed successfully!");
    }
}

