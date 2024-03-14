package com.example.demo2;

import java.util.HashMap;
import java.util.Map;

public class OnlineStore {
    private String name;
    private Map<Product, Double> products = new HashMap<>();

    public OnlineStore(String name) {
        this.name = name;
    }

    public void addProduct(Product product, double price) {
        products.put(product, price);
    }

    public Map<Product, Double> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }
}
