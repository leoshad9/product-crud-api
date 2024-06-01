package com.leoshad9.product.serviceimpl;

import com.leoshad9.product.exception.ProductException;
import com.leoshad9.product.model.Product;
import com.leoshad9.product.repository.ProductRepository;
import com.leoshad9.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> viewAllProduct() throws ProductException {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new ProductException("No products found");
        }
        return products;
    }

    @Override
    public Product addProduct(Product product) throws ProductException {
        if (productRepository.existsById(product.getId())) {
            throw new ProductException("Product with ID " + product.getId() + " already exists");
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) throws ProductException {
        if (!productRepository.existsById(product.getId())) {
            throw new ProductException("Product with ID " + product.getId() + " does not exist");
        }
        return productRepository.save(product);
    }

    @Override
    public Product viewProduct(Integer productId) throws ProductException {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new ProductException("Product with ID " + productId + " not found");
        }
        return productOptional.get();
    }

    @Override
    public Product removeProduct(Integer productId) throws ProductException {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new ProductException("Product with ID " + productId + " not found");
        }
        Product product = productOptional.get();
        productRepository.deleteById(productId);
        return product;
    }
}
