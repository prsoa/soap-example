package com.vdfbdp.soapexample.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.vdfbdp.soapexample.Product;

import org.springframework.stereotype.Service;


@Service
public class ProductService {

    private static final Map<String, Product> products = new HashMap<>();

    @PostConstruct
    public void initialize() {

        Product apple = new Product();
        apple.setName("apple");
        apple.setSku(100);
        apple.setPrice(0.50);
        apple.setStock(150);

        Product pear = new Product();
        pear.setName("pear");
        pear.setSku(101);
        pear.setPrice(0.60);
        pear.setStock(50);

        products.put(apple.getName(), apple);
        products.put(pear.getName(), pear);
    }

    public Product getProducts(String name) {
        return products.get(name);
    } 
}
