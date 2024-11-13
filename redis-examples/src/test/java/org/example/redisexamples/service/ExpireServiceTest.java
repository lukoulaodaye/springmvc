package org.example.redisexamples.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.FunctionMode;
import org.redisson.api.FunctionResult;
import org.redisson.api.RFunction;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.IntegerCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j

class ExpireServiceTest {
    @Autowired
    private ExpireService expireService;
    @Autowired
    private RedissonClient client;

    @Test
    void expire()throws InterruptedException {

        for(int i= 0;i< 6;i++){
            boolean expire = expireService.expire("api:522",5,2);
            log.debug("{}",expire);
            TimeUnit.SECONDS.sleep(1);

        }

    }

}