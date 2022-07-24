//package com.lab.springlab.event.v1;
//
//import com.lab.springlab.event.OrderRefundService;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OrderRefundedHandler implements ApplicationListener<OrderRefundedEvent> {
//
//    private final OrderRefundService refundService;
//
//    public OrderRefundedHandler(OrderRefundService refundService) {
//        this.refundService = refundService;
//    }
//
//    @Override
//    public void onApplicationEvent(OrderRefundedEvent event) {
//        refundService.refund(event.getOrderId());
//    }
//}
