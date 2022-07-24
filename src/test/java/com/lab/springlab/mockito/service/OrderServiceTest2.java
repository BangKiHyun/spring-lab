package com.lab.springlab.mockito.service;

import com.lab.springlab.mockito.model.Order;
import com.lab.springlab.mockito.model.Product;
import com.lab.springlab.mockito.model.User;
import com.lab.springlab.mockito.repository.OrderRepository;
import com.lab.springlab.mockito.repository.ProductRepository;
import com.lab.springlab.mockito.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderServiceTest2 {

    @Autowired
    private OrderService orderService;

    @MockBean(name = "orderRepository")
    private OrderRepository orderRepository;

    @MockBean(name = "productRepository")
    private ProductRepository productRepository;

    @MockBean(name = "userRepository")
    private UserRepository userRepository;

    @SpyBean
    private NotificationClientService notificationClientService;

    @Test
    @DisplayName("상품을 주문한다.")
    void orderTest() {
        //given
        User user = new User();
        given(userRepository.findById(1L))
                .willReturn(Optional.of(user));

        Product product = new Product();
        given(productRepository.findById(1L))
                .willReturn(Optional.of(product));

        Order order = Order.builder()
                .id(1L)
                .build();
        given(orderRepository.save(order))
                .willReturn(order);

        doAnswer(invocation -> {
            System.out.println("i'm spy notification client mobile service!");
            return null;
        }).when(notificationClientService).notifyToMobile();

        //when
        orderService.order(1L, 1L);

        //then
        assertThat(order.getId()).isEqualTo(1L);
    }
}
