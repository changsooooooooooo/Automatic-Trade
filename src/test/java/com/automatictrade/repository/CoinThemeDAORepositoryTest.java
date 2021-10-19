package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinDAO;
import com.automatictrade.data.dao.CoinThemeDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoinThemeDAORepositoryTest {

    @Autowired
    private CoinThemeDAORepository coinThemeDAORepository;

    private CoinDAO coinDAO;
    private CoinDAO coinDAO2;
    private CoinThemeDAO coinThemeDAO;
    private CoinThemeDAO coinThemeDAO2;

    @BeforeEach
    void setUp() {
        coinDAO = new CoinDAO().builder()
                .coinName("KRW-BTC")
                .build();

        coinDAO2 = new CoinDAO().builder()
                .coinName("KRW-ETH")
                .build();


        coinThemeDAO = new CoinThemeDAO().builder()
                .coinDAO(coinDAO)
                .coinCategory("bitcoin")
                .build();

        coinThemeDAO2 = new CoinThemeDAO().builder()
                .coinDAO(coinDAO2)
                .coinCategory("ethereum")
                .build();

        coinThemeDAORepository.save(coinThemeDAO);
        coinThemeDAORepository.save(coinThemeDAO2);
    }

    @Test
    void getDistinct() {
        List<String> coinList = coinThemeDAORepository.findDistinctCoins();
        for (String coin : coinList) {
            System.out.println(coin);
        }
    }

    @Test
    @DisplayName("Query Join Fetch Test")
    void joinFetchQueryTest(){
        List<CoinThemeDAO> coinThemeDAOList = coinThemeDAORepository.findAllWithFetch();

        for(CoinThemeDAO coinThemeDAO : coinThemeDAOList){
            System.out.println(coinThemeDAO.getCoinDAO().getCoinName());
        }

        assertEquals(0, coinThemeDAOList.size());
    }

    @Test
    @DisplayName("Query Find All Test")
    void findAllTest(){
        List<CoinThemeDAO> coinThemeDAOList = coinThemeDAORepository.findAll();

        for(CoinThemeDAO coinThemeDAO : coinThemeDAOList){
            System.out.println(coinThemeDAO.getCoinDAO().getCoinName());
        }
    }
}
