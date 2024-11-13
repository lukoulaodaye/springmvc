package org.example.redisexamples.service;

import lombok.extern.slf4j.Slf4j;
import org.example.redisexamples.dto.Item;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CountDownLatch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CountDownLatch;


@SpringBootTest
@Slf4j
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    void addItems() {
        List<Item> items = List.of(
                Item.builder().id("01JCG0K8A5WQDABDVC9AX1FCTW").total(30).build(),
                Item.builder().id("01JCG0K8A5XM5Q1HKSDA77DFP4").total(30).build()
        );
        orderService.addItem(items);

    }

    @Test
    void buy() throws InterruptedException {
        var count = 200;
        CountDownLatch latch = new CountDownLatch(count);
        Random random = new Random();
        for (int i = 0; i < 200; i++) {
            Thread.ofVirtual().start(()->{

                long buy = orderService.buy(
                        "01JCG0K8A5WQDABDVC9AX1FCTW", String.valueOf(random.nextInt
                        (count)));
                log.debug("剩余数量：{}", buy);
                latch.countDown();
            });
        }
        latch.await();
        Thread.sleep(6000);


    }
}