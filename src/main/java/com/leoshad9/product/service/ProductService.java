package com.leoshad9.product.service;

import java.util.List;

import com.leoshad9.product.exception.*;
import com.leoshad9.product.model.*;

public interface ProductService {

    List<Product> viewAllProduct() throws ProductException;

    Product addProduct(Product product) throws ProductException;

    Product updateProduct(Product product) throws ProductException;

    Product viewProduct(Integer productId) throws ProductException;

    Product removeProduct(Integer productId) throws ProductException;

}
