package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinAcuumVolumeDAO;
import com.automatictrade.data.dao.CoinDAO;
import com.automatictrade.data.dao.CoinThemeDAO;
import com.automatictrade.data.dao.CoinTradeRecordDAO;
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

    private CoinDAO coinDAO;
    private CoinDAO coinDAO2;
    private CoinThemeDAO coinThemeDAO;
    private CoinThemeDAO coinThemeDAO2;
    private CoinTradeRecordDAO coinTradeRecordDAO;
    private CoinTradeRecordDAO coinTradeRecordDAO2;

    @BeforeEach
    void setUp() {
        coinDAO = CoinDAO.builder()
                .coinName("KRW-BTC")
                .build();

        coinDAO2 = CoinDAO.builder()
                .coinName("KRW-ETH")
                .build();


        coinThemeDAO = CoinThemeDAO.builder()
                .coinDAO(coinDAO)
                .coinCategory("bitcoin")
                .build();

        coinThemeDAO2 = CoinThemeDAO.builder()
                .coinDAO(coinDAO2)
                .coinCategory("ethereum")
                .build();

        coinThemeDAORepository.save(coinThemeDAO);
        coinThemeDAORepository.save(coinThemeDAO2);

        coinTradeRecordDAO = CoinTradeRecordDAO.builder()
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

        coinTradeRecordDAO2 = CoinTradeRecordDAO.builder()
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
        List<CoinAcuumVolumeDAO> coinAcuumVolumeDAOList = coinAccumVolumeRepository.findAll();

        for(CoinAcuumVolumeDAO coinAcuumVolumeDAO : coinAcuumVolumeDAOList){
            System.out.println(coinAcuumVolumeDAO.getCoinDAO().getCoinName());
        }
    }

    @Test
    @DisplayName("Query Join Fetch Test")
    void joinFetchQueryTest(){
        coinAccumVolumeRepository.insertIntoCoinAccumVolume();
        List<CoinAcuumVolumeDAO> coinAcuumVolumeDAOList = coinAccumVolumeRepository.findAllWithFetch();

        for(CoinAcuumVolumeDAO coinAcuumVolumeDAO : coinAcuumVolumeDAOList){
            System.out.println(coinAcuumVolumeDAO.getCoinDAO().getCoinName());
        }
    }
}
