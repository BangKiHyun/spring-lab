package com.lab.springlab.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderRefundService {

    private final OrderRepository orderRepository;

    @EventListener
    public void refund(Long orderId) {
        final Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("not found order"));

        // 환불 로직
        log.info("환불 처리 완료");
    }
}
