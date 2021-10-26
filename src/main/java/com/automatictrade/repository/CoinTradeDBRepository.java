package com.automatictrade.repository;

import com.automatictrade.data.entity.CoinTradeRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinTradeDBRepository extends JpaRepository<CoinTradeRecordEntity, Long> {

    @Query(value = "select ct from coin_trade ct join fetch ct.coinDAO")
    List<CoinTradeRecordEntity> findAllWithFetch();
}
