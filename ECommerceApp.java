package com.ust.ecomerce;

public class ECommerceApp {
    public static void main(String[] args) {
        // Create products
        Product phone = new Product("Smartphone", 699.99, "Electronics");
        Product laptop = new Product("Laptop", 1299.99, "Electronics");
        Product book = new Product("Book", 19.99, "Books");

        // Create a customer
        Customer customer = new Customer("Alice");

        // Add products to cart
        customer.addToCart(phone);
        customer.addToCart(book);
        customer.addToCart(laptop);

        // Choose a payment method
        Payment payment = new CreditCardPayment("1234-5678-9876-5432");

        // Place the order
        Order order = new Order(customer, payment);
        order.placeOrder();
    }
}
