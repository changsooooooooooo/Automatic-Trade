package com.automatictrade.repository;

import com.automatictrade.data.entity.CoinCloseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinCloseRepository extends JpaRepository<CoinCloseEntity, Long> {

    @Query(value="insert into coin_close (coin_name, time, close)\n" +
            "select t.coin_name,\n" +
            "       substr(t.trade_time, 0, length(trade_time)-2) as time,\n" +
            "       t.trade_price as close,\n" +
            "from(\n" +
            "        select\n" +
            "            coin_name, trade_time, trade_price,\n" +
            "        from coin_trade\n" +
            "        where (coin_name, trade_time) in (\n" +
            "            select coin_name, max(trade_time) as trade_time\n" +
            "            from coin_trade group by coin_name, substr(trade_time, 0, length(trade_time)-2)\n" +
            "        )\n" +
            "        ) t\n" +
            "order by coin_name, time", nativeQuery = true)
    void insertInToCoinClose();
}
