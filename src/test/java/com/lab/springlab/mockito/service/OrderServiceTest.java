package com.lab.springlab.mockito.service;

import com.lab.springlab.mockito.model.Product;
import com.lab.springlab.mockito.model.User;
import com.lab.springlab.mockito.repository.OrderRepository;
import com.lab.springlab.mockito.repository.ProductRepository;
import com.lab.springlab.mockito.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("상품을 주문한다.")
    void orderTest() {

        //given
        final User user = new User("test@test.com", "1234", "bang", "010-1234-5678");
        userRepository.save(user);

        final Product product = new Product(user, "good product", 12000);
        productRepository.save(product);

        //when
        final Long orderId = orderService.order(product.getId(), user.getId());

        //then
        assertThat(orderId).isEqualTo(1L);
    }
}