package com.automatictrade.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coin_train")
public class CoinTrainDTO {

    @EmbeddedId
    private CoinTrainDTOPK coinTrainDTOPK;

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
