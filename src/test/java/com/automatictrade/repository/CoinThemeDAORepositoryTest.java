package com.automatictrade.repository;

import com.automatictrade.data.entity.CoinEntity;
import com.automatictrade.data.entity.CoinThemeEntity;
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
    private CoinDAORepository coinDAORepository;

    @Autowired
    private CoinThemeDAORepository coinThemeDAORepository;

    private CoinEntity coinDAO;
    private CoinEntity coinDAO2;
    private CoinThemeEntity coinThemeDAO;
    private CoinThemeEntity coinThemeDAO2;

    @BeforeEach
    void setUp() {
        coinDAO = new CoinEntity().builder()
                .coinName("KRW-BTC")
                .build();

        coinDAORepository.save(coinDAO);

        coinDAO2 = new CoinEntity().builder()
                .coinName("KRW-ETH")
                .build();

        coinDAORepository.save(coinDAO2);

        coinThemeDAO = new CoinThemeEntity().builder()
                .coinDAO(coinDAO)
                .coinCategory("bitcoin")
                .build();

        coinThemeDAORepository.save(coinThemeDAO);

        coinThemeDAO = new CoinThemeEntity().builder()
                .coinDAO(coinDAO)
                .coinCategory("ethereum")
                .build();

        coinThemeDAORepository.save(coinThemeDAO);

        coinThemeDAO2 = new CoinThemeEntity().builder()
                .coinDAO(coinDAO2)
                .coinCategory("ethereum")
                .build();

        coinThemeDAORepository.save(coinThemeDAO2);

        coinThemeDAO2 = new CoinThemeEntity().builder()
                .coinDAO(coinDAO2)
                .coinCategory("bitcoin")
                .build();

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
        List<CoinThemeEntity> coinThemeDAOList = coinThemeDAORepository.findAllWithFetch();

        for(CoinThemeEntity coinThemeDAO : coinThemeDAOList){
            System.out.println(coinThemeDAO.getCoinDAO().getCoinName());
        }

        assertEquals(0, coinThemeDAOList.size());
    }

    @Test
    @DisplayName("Query Find All Test")
    void findAllTest(){
        List<CoinThemeEntity> coinThemeDAOList = coinThemeDAORepository.findAll();

        for(CoinThemeEntity coinThemeDAO : coinThemeDAOList){
            System.out.println(coinThemeDAO.getCoinDAO().getCoinName());
        }
    }
}
