package com.automatictrade.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoinThemeDAORepositoryTest {

    @Autowired
    private CoinThemeDAORepository coinThemeDAORepository;

    @Test
    void getDistinct(){
        List<String> coinList = coinThemeDAORepository.findDistinctCoins();
        for(String coin : coinList){
            System.out.println(coin);
        }
    }

}
