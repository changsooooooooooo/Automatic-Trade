package com.automatictrade.service;

import com.automatictrade.repository.CoinDBRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.time.Duration;
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

    @Test
    void intervalFluxTest(){
        List<String> coinList = coinDBRepository.findDistinctCoins();
        System.out.println("size : "+coinList.size());
        Flux<List<String>> x = Flux.interval(Duration.ofSeconds(coinList.size()/10))
                .map(tick->coinList.subList(tick.intValue()*10, (tick.intValue()+1)*10));

        System.out.println("x : "+x);
        System.out.println(x.subscribe());
        x.subscribe(
                content->{
                    System.out.println(content.size());
                    for(String str : content){
                        System.out.print(str);
                    }
                    System.out.println();
                }
        );
    }
}
