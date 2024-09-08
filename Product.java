package com.ust.ecomerce;
public class Product {
    private String name;
    private double price;
    private String category;
    private int stock;

    public Product(String name, double price, String category, int stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) throws OutOfStockException {
        if (quantity > stock) {
            throw new OutOfStockException("Not enough stock for " + name);
        }
        stock -= quantity;
    }

    @Override
    public String toString() {
        return name + " (" + category + "): $" + price + " - Stock: " + stock;
    }
}
