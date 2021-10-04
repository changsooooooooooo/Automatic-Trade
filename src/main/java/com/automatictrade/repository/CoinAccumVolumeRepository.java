package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinAcuumVolumeDAO;
import com.automatictrade.data.dao.CoinSegmentDAOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinAccumVolumeRepository extends JpaRepository<CoinAcuumVolumeDAO, CoinSegmentDAOPK> {

    @Query(value="insert into coin_accum_volume\n" +
            "select t.code, t.time, max(t.accumulate_volume) as accumulate_volume\n" +
            "from(\n" +
            "        select code, substr(trade_time, 0, length(trade_time)-2) as time,\n" +
            "               sum(trade_volume) over(partition by code order by trade_time) as accumulate_volume from coin_trade\n" +
            "        order by time\n" +
            "        )t\n" +
            "group by t.code, t.time\n" +
            "order by t.code, t.time", nativeQuery = true)
    void insertIntoCoinAccumVolume();
}
