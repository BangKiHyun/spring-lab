package com.lab.springlab.mockito.repository;

import com.lab.springlab.mockito.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
