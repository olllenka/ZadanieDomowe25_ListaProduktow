package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository(){
        products = new ArrayList<>();
    }

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> getAll() {
        return new ArrayList<>(products);
    }

    public double getPricesSum() {
        double sum = 0;
        for (Product product : products) {
            sum+=product.getPrice();
        }
        return sum;
    }
}
