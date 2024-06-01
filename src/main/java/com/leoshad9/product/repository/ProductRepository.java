package com.leoshad9.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.leoshad9.product.model.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
