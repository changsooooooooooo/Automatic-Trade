package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinTradeRecordDAO;
import com.automatictrade.data.dao.CoinTradeRecordDAOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinTradeDBRepository extends JpaRepository<CoinTradeRecordDAO, CoinTradeRecordDAOPK> {

}
