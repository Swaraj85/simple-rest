package com.swaraj.functionality1.service;

import com.swaraj.functionality1.exception.ProductNotFoundException;
import com.swaraj.functionality1.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("product1", "electronics", 10),
            new Product("product2", "electronics", 20),
            new Product("product3", "education", 30),
            new Product("product4", "education", 40),
            new Product("product5", "education", 50)
    ));


    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> getProductsByType(String productType) {
        List<Product> productsByType = products
                .stream()
                .filter(p -> p.getProductType().equalsIgnoreCase(productType))
                .collect(Collectors.toList());

        return Optional.of(productsByType)
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new ProductNotFoundException("product not available of type " + productType));
    }

    public int save(Product product) {
        products.add(product);
        return products.size() - 1;
    }

    public void update(int index, Product updateProduct) {
        products.set(index, updateProduct);
    }
}
