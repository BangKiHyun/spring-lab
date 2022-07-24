package com.lab.springlab.event.v2;

import com.lab.springlab.event.OrderRefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderRefundedHandler {

    private final OrderRefundService refundService;

    @Async
    @EventListener
    public void refund(OrderRefundedEvent event) {
        refundService.refund(event.getOrderId());
    }
}
