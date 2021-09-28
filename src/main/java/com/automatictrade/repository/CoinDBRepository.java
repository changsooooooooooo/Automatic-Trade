package com.automatictrade.repository;

import com.automatictrade.dto.CoinThemeDTO;
import com.automatictrade.dto.CoinThemeDTOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinDBRepository extends JpaRepository<CoinThemeDTO, CoinThemeDTOPK> {

    @Query(value = "select distinct coin_name from coins", nativeQuery = true)
    List<String> findDistinctCoins();
}
