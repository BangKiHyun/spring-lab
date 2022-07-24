package com.lab.springlab.async.service;

import com.lab.springlab.async.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CafeServiceImplement {

    private final CafeRepository cafeRepository;
    Executor executor = Executors.newFixedThreadPool(10);

    public int getPrice(String name) {
        log.info("동기 호출 방식으로 가격 조회 시작");
        return cafeRepository.getPriceByName(name);
    }

    // blocking + nonblocking
    public CompletableFuture<Integer> getPriceAsyncV1(String name) {
        log.info("비동기 호출 방식으로 가격 조회 시작");
        CompletableFuture<Integer> future = new CompletableFuture<>();

        new Thread(() -> {
            log.info("새로운 쓰레드로 작업 시작");
            Integer price = cafeRepository.getPriceByName(name);
            future.complete(price);
        }).start();

        return future;
    }

    // blocking + nonblocking
    public CompletableFuture<Integer> getPriceAsyncV2(String name) {
        log.info("비동기 호출 방식으로 가격 조회 시작");
        return CompletableFuture.supplyAsync(() -> {
                    log.info("Supply Async 실행");
                    return cafeRepository.getPriceByName(name);
                },
                executor);
    }
}
