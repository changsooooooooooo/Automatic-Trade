package com.automatictrade.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "coin_min_max")
public class CoinMinMaxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="coin_name")
    private CoinEntity coinDAO;

    @Column(name="time")
    private String time;

    @Column(name="low")
    private Double minPrice;

    @Column(name="high")
    private Double highPrice;

    @Builder
    public CoinMinMaxEntity(CoinEntity coinDAO, String time, Double minPrice, Double highPrice){
        this.coinDAO = coinDAO;
        this.time = time;
        this.minPrice = minPrice;
        this.highPrice = highPrice;
    }

}
