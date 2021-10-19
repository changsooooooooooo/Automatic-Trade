package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinMinMaxDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinMinMaxRepository extends JpaRepository<CoinMinMaxDAO, Long> {

    @Query(value = "insert into coin_min_max\n" +
            "select coin_name,\n" +
            "   substr(trade_time, 0, length(trade_time)-2) as time,\n" +
            "   max(trade_price) as high,\n" +
            "   min(trade_price) as low from coin_trade\n" +
            "group by coin_name, substr(trade_time, 0, length(trade_time)-2)", nativeQuery = true)
    void insertInToCoinMinMax();
}
