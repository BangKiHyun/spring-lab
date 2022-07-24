package com.lab.springlab.event.v2;

import lombok.Getter;

@Getter
public class OrderRefundedEvent {

    private final Long orderId;

    public OrderRefundedEvent(Long orderId) {
        this.orderId = orderId;
    }
}
