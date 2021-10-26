package com.automatictrade.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Entity(name = "coin_train")
public class CoinTrainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="coin_name")
    private CoinEntity coinDAO;

    @Column(name="time")
    private Timestamp time;

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

    @Builder
    public CoinTrainEntity(CoinEntity coinDAO, Timestamp time, Double openingPrice, Double highPrice, Double lowPrice,
                           Double closingPrice, Double vwap) {
        this.coinDAO = coinDAO;
        this.time = time;
        this.openingPrice = openingPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.closingPrice = closingPrice;
        this.vwap = vwap;
    }
}
