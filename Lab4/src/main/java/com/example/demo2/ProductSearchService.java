package com.example.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductSearchService {
    private List<OnlineStore> stores = new ArrayList<>();

    public void addStore(OnlineStore store) {
        stores.add(store);
    }

    public double findMinimumPrice(String productName) {
        double minPrice = Double.MAX_VALUE;
        for (OnlineStore store : stores) {
            for (Map.Entry<Product, Double> entry : store.getProducts().entrySet()) {
                if (entry.getKey().getName().equals(productName) && entry.getValue() < minPrice) {
                    minPrice = entry.getValue();
                }
            }
        }
        return minPrice == Double.MAX_VALUE ? 0 : minPrice;
    }

    public List<String> storesWithMinimumPrice(String productName) {
        List<String> storeNames = new ArrayList<>();
        double minPrice = findMinimumPrice(productName);
        for (OnlineStore store : stores) {
            for (Map.Entry<Product, Double> entry : store.getProducts().entrySet()) {
                if (entry.getKey().getName().equals(productName) && entry.getValue() == minPrice) {
                    storeNames.add(store.getName());
                    break;
                }
            }
        }
        return storeNames;
    }
}
