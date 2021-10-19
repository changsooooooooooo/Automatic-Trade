package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinTrainDAO;
import com.automatictrade.data.dao.CoinTrainDAOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinTrainDBRepository extends JpaRepository<CoinTrainDAO, CoinTrainDAOPK> {

    @Query(value="insert into coin_train\n" +
            "select mm.coin_name,\n" +
            "       cc.timestamp as time,\n" +
            "       cc.close as close,\n" +
            "       mm.high as high,\n" +
            "       mm.low as low,\n" +
            "       co.open as open,\n" +
            "       (cav.volume*((co.open+mm.low+mm.high)/3))/cav.accumulate_volume as vwap\n" +
            "from coin_min_max mm\n" +
            "         left outer join coin_open co on mm.coin_name = co.coin_name and mm.time = co.time\n" +
            "         left outer join coin_close cc on mm.coin_name = cc.coin_name and mm.time = cc.time\n" +
            "         left outer join coin_accum_volume cav on mm.coin_name = cav.code and mm.time = cav.time\n" +
            "order by coin_name, time", nativeQuery = true)
    void insertInToCoinTrain();

}
