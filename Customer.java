package com.ust.ecomerce;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private Cart cart;

    public Customer(String name) {
        this.name = name;
        this.cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }

    // Method to add product to the customer's cart
    public void addToCart(Product product, int quantity) {
        cart.addProduct(product, quantity);
    }

    // Method to remove product from the customer's cart
    public void removeFromCart(Product product, int quantity) {
        cart.removeProduct(product, quantity);
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "'}";
    }
}
