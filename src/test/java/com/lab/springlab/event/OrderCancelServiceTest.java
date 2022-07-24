//package com.lab.springlab.event;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.Optional;
//
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//class OrderCancelServiceTest {
//
//    @Autowired
//    private OrderRefundService orderRefundService;
//    @MockBean
//    private OrderRepository orderRepository;
//    @MockBean
//    private OrderCancelService orderCancelService;
//
//    @Test
//    @DisplayName("주문에서 이벤트를 발생시켜 환불이 잘 되는지 확인한다.")
//    public void cancelTest() throws Exception {
//        //given
//        long orderId = 7;
//        when(orderRepository.findById(orderId)).thenReturn(Optional.of(new Order(orderId)));
//
//        //when
//        orderCancelService.cancel(orderId);
//
//        //then
//        verify(orderCancelService, times(1)).cancel(orderId);
//    }
//}