package com.automatictrade.data.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "coin_train")
public class CoinTrainDAO {

    @EmbeddedId
    private CoinTrainDAOPK coinTrainDTOPK;

    @Column(name = "open")
    private Double openingPrice;

    @Column(name = "high")
    private Double highPrice;

    @Column(name = "low")
    private Double lowPrice;

    @Column(name = "close")
    private Double closingPrice;

    @Column(name = "vwap")
    private Double vwap;
}
