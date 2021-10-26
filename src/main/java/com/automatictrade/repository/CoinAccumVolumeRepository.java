package com.automatictrade.repository;

import com.automatictrade.data.entity.CoinAcuumVolumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinAccumVolumeRepository extends JpaRepository<CoinAcuumVolumeEntity, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value="insert into coin_accum_volume (coin_name, time, volume, accumulate_volume)\n" +
            "select t.coin_name, t.time, max(t.volume) as volume, max(t.accumulate_volume) as accumulate_volume\n" +
            "from(\n" +
            "        select coin_name, substr(trade_time, 0, length(trade_time)-2) as time,\n" +
            "               sum(trade_volume) over(partition by substr(trade_time, 0, length(trade_time)-2) order by trade_time) as volume,\n" +
            "               sum(trade_volume) over(partition by coin_name order by trade_time) as accumulate_volume from coin_trade\n" +
            "        order by coin_name, time\n" +
            "        )t\n" +
            "group by t.coin_name, t.time\n" +
            "order by t.coin_name, t.time", nativeQuery = true)
    void insertIntoCoinAccumVolume();

    @Query(value = "select av from coin_accum_volume av join fetch av.coinDAO")
    List<CoinAcuumVolumeEntity> findAllWithFetch();
}
