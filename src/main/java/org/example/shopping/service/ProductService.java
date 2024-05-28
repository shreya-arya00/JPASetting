package org.example.shopping.service;

import org.example.shopping.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.shopping.repository.ProductRepository;
import java.util.Collection;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }

    public Product findProductById(Integer productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
    }

    public Collection<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Collection<Product> findProductsByName(String name) {
        // Example of using a custom query method
        // Assumes ProductRepository has a method like List<Product> findByName(String name);
        return productRepository.findByName(name);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
