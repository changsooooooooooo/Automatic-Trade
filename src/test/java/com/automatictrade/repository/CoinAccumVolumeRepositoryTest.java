package com.automatictrade.repository;

import com.automatictrade.data.dao.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoinAccumVolumeRepositoryTest {

    private CoinThemeDAO coinThemeDAO;
    private CoinTradeRecordDAO coinTradeRecordDAO;

    @BeforeEach
    void setUp() {
        coinThemeDAO = CoinThemeDAO.builder()
                .coinThemeDTOPK(new CoinThemeDAOPK("KRW-BTH", "BTC"))
                .build();

        coinTradeRecordDAO = CoinTradeRecordDAO.builder()
                .coinTradeRecordDTOPK(new CoinTradeRecordDAOPK("KRW-BTH", "1632217069000003"))
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
    }

    @Test
    @DisplayName("Builder Test")
    void buildTest(){
        assertEquals("1632217069000003", coinTradeRecordDAO.getCoinTradeRecordDTOPK().getSequentialID());
        assertEquals("KRW-BTH", coinThemeDAO.getCoinThemeDTOPK().getCoinName());
    }

    @Test
    @DisplayName("Query Test")
    void insertQueryTest(){

    }
}
