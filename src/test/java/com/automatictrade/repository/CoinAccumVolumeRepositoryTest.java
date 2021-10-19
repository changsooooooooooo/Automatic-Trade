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

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CoinAccumVolumeRepositoryTest {

    @Autowired
    private CoinAccumVolumeRepository coinAccumVolumeRepository;

    @Autowired
    private CoinDBRepository coinDBRepository;

    @Autowired
    private CoinTradeDBRepository coinTradeDBRepository;

    private CoinDAO coinDAO;
    private CoinThemeDAO coinThemeDAO;
    private CoinTradeRecordDAO coinTradeRecordDAO;

    @BeforeEach
    void setUp() {
        coinDAO = new CoinDAO().builder()
                .coinName("KRW-BTC")
                .build();

        coinThemeDAO = new CoinThemeDAO().builder()
                .coinDAO(coinDAO)
                .coinCategory("bitcoin")
                .build();

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

        coinDBRepository.save(coinThemeDAO);
        coinTradeDBRepository.save(coinTradeRecordDAO);
    }

    @Test
    @DisplayName("Builder Test")
    void buildTest(){
        assertEquals("1632217069000003", coinTradeRecordDAO.getSequentialID());
        assertEquals("KRW-BTH", coinThemeDAO.getCoinDAO().getCoinName());
    }

    @Test
    @DisplayName("Query Test")
    void insertQueryTest(){
        coinAccumVolumeRepository.insertIntoCoinAccumVolume();
        CoinAcuumVolumeDAO coinAcuumVolumeDAO = coinAccumVolumeRepository.findById(1L)
                .orElse(new CoinAcuumVolumeDAO());
        assertEquals(coinTradeRecordDAO.getTradeVolume(), coinAcuumVolumeDAO.getVolume());
    }
}
