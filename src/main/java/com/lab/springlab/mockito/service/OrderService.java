package com.lab.springlab.mockito.service;

import com.lab.springlab.mockito.model.Order;
import com.lab.springlab.mockito.model.Product;
import com.lab.springlab.mockito.model.User;
import com.lab.springlab.mockito.repository.OrderRepository;
import com.lab.springlab.mockito.repository.ProductRepository;
import com.lab.springlab.mockito.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final NotificationClientService notificationClientService;

    @Transactional
    public Long order(Long productId, Long userId) {
        final Optional<Product> product = productRepository.findById(productId);

        final Optional<User> user = userRepository.findById(userId);

        final Order order = new Order(user.get(), product.get());
        orderRepository.save(order);

        notificationClientService.notifyToEmail();
        notificationClientService.notifyToMobile();

        return order.getId();
    }
}
