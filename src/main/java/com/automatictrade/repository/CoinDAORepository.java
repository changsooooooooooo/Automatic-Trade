package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinDAORepository extends JpaRepository<CoinDAO, String> {
}
