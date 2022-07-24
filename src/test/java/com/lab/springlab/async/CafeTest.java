package com.lab.springlab.async;

import com.lab.springlab.async.repository.CafeRepository;
import com.lab.springlab.async.service.CafeServiceImplement;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        CafeServiceImplement.class,
        CafeRepository.class})
public class CafeTest {

    @Autowired
    private CafeServiceImplement cafeServiceImplement;

    @Test
    public void 가격_조회_동기_블로킹_호출_테스트() throws Exception {
        //given
        int expectedPrice = 4100;

        //when
        final int actualPrice = cafeServiceImplement.getPrice("iceAmericano");
        cafeServiceImplement.getPrice("iceAmericano");
        log.info("최종 가격 전달 받음");

        //then
        assertThat(expectedPrice).isEqualTo(actualPrice);
    }

    @Test
    public void 가격_조회_비동기_블로킹_호출_테스트_V1() throws Exception {
        //given
        int expectedPrice = 4100;

        //when
        final CompletableFuture<Integer> future = cafeServiceImplement.getPriceAsyncV1("iceAmericano");
        cafeServiceImplement.getPriceAsyncV1("iceAmericano");
        log.info("최종 데이터를 전달 받지는 않았지만 다른 작업 수행 가능");
        int actualPrice = future.join();
        log.info("최종 가격 전달 받음");

        //then
        assertThat(expectedPrice).isEqualTo(actualPrice);
    }

    @Test
    public void 가격_조회_비동기_블로킹_호출_테스트_V2() throws Exception {
        //given
        int expectedPrice = 4100;

        //when
        final CompletableFuture<Integer> future = cafeServiceImplement.getPriceAsyncV2("iceAmericano");
        cafeServiceImplement.getPriceAsyncV2("iceAmericano");
        log.info("최종 데이터를 전달 받지는 않았지만 다른 작업 수행 가능");
        int actualPrice = future.join();
        log.info("최종 가격 전달 받음");

        //then
        assertThat(expectedPrice).isEqualTo(actualPrice);
    }

    @Test
    public void 가격_조회_비동기_논블로킹_호출_반환없음_테스트() throws Exception {
        //given
        int expectedPrice = 4100;

        //when
        final CompletableFuture<Void> future = cafeServiceImplement
                .getPriceAsyncV2("iceAmericano")
                .thenAccept(p -> {
                    log.info("콜백, 가격: " + p + "원");
                    assertThat(expectedPrice).isEqualTo(p);
                });
        log.info("최종 데이터를 전달 받지는 않았지만 다른 작업 수행 가능, Non-Blocking");

        //then
        assertThat(future.join()).isNull();
    }

    @Test
    public void 가격_조회_비동기_논블로킹_호출_반환_테스트() throws Exception {
        //given
        int expectedPrice = 4100;

        //when
        final CompletableFuture<Integer> future = cafeServiceImplement
                .getPriceAsyncV2("iceAmericano")
                .thenApply(p -> {
                    log.info("같은 쓰레드로 동작");
                    return p;
                });
        log.info("최종 데이터를 전달 받지는 않았지만 다른 작업 수행 가능, Non-Blocking");

        //then
        assertThat(future.join()).isEqualTo(expectedPrice);
    }
}
