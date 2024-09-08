package com.ust.ecomerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        try {
            product.reduceStock(quantity);
            for (int i = 0; i < quantity; i++) {
                products.add(product);
            }
            System.out.println(product.getName() + " added to the cart.");
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeProduct(Product product, int quantity) {
        int count = 0;
        for (int i = 0; i < quantity; i++) {
            if (products.remove(product)) {
                count++;
            }
        }
        System.out.println(count + " " + product.getName() + "(s) removed from the cart.");
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public List<Product> getProducts() {
        return products;
    }
}
