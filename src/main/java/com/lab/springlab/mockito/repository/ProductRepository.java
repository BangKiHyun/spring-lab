package com.lab.springlab.mockito.repository;

import com.lab.springlab.mockito.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
