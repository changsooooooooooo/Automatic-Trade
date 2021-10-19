package com.automatictrade.data.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "coin_close")
@NoArgsConstructor
public class CoinCloseDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="coin_name")
    private CoinDAO coinDAO;

    @Column(name="time")
    private String time;

    @Column(name="close")
    private Double closePrice;

    @Builder
    public CoinCloseDAO(CoinDAO coinDAO, String time, Double closePrice){
        this.coinDAO = coinDAO;
        this.time = time;
        this.closePrice = closePrice;
    }
}
