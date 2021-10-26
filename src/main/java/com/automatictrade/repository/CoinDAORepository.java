package com.automatictrade.repository;

import com.automatictrade.data.entity.CoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinDAORepository extends JpaRepository<CoinEntity, String> {

    @Query(value="select distinct cl from coin_list cl join fetch cl.coinThemeDAOList")
    List<CoinEntity> findAllWithFetch();

}
