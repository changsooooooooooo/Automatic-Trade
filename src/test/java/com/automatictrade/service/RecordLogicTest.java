package com.automatictrade.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecordLogicTest {

    @Test
    void getBigDiffCandTest(int count){
        WebClient webClient = WebClient.create("https://api.upbit.com/v1/candles/days");
    }

}
