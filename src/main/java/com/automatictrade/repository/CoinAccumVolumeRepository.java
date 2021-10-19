package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinAcuumVolumeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoinAccumVolumeRepository extends JpaRepository<CoinAcuumVolumeDAO, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value="insert into coin_accum_volume (coin_name, time, volume, accumulate_volume)\n" +
            "select t.coin_name, t.time, max(t.volume) as volume, max(t.accumulate_volume) as accumulate_volume\n" +
            "from(\n" +
            "        select coin_name, substr(trade_time, 0, length(trade_time)-2) as time,\n" +
            "               sum(trade_volume) over(partition by substr(trade_time, 0, length(trade_time)-2) order by trade_time) as volume,\n" +
            "               sum(trade_volume) over(partition by code order by trade_time) as accumulate_volume from coin_trade\n" +
            "        order by code, time\n" +
            "        )t\n" +
            "group by t.coin_name, t.time\n" +
            "order by t.coin_name, t.time", nativeQuery = true)
    void insertIntoCoinAccumVolume();

    Optional<CoinAcuumVolumeDAO> findById(Long id);
}
