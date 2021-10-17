package com.automatictrade.repository;

import com.automatictrade.data.dao.*;
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

    private CoinThemeDAO coinThemeDAO;
    private CoinSegmentDAOPK coinSegmentDAOPK;
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

        coinSegmentDAOPK = CoinSegmentDAOPK.builder()
                .code("KRW-BTH")
                .time("09:38")
                .build();

        coinDBRepository.save(coinThemeDAO);
        coinTradeDBRepository.save(coinTradeRecordDAO);
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
        coinAccumVolumeRepository.insertIntoCoinAccumVolume();
        CoinAcuumVolumeDAO coinAcuumVolumeDAO = coinAccumVolumeRepository.findById(coinSegmentDAOPK)
                .orElse(new CoinAcuumVolumeDAO());
        assertEquals(coinTradeRecordDAO.getTradeVolume(), coinAcuumVolumeDAO.getVolume());
    }
}
