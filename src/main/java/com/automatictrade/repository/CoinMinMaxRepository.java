package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinMinMaxDAO;
import com.automatictrade.data.dao.CoinSegmentDAOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinMinMaxRepository extends JpaRepository<CoinMinMaxDAO, CoinSegmentDAOPK> {

    @Query(value = "insert into coin_min_max\n" +
            "select code,\n" +
            "   substr(trade_time, 0, length(trade_time)-2) as time,\n" +
            "   max(trade_price) as high,\n" +
            "   min(trade_price) as low from coin_trade\n" +
            "group by code, substr(trade_time, 0, length(trade_time)-2)", nativeQuery = true)
    void insertInToCoinMinMax();
}
