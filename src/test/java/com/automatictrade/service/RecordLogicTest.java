package com.automatictrade.service;

import com.automatictrade.repository.CoinDBRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.List;

@SpringBootTest
class RecordLogicTest {

    @Autowired
    private CoinDBRepository coinDBRepository;

    @Test
    void archiFromMono() {
        List<String> coinList = coinDBRepository.findDistinctCoins();
        Flux<String> x = Flux.fromIterable(coinList);

    }
}
