package com.automatictrade.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "coin_open")
public class CoinOpenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="coin_name")
    private CoinEntity coinDAO;

    @Column(name="time")
    private String time;

    @Column(name="open")
    private Double openPrice;

    @Builder
    public CoinOpenEntity(CoinEntity coinDAO, String time, Double openPrice){
        this.coinDAO = coinDAO;
        this.time = time;
        this.openPrice = openPrice;
    }
}
