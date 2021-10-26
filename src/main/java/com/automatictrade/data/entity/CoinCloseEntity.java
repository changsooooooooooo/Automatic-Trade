package com.automatictrade.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "coin_close")
@NoArgsConstructor
public class CoinCloseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="coin_name")
    private CoinEntity coinDAO;

    @Column(name="time")
    private String time;

    @Column(name="close")
    private Double closePrice;

    @Builder
    public CoinCloseEntity(CoinEntity coinDAO, String time, Double closePrice){
        this.coinDAO = coinDAO;
        this.time = time;
        this.closePrice = closePrice;
    }
}
