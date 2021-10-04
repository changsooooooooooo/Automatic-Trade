package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinTrainDAO;
import com.automatictrade.data.dao.CoinTrainDAOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinTrainDBRepository extends JpaRepository<CoinTrainDAO, CoinTrainDAOPK> {

//    @Query()
//    void insertToTable();

}
