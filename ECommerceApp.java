package com.ust.ecomerce;

public class ECommerceApp {
    public static void main(String[] args) {
        // Create products
        Product phone = new Product("Smartphone", 699.99, "Electronics", 10);
        Product laptop = new Product("Laptop", 1299.99, "Electronics", 0); // Out of stock
        Product book = new Product("Book", 19.99, "Books", 50);

        // Create a customer
        Customer customer = new Customer("Alice");

        // Add products to cart
        customer.addToCart(phone, 1);
        customer.addToCart(book, 2);
        customer.addToCart(laptop, 1); // This should trigger an OutOfStockException

        // Choose a payment method
        Payment payment = new CreditCardPayment(""); // Invalid credit card

        // Place the order
        Order order = new Order(customer, payment);
        order.placeOrder();
    }
}
