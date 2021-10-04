package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinOpenDAO;
import com.automatictrade.data.dao.CoinSegmentDAOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinOpenRepository extends JpaRepository<CoinOpenDAO, CoinSegmentDAOPK> {

    @Query(value="insert into coin_open\n" +
            "select t.code,\n" +
            "       substr(t.trade_time, 0, length(trade_time)-2) as time,\n" +
            "       t.trade_price as open\n" +
            "from(\n" +
            "        select\n" +
            "            code, trade_time, trade_price\n" +
            "        from coin_trade\n" +
            "        where (code, trade_time) in (\n" +
            "            select code, min(trade_time) as trade_time\n" +
            "            from coin_trade group by code, substr(trade_time, 0, length(trade_time)-2)\n" +
            "        )\n" +
            "    ) t\n" +
            "order by code, time", nativeQuery = true)
    void insertInToCoinOpen();
}
