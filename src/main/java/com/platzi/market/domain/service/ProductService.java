package com.platzi.market.domain.service;


import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProducRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProducRepository producRepository;

    public List<Product> getAll() {
        return producRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return producRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return producRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity) {
        return producRepository.getScarseProducts(quantity);
    }

    public Product save(Product product) {
        return producRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            producRepository.delete(productId);
            return true;
        }).orElse(false);
    }


}
