package com.automatictrade.repository;

import com.automatictrade.data.entity.CoinAcuumVolumeEntity;
import com.automatictrade.data.entity.CoinEntity;
import com.automatictrade.data.entity.CoinThemeEntity;
import com.automatictrade.data.entity.CoinTradeRecordEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CoinAccumVolumeRepositoryTest {

    @Autowired
    private CoinAccumVolumeRepository coinAccumVolumeRepository;

    @Autowired
    private CoinThemeDAORepository coinThemeDAORepository;

    @Autowired
    private CoinTradeDBRepository coinTradeDBRepository;

    private CoinEntity coinDAO;
    private CoinEntity coinDAO2;
    private CoinThemeEntity coinThemeDAO;
    private CoinThemeEntity coinThemeDAO2;
    private CoinTradeRecordEntity coinTradeRecordDAO;
    private CoinTradeRecordEntity coinTradeRecordDAO2;

    @BeforeEach
    void setUp() {
        coinDAO = CoinEntity.builder()
                .coinName("KRW-BTC")
                .build();

        coinDAO2 = CoinEntity.builder()
                .coinName("KRW-ETH")
                .build();


        coinThemeDAO = CoinThemeEntity.builder()
                .coinDAO(coinDAO)
                .coinCategory("bitcoin")
                .build();

        coinThemeDAO2 = CoinThemeEntity.builder()
                .coinDAO(coinDAO2)
                .coinCategory("ethereum")
                .build();

        coinThemeDAORepository.save(coinThemeDAO);
        coinThemeDAORepository.save(coinThemeDAO2);

        coinTradeRecordDAO = CoinTradeRecordEntity.builder()
                .coinDAO(coinDAO)
                .sequentialID("1632217069000003")
                .tradeDate("2021-09-21")
                .tradeVolume(0.02153283)
                .tradePrice(265750.0)
                .tradeTime("09:38:50")
                .tradeType("BID")
                .tradeTimestamp(1632217069000L)
                .dataType("trade")
                .changePrice(2950.0)
                .streamType("SNAPSHOT")
                .changeType("RISE")
                .prevClosingPrice(262800.0)
                .timestamp(1632217069340L)
                .build();

        coinTradeRecordDAO2 = CoinTradeRecordEntity.builder()
                .coinDAO(coinDAO2)
                .sequentialID("1632217069000003")
                .tradeDate("2021-09-21")
                .tradeVolume(0.02153283)
                .tradePrice(265750.0)
                .tradeTime("09:38:50")
                .tradeType("BID")
                .tradeTimestamp(1632217069000L)
                .dataType("trade")
                .changePrice(2950.0)
                .streamType("SNAPSHOT")
                .changeType("RISE")
                .prevClosingPrice(262800.0)
                .timestamp(1632217069340L)
                .build();

        coinTradeDBRepository.save(coinTradeRecordDAO);
        coinTradeDBRepository.save(coinTradeRecordDAO2);
    }

    @Test
    @DisplayName("Builder Test")
    void buildTest(){
        assertEquals("1632217069000003", coinTradeRecordDAO.getSequentialID());
        assertEquals("KRW-BTC", coinThemeDAO.getCoinDAO().getCoinName());
    }

    @Test
    @DisplayName("Query Test")
    void insertQueryTest(){
        coinAccumVolumeRepository.insertIntoCoinAccumVolume();
        List<CoinAcuumVolumeEntity> coinAcuumVolumeDAOList = coinAccumVolumeRepository.findAll();

        for(CoinAcuumVolumeEntity coinAcuumVolumeDAO : coinAcuumVolumeDAOList){
            System.out.println(coinAcuumVolumeDAO.getCoinDAO().getCoinName());
        }
    }

    @Test
    @DisplayName("Query Join Fetch Test")
    void joinFetchQueryTest(){
        coinAccumVolumeRepository.insertIntoCoinAccumVolume();
        List<CoinAcuumVolumeEntity> coinAcuumVolumeDAOList = coinAccumVolumeRepository.findAllWithFetch();

        for(CoinAcuumVolumeEntity coinAcuumVolumeDAO : coinAcuumVolumeDAOList){
            System.out.println(coinAcuumVolumeDAO.getCoinDAO().getCoinName());
        }
    }
}
