package com.leoshad9.product.controller;

import com.leoshad9.product.exception.ProductException;
import com.leoshad9.product.model.Product;
import com.leoshad9.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/view")
    public ResponseEntity<List<Product>> viewAllProducts() {
        try {
            List<Product> products = productService.viewAllProduct();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try {
            Product addedProduct = productService.addProduct(product);
            return new ResponseEntity<>(addedProduct, HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProductById(@PathVariable Integer productId, @RequestBody Product product) {
        try {
            product.setId(productId); // Ensure the ID matches the path variable
            Product updatedProduct = productService.updateProduct(product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/view/{productId}")
    public ResponseEntity<Product> viewProductById(@PathVariable Integer productId) {
        try {
            Product product = productService.viewProduct(productId);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<Product> removeProduct(@PathVariable Integer productId) {
        try {
            Product removedProduct = productService.removeProduct(productId);
            return new ResponseEntity<>(removedProduct, HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
