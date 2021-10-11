package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinCloseDAO;
import com.automatictrade.data.dao.CoinSegmentDAOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinCloseRepository extends JpaRepository<CoinCloseDAO, CoinSegmentDAOPK> {

    @Query(value="insert into coin_close (code, time, close, timestamp)\n" +
            "select t.code,\n" +
            "       substr(t.trade_time, 0, length(trade_time)-2) as time,\n" +
            "       t.trade_price as close,\n" +
            "       t.time_stamp as time_stamp\n" +
            "from(\n" +
            "        select\n" +
            "            code, trade_time, trade_price, to_timestamp(trade_timestamp/1000) +'9hours' as time_stamp\n" +
            "        from coin_trade\n" +
            "        where (code, trade_time) in (\n" +
            "            select code, max(trade_time) as trade_time\n" +
            "            from coin_trade group by code, substr(trade_time, 0, length(trade_time)-2)\n" +
            "        )\n" +
            "        ) t\n" +
            "order by code, time", nativeQuery = true)


    void insertInToCoinClose();
}
