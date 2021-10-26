package com.automatictrade.repository;

import com.automatictrade.data.entity.CoinThemeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinThemeDAORepository extends JpaRepository<CoinThemeEntity, Long> {

    @Query(value = "select distinct coin_name from coin_theme", nativeQuery = true)
    List<String> findDistinctCoins();

    @Query(value = "select ct from coin_theme ct join fetch ct.coinDAO")
    List<CoinThemeEntity> findAllWithFetch();
}
