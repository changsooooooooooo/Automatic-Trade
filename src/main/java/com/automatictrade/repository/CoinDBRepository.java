package com.automatictrade.repository;

import com.automatictrade.dto.CoinThemeDTO;
import com.automatictrade.dto.CoinThemeDTOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinDBRepository extends JpaRepository<CoinThemeDTO, CoinThemeDTOPK> {

    @Query(value = "select coin_name from coins where coin_category= :theme", nativeQuery = true)
    List<String> findCoinCadidatesByTheme(@Param(value="theme") String theme);

    @Query(value = "select coin_category from coins where coin_name= :name", nativeQuery = true)
    String findCoinCategory(@Param(value="name") String name);
}
