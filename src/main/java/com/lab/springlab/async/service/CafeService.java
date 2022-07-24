package com.lab.springlab.async.service;

import java.util.concurrent.Future;

public interface CafeService {
    int getPrice(String name);
    Future<Integer> getPriceAsyncV1(String name);
    Future<Integer> getPriceAsyncV2(String name);
    Future<Integer> getDiscountPriceAsync(int price);
}
