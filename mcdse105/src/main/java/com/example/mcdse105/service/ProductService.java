package com.example.mcdse105.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mcdse105.entity.Product;
import com.example.mcdse105.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProductDetails(Long id, Product product) {
        Product savedProduct = productRepository.findById(id).orElse(null);
        if (savedProduct != null) {
            savedProduct.setName(product.getName());
            savedProduct.setDescription(product.getDescription());
            savedProduct.setCategory(product.getCategory());
            savedProduct.setPrice(product.getPrice());
            savedProduct.setQuantity(product.getQuantity());
            return productRepository.save(savedProduct);
        }
        return null;
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
}
