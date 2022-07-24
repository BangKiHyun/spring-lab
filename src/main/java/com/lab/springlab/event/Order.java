package com.lab.springlab.event;

import com.lab.springlab.event.v2.OrderRefundedEvent;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

import javax.persistence.Column;

@Slf4j
@Getter
public class Order {

    @Column(name = "order_id")
    private Long orderId;

    private OrderStatus status;

    public Order(Long orderId) {
        this.orderId = orderId;
        this.status = OrderStatus.PAYMENT_WAITING;
    }

    public void cancel(ApplicationEventPublisher publisher) {
        log.info("주문 verify not yet shipped");
        verifyNotYetShipped();
        this.status = OrderStatus.CANCELED;
        try {
            publisher.publishEvent(new OrderRefundedEvent(orderId));
        } catch (AlreadyShippedException e) {
            log.error(e.getLocalizedMessage());
        }
    }

    private void verifyNotYetShipped() {
        if (!isNotYetShipped())
            throw new AlreadyShippedException("order is already shipped");
    }

    public boolean isNotYetShipped() {
        return status == OrderStatus.PAYMENT_WAITING || status == OrderStatus.PREPARING;
    }
}
