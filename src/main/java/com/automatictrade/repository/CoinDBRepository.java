package com.automatictrade.repository;

import com.automatictrade.data.dao.CoinThemeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinDBRepository extends JpaRepository<CoinThemeDAO, Long> {

    @Query(value = "select distinct coin_name from coins", nativeQuery = true)
    List<String> findDistinctCoins();
}
