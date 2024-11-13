package org.example.redisexamples.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j

class ULIDTest {
    @Autowired
    private ULID ulid;

    @Test
    void nextULID() {
        //01JCG0K8A5WQDABDVC9AX1FCTW
        log.info(ulid.nextULID());
        //01JCG0K8A5XM5Q1HKSDA77DFP4
        log.info(ulid.nextULID());
        //01JCG6TE08MKP6ABTRKR2784QJ
        log.info(ulid.nextULID());
        //01JCG6TE08814YB0RAAW2QVWJW
        //01JCG6TE08G5V417BKWTZKYR79


    }
}