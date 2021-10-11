package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinTrainDAO;
import com.automatictrade.data.dao.CoinTrainDAOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinTrainDBRepository extends JpaRepository<CoinTrainDAO, CoinTrainDAOPK> {

    @Query(value="insert into coin_train\n" +
            "select mm.code as market,\n" +
            "       cc.timestamp as time,\n" +
            "       cc.close as close,\n" +
            "       mm.high as high,\n" +
            "       mm.low as low,\n" +
            "       co.open as open,\n" +
            "       (cav.volume*((co.open+mm.low+mm.high)/3))/cav.accumulate_volume as vwap\n" +
            "from coin_min_max mm\n" +
            "         left outer join coin_open co on mm.code = co.code and mm.time = co.time\n" +
            "         left outer join coin_close cc on mm.code = cc.code and mm.time = cc.time\n" +
            "         left outer join coin_accum_volume cav on mm.code = cav.code and mm.time = cav.time\n" +
            "order by market, time", nativeQuery = true)
    void insertInToCoinTrain();
}
