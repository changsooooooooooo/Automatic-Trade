package com.automatictrade.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoinDBRepositoryTest {

    @Autowired
    private CoinDBRepository coinDBRepository;

    @Test
    void getDistinct(){
        List<String> coinList = coinDBRepository.findDistinctCoins();
        for(String coin : coinList){
            System.out.println(coin);
        }
    }

}
